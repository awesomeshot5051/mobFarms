package com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.SpiderFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;

import java.lang.ref.WeakReference;

public class SpiderFarmRenderer extends RendererBase<SpiderFarmTileentity> {

    private WeakReference<Spider> spiderCache = new WeakReference<>(null);
    private WeakReference<SpiderRenderer> spiderRendererCache = new WeakReference<>(null);
    private LivingEntityRenderState spiderRenderState;
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
        spiderRenderState = getRenderState(spiderRenderer, spiderRenderState);
        Direction direction = Direction.SOUTH;


        matrixStack.pushPose();
        matrixStack.translate(0.5D, 1D / 16D, 0.5D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        matrixStack.translate(5D / 16D, 0D, -5D / 16D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
        matrixStack.scale(0.3F, 0.3F, 0.3F);
        matrixStack.popPose();

        if (farm.getTimer() >= SpiderFarmTileentity.getSpiderSpawnTime() && farm.getTimer() < SpiderFarmTileentity.getSpiderKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            if (farm.getTimer() % 20 < 10) {
                spider.hurtTime = 20;
            } else {
                spider.hurtTime = 0;
            }
            spiderRenderer.render(spiderRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
