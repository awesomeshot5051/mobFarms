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

public class SpiderFarmRenderer extends RendererBase<SpiderFarmTileentity> {

    private WeakReference<Spider> spiderCache = new WeakReference<>(null);
    private WeakReference<SpiderRenderer> spiderRendererCache = new WeakReference<>(null);

    public SpiderFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SpiderFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();


        Spider spider = spiderCache.get();
        if (spider == null) {
            spider = new Spider(EntityType.SPIDER, minecraft.level);
            spiderCache = new WeakReference<>(spider);
        }

        SpiderRenderer spiderRenderer = spiderRendererCache.get();
        if (spiderRenderer == null) {
            spiderRenderer = new SpiderRenderer(createEntityRenderer());
            spiderRendererCache = new WeakReference<>(spiderRenderer);
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

        if (farm.getTimer() >= SpiderFarmTileentity.getSpiderSpawnTime(farm) && farm.getTimer() < SpiderFarmTileentity.getSpiderKillTime(farm)) {
            renderMob(matrixStack);
            if (farm.getTimer() % 20 < 10) {
                spider.hurtTime = 20;
            } else {
                spider.hurtTime = 0;
            }
            spiderRenderer.render(spider, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
