package com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.PiglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.PiglinRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.piglin.Piglin;

import java.lang.ref.WeakReference;

public class PiglinFarmRenderer extends RendererBase<PiglinFarmTileentity> {

    private WeakReference<Piglin> piglinCache = new WeakReference<>(null);
    private WeakReference<PiglinRenderer> piglinRendererCache = new WeakReference<>(null);

    public PiglinFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(PiglinFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();


        // Retrieve or create Piglin entity and renderer
        Piglin piglin = piglinCache.get();
        if (piglin == null) {
            piglin = new Piglin(EntityType.PIGLIN, minecraft.level);
            piglinCache = new WeakReference<>(piglin);
        }

        PiglinRenderer piglinRenderer = piglinRendererCache.get();
        if (piglinRenderer == null) {
            // Corrected PiglinRenderer constructor with required arguments
            piglinRenderer = new PiglinRenderer(
                    createEntityRenderer(),
                    ModelLayers.PIGLIN,
                    ModelLayers.PIGLIN_INNER_ARMOR,
                    ModelLayers.PIGLIN_OUTER_ARMOR,
                    false // noRightEar set to false for adult Piglin
            );
            piglinRendererCache = new WeakReference<>(piglinRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getVillagerEntity() != null) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(-5D / 16D, 0D, -5D / 16D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(90));
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            getVillagerRenderer().render(farm.getVillagerEntity(), 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.pushPose();
        matrixStack.translate(0.5D, 1D / 16D, 0.5D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        matrixStack.translate(5D / 16D, 0D, -5D / 16D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
        matrixStack.scale(0.3F, 0.3F, 0.3F);
        matrixStack.popPose();

        if (farm.getTimer() >= PiglinFarmTileentity.getPiglinSpawnTime() && farm.getTimer() < PiglinFarmTileentity.getPiglinKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            if (farm.getTimer() % 20 < 10) {
                piglin.hurtTime = 20;
            } else {
                piglin.hurtTime = 0;
            }
            piglinRenderer.render(piglin, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }
}
