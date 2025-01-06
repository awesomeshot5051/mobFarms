package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.*;

import java.lang.ref.*;

public class SquidFarmRenderer extends RendererBase<SquidFarmTileentity> {

    private WeakReference<Squid> squidCache = new WeakReference<>(null);
    private WeakReference<SquidRenderer> squidRendererCache = new WeakReference<>(null);

    public SquidFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SquidFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Squid squid = squidCache.get();
        if (squid == null) {
            squid = new Squid(EntityType.SQUID, minecraft.level);
            squidCache = new WeakReference<>(squid);
        }

        SquidRenderer squidRenderer = squidRendererCache.get();
        if (squidRenderer == null) {
            SquidModel<Squid> squidModel = new SquidModel<>(createEntityRenderer().bakeLayer(ModelLayers.SQUID));
            squidRenderer = new SquidRenderer(createEntityRenderer(), squidModel);
            squidRendererCache = new WeakReference<>(squidRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SquidFarmTileentity.getSquidSpawnTime(farm) && farm.getTimer() < SquidFarmTileentity.getSquidKillTime(farm)) {
            renderMob(matrixStack);
            squidRenderer.render(squid, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
