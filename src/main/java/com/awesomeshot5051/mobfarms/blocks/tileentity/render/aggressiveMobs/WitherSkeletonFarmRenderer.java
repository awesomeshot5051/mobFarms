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

public class WitherSkeletonFarmRenderer extends RendererBase<WitherSkeletonFarmTileentity> {

    private WeakReference<WitherSkeleton> witherSkeletonCache = new WeakReference<>(null);
    private WeakReference<WitherSkeletonRenderer> witherSkeletonRendererCache = new WeakReference<>(null);

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

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WitherSkeletonFarmTileentity.getWitherSkeletonSpawnTime(farm) && farm.getTimer() < WitherSkeletonFarmTileentity.getWitherSkeletonExplodeTime(farm)) {
            renderMob(matrixStack);
            witherSkeletonRenderer.render(witherSkeleton, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
