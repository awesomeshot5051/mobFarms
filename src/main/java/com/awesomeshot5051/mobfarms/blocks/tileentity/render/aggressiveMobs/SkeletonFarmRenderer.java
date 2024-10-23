package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SkeletonFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;

import java.lang.ref.WeakReference;

public class SkeletonFarmRenderer extends RendererBase<SkeletonFarmTileentity> {

    private WeakReference<Skeleton> skeletonCache = new WeakReference<>(null);
    private WeakReference<SkeletonRenderer> skeletonRendererCache = new WeakReference<>(null);

    public SkeletonFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SkeletonFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Skeleton skeleton = skeletonCache.get();
        if (skeleton == null) {
            skeleton = new Skeleton(EntityType.SKELETON, minecraft.level);
            skeletonCache = new WeakReference<>(skeleton);
        }

        SkeletonRenderer skeletonRenderer = skeletonRendererCache.get();
        if (skeletonRenderer == null) {
            skeletonRenderer = new SkeletonRenderer(createEntityRenderer());
            skeletonRendererCache = new WeakReference<>(skeletonRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SkeletonFarmTileentity.getSkeletonSpawnTime() && farm.getTimer() < SkeletonFarmTileentity.getSkeletonExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            skeletonRenderer.render(skeleton, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
