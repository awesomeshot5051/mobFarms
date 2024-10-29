package com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.ZombifiedPiglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.PiglinRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.ZombifiedPiglin;

import java.lang.ref.WeakReference;

public class ZombifiedPiglinFarmRenderer extends RendererBase<ZombifiedPiglinFarmTileentity> {

    private WeakReference<ZombifiedPiglin> zombifiedPiglinCache = new WeakReference<>(null);
    private WeakReference<PiglinRenderer> piglinRendererCache = new WeakReference<>(null);

    public ZombifiedPiglinFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ZombifiedPiglinFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();


        // Retrieve or create ZombifiedPiglin entity and renderer
        ZombifiedPiglin zombifiedPiglin = zombifiedPiglinCache.get();
        if (zombifiedPiglin == null) {
            zombifiedPiglin = new ZombifiedPiglin(EntityType.ZOMBIFIED_PIGLIN, minecraft.level);
            zombifiedPiglinCache = new WeakReference<>(zombifiedPiglin);
        }

        PiglinRenderer piglinRenderer = piglinRendererCache.get();
        if (piglinRenderer == null) {
            piglinRenderer = new PiglinRenderer(
                    createEntityRenderer(),
                    ModelLayers.ZOMBIFIED_PIGLIN,
                    ModelLayers.ZOMBIFIED_PIGLIN_INNER_ARMOR,
                    ModelLayers.ZOMBIFIED_PIGLIN_OUTER_ARMOR,
                    true // noRightEar set to true for zombified piglin
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

        if (farm.getTimer() >= ZombifiedPiglinFarmTileentity.getZombifiedPiglinSpawnTime() && farm.getTimer() < ZombifiedPiglinFarmTileentity.getZombifiedPiglinKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            if (farm.getTimer() % 20 < 10) {
                zombifiedPiglin.hurtTime = 20;
            } else {
                zombifiedPiglin.hurtTime = 0;
            }
            piglinRenderer.render(zombifiedPiglin, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }
}