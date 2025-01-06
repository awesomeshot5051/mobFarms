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
import net.minecraft.world.entity.animal.goat.*;

import java.lang.ref.*;

public class GoatFarmRenderer extends RendererBase<GoatFarmTileentity> {

    private WeakReference<Goat> goatCache = new WeakReference<>(null);
    private WeakReference<GoatRenderer> goatRendererCache = new WeakReference<>(null);

    public GoatFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(GoatFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();


        Goat goat = goatCache.get();
        if (goat == null) {
            goat = new Goat(EntityType.GOAT, minecraft.level);
            goatCache = new WeakReference<>(goat);
        }

        GoatRenderer goatRenderer = goatRendererCache.get();
        if (goatRenderer == null) {
            goatRenderer = new GoatRenderer(createEntityRenderer());
            goatRendererCache = new WeakReference<>(goatRenderer);
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

        if (farm.getTimer() >= GoatFarmTileentity.getGoatSpawnTime(farm) && farm.getTimer() < GoatFarmTileentity.getGoatKillTime(farm)) {
            renderMob(matrixStack);
            if (farm.getTimer() % 20 < 10) {
                goat.hurtTime = 20;
            } else {
                goat.hurtTime = 0;
            }
            goatRenderer.render(goat, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
