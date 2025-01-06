package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.*;

import java.lang.ref.*;

public class CowFarmRenderer extends RendererBase<CowFarmTileentity> {

    private WeakReference<Cow> cowCache = new WeakReference<>(null);
    private WeakReference<CowRenderer> cowRendererCache = new WeakReference<>(null);

    public CowFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(CowFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Cow cow = cowCache.get();
        if (cow == null) {
            cow = new Cow(EntityType.COW, minecraft.level);
            cowCache = new WeakReference<>(cow);
        }

        CowRenderer cowRenderer = cowRendererCache.get();
        if (cowRenderer == null) {
            cowRenderer = new CowRenderer(createEntityRenderer());
            cowRendererCache = new WeakReference<>(cowRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= CowFarmTileentity.getCowSpawnTime(farm) && farm.getTimer() < CowFarmTileentity.getCowKillTime(farm)) {
            renderMob(matrixStack);
            cowRenderer.render(cow, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
