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

public class MagmaCubeFarmRenderer extends RendererBase<MagmaCubeFarmTileentity> {

    private WeakReference<MagmaCube> magmaCubeCache = new WeakReference<>(null);
    private WeakReference<MagmaCubeRenderer> magmaCubeRendererCache = new WeakReference<>(null);

    public MagmaCubeFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(MagmaCubeFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        MagmaCube magmaCube = magmaCubeCache.get();
        if (magmaCube == null) {
            magmaCube = new MagmaCube(EntityType.MAGMA_CUBE, minecraft.level);
            magmaCubeCache = new WeakReference<>(magmaCube);
        }

        MagmaCubeRenderer magmaCubeRenderer = magmaCubeRendererCache.get();
        if (magmaCubeRenderer == null) {
            magmaCubeRenderer = new MagmaCubeRenderer(createEntityRenderer());
            magmaCubeRendererCache = new WeakReference<>(magmaCubeRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= MagmaCubeFarmTileentity.getMagmaCubeSpawnTime(farm) && farm.getTimer() < MagmaCubeFarmTileentity.getMagmaCubeExplodeTime(farm)) {
            renderMob(matrixStack);
            magmaCubeRenderer.render(magmaCube, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
