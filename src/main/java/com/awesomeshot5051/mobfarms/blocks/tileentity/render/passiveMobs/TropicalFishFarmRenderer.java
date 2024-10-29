package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TropicalFishFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.TropicalFishRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.TropicalFish;

import java.lang.ref.WeakReference;

public class TropicalFishFarmRenderer extends RendererBase<TropicalFishFarmTileentity> {

    private WeakReference<TropicalFish> tropicalFishCache = new WeakReference<>(null);
    private WeakReference<TropicalFishRenderer> tropicalFishRendererCache = new WeakReference<>(null);

    public TropicalFishFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(TropicalFishFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        TropicalFish tropicalFish = tropicalFishCache.get();
        if (tropicalFish == null) {
            tropicalFish = new TropicalFish(EntityType.TROPICAL_FISH, minecraft.level);
            tropicalFishCache = new WeakReference<>(tropicalFish);
        }

        TropicalFishRenderer tropicalFishRenderer = tropicalFishRendererCache.get();
        if (tropicalFishRenderer == null) {
            tropicalFishRenderer = new TropicalFishRenderer(createEntityRenderer());
            tropicalFishRendererCache = new WeakReference<>(tropicalFishRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= TropicalFishFarmTileentity.getTropicalFishSpawnTime() && farm.getTimer() < TropicalFishFarmTileentity.getTropicalFishKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            tropicalFishRenderer.render(tropicalFish, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
