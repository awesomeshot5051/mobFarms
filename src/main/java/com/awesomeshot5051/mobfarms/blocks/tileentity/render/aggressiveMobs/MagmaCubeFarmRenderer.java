package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.MagmaCubeFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.MagmaCubeRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.MagmaCube;

import java.lang.ref.WeakReference;

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

        if (farm.getTimer() >= MagmaCubeFarmTileentity.getMagmaCubeSpawnTime() && farm.getTimer() < MagmaCubeFarmTileentity.getMagmaCubeExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            magmaCubeRenderer.render(magmaCube, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
