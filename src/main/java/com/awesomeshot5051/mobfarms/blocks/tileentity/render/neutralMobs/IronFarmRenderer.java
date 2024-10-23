package com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.IronFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.client.renderer.entity.state.IronGolemRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;

import java.lang.ref.WeakReference;

public class IronFarmRenderer extends RendererBase<IronFarmTileentity> {

    private WeakReference<IronGolem> ironGolemCache = new WeakReference<>(null);
    private WeakReference<IronGolemRenderer> ironGolemRendererCache = new WeakReference<>(null);
    private IronGolemRenderState ironGolemRenderState;
    public IronFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(IronFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        IronGolem ironGolem = ironGolemCache.get();
        if (ironGolem == null) {
            ironGolem = new IronGolem(EntityType.IRON_GOLEM, minecraft.level);
            ironGolemCache = new WeakReference<>(ironGolem);
        }

        IronGolemRenderer ironGolemRenderer = ironGolemRendererCache.get();
        if (ironGolemRenderer == null) {
            ironGolemRenderer = new IronGolemRenderer(createEntityRenderer());
            ironGolemRendererCache = new WeakReference<>(ironGolemRenderer);
        }


        Direction direction = Direction.SOUTH;
        ironGolemRenderState = getRenderState(ironGolemRenderer, ironGolemRenderState);
//        if (farm.getVillagerEntity() != null) {
//            matrixStack.pushPose();
//            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
//            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
//            matrixStack.translate(-5D / 16D, 0D, -5D / 16D);
//            matrixStack.mulPose(Axis.YP.rotationDegrees(90));
//            matrixStack.scale(0.3F, 0.3F, 0.3F);
//            getVillagerRenderer().render(farm.getVillagerEntity(), matrixStack, buffer, combinedLight);
//            matrixStack.popPose();
//        }

        matrixStack.pushPose();
        matrixStack.translate(0.5D, 1D / 16D, 0.5D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        matrixStack.translate(5D / 16D, 0D, -5D / 16D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
        matrixStack.scale(0.3F, 0.3F, 0.3F);
        ironGolemRenderer.render(ironGolemRenderState, matrixStack, buffer, combinedLight);
        matrixStack.popPose();

        if (farm.getTimer() >= IronFarmTileentity.getGolemSpawnTime() && farm.getTimer() < IronFarmTileentity.getGolemKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            if (farm.getTimer() % 20 < 10) {
                ironGolem.hurtTime = 20;
            } else {
                ironGolem.hurtTime = 0;
            }
            ironGolemRenderer.render(ironGolemRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
