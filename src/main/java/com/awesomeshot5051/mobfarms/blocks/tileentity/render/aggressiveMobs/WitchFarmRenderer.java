package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;

import java.lang.ref.*;

public class WitchFarmRenderer extends RendererBase<WitchFarmTileentity> {

    private WeakReference<Witch> witchCache = new WeakReference<>(null);
    private WeakReference<WitchRenderer> witchRendererCache = new WeakReference<>(null);

    public WitchFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(WitchFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Witch witch = witchCache.get();
        if (witch == null) {
            witch = new Witch(EntityType.WITCH, minecraft.level);
            witchCache = new WeakReference<>(witch);
        }

        WitchRenderer witchRenderer = witchRendererCache.get();
        if (witchRenderer == null) {
            witchRenderer = new WitchRenderer(createEntityRenderer());
            witchRendererCache = new WeakReference<>(witchRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WitchFarmTileentity.getWitchSpawnTime(farm) && farm.getTimer() < WitchFarmTileentity.getWitchExplodeTime(farm)) {
            renderMob(matrixStack);
            witchRenderer.render(witch, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
