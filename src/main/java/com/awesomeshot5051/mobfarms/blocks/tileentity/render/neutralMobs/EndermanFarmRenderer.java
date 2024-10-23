package com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.EndermanFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.state.EndermanRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;

import java.lang.ref.WeakReference;

public class EndermanFarmRenderer extends RendererBase<EndermanFarmTileentity> {

    private WeakReference<EnderMan> endermanCache = new WeakReference<>(null);
    private WeakReference<EndermanRenderer> endermanRendererCache = new WeakReference<>(null);
    private EndermanRenderState endermanRenderState;
    public EndermanFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(EndermanFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        EnderMan enderman = endermanCache.get();
        if (enderman == null) {
            enderman = new EnderMan(EntityType.ENDERMAN, minecraft.level);
            endermanCache = new WeakReference<>(enderman);
        }

        EndermanRenderer endermanRenderer = endermanRendererCache.get();
        if (endermanRenderer == null) {
            endermanRenderer = new EndermanRenderer(createEntityRenderer());
            endermanRendererCache = new WeakReference<>(endermanRenderer);
        }
        endermanRenderState = getRenderState(endermanRenderer, endermanRenderState);
        Direction direction = Direction.SOUTH;

        matrixStack.pushPose();
        matrixStack.translate(0.5D, 1D / 16D, 0.5D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        matrixStack.translate(5D / 16D, 0D, -5D / 16D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
        matrixStack.scale(0.3F, 0.3F, 0.3F);
        matrixStack.popPose();

        if (farm.getTimer() >= EndermanFarmTileentity.getEndermanSpawnTime() && farm.getTimer() < EndermanFarmTileentity.getEndermanKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            if (farm.getTimer() % 20 < 10) {
                enderman.hurtTime = 20;
            } else {
                enderman.hurtTime = 0;
            }
            endermanRenderer.render(endermanRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
