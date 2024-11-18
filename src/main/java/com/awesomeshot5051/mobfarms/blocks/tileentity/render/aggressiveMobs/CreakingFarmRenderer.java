package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.CreakingFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.CreakingRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.creaking.Creaking;

import java.lang.ref.WeakReference;

public class CreakingFarmRenderer extends RendererBase<CreakingFarmTileentity> {

    private WeakReference<Creaking> creakingCache = new WeakReference<>(null);
    private WeakReference<CreakingRenderer> creakingRendererCache = new WeakReference<>(null);
    private LivingEntityRenderState creakingRenderState;
    public CreakingFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(CreakingFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Creaking creaking = creakingCache.get();
        if (creaking == null) {
            assert minecraft.level != null;
            creaking = new Creaking(EntityType.CREAKING, minecraft.level);
            creakingCache = new WeakReference<>(creaking);
        }

        CreakingRenderer creakingRenderer = creakingRendererCache.get();
        if (creakingRenderer == null) {
            creakingRenderer = new CreakingRenderer(createEntityRenderer());
            creakingRendererCache = new WeakReference<>(creakingRenderer);
        }
        creakingRenderState = getRenderState(creakingRenderer, creakingRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= CreakingFarmTileentity.getCreakingSpawnTime() && farm.getTimer() < CreakingFarmTileentity.getCreakingExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            creakingRenderer.render(creakingRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }
}
