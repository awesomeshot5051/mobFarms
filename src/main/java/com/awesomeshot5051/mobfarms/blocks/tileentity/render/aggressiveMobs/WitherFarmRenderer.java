package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherBossRenderer;
import net.minecraft.client.renderer.entity.state.WitherRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.wither.WitherBoss;

import java.lang.ref.WeakReference;

public class WitherFarmRenderer extends RendererBase<WitherFarmTileentity> {

    private WeakReference<WitherBoss> witherCache = new WeakReference<>(null);
    private WeakReference<WitherBossRenderer> witherRendererCache = new WeakReference<>(null);
    private WitherRenderState witherRenderState;
    public WitherFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(WitherFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        WitherBoss wither = witherCache.get();
        if (wither == null) {
            wither = new WitherBoss(EntityType.WITHER, minecraft.level);
            witherCache = new WeakReference<>(wither);
        }

        WitherBossRenderer witherRenderer = witherRendererCache.get();
        if (witherRenderer == null) {
            witherRenderer = new WitherBossRenderer(createEntityRenderer());
            witherRendererCache = new WeakReference<>(witherRenderer);
        }
        witherRenderState = getRenderState(witherRenderer, witherRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WitherFarmTileentity.getWitherSpawnTime() && farm.getTimer() < WitherFarmTileentity.getWitherExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            witherRenderer.render(witherRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
