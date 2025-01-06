package com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;

import java.lang.ref.*;

public class EndermanFarmRenderer extends RendererBase<EndermanFarmTileentity> {

    private WeakReference<EnderMan> endermanCache = new WeakReference<>(null);
    private WeakReference<EndermanRenderer> endermanRendererCache = new WeakReference<>(null);

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

        if (farm.getTimer() >= EndermanFarmTileentity.getEndermanSpawnTime(farm) && farm.getTimer() < EndermanFarmTileentity.getEndermanKillTime(farm)) {
            renderMob(matrixStack);
            if (farm.getTimer() % 20 < 10) {
                enderman.hurtTime = 20;
            } else {
                enderman.hurtTime = 0;
            }
            endermanRenderer.render(enderman, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
