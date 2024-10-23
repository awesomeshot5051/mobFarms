package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherSkeletonFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.WitherSkeleton;

import java.lang.ref.WeakReference;

public class WitherSkeletonFarmRenderer extends RendererBase<WitherSkeletonFarmTileentity> {

    private WeakReference<WitherSkeleton> witherSkeletonCache = new WeakReference<>(null);
    private WeakReference<WitherSkeletonRenderer> witherSkeletonRendererCache = new WeakReference<>(null);
    private SkeletonRenderState witherSkeletonRenderState;
    public WitherSkeletonFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(WitherSkeletonFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        WitherSkeleton witherSkeleton = witherSkeletonCache.get();
        if (witherSkeleton == null) {
            witherSkeleton = new WitherSkeleton(EntityType.WITHER_SKELETON, minecraft.level);
            witherSkeletonCache = new WeakReference<>(witherSkeleton);
        }

        WitherSkeletonRenderer witherSkeletonRenderer = witherSkeletonRendererCache.get();
        if (witherSkeletonRenderer == null) {
            witherSkeletonRenderer = new WitherSkeletonRenderer(createEntityRenderer());
            witherSkeletonRendererCache = new WeakReference<>(witherSkeletonRenderer);
        }
        witherSkeletonRenderState = getRenderState(witherSkeletonRenderer, witherSkeletonRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WitherSkeletonFarmTileentity.getWitherSkeletonSpawnTime() && farm.getTimer() < WitherSkeletonFarmTileentity.getWitherSkeletonExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            witherSkeletonRenderer.render(witherSkeletonRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
