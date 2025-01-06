package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.*;

import java.lang.ref.*;

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

        if (farm.getTimer() >= TropicalFishFarmTileentity.getTropicalFishSpawnTime(farm) && farm.getTimer() < TropicalFishFarmTileentity.getTropicalFishKillTime(farm)) {
            renderMob(matrixStack);
            tropicalFishRenderer.render(tropicalFish, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
