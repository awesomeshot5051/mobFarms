package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;

import java.lang.ref.*;

public class ZoglinFarmRenderer extends RendererBase<ZoglinFarmTileentity> {

    private WeakReference<Zoglin> zoglinCache = new WeakReference<>(null);
    private WeakReference<ZoglinRenderer> zoglinRendererCache = new WeakReference<>(null);

    public ZoglinFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ZoglinFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Zoglin zoglin = zoglinCache.get();
        if (zoglin == null) {
            zoglin = new Zoglin(EntityType.ZOGLIN, minecraft.level);
            zoglinCache = new WeakReference<>(zoglin);
        }

        ZoglinRenderer zoglinRenderer = zoglinRendererCache.get();
        if (zoglinRenderer == null) {
            zoglinRenderer = new ZoglinRenderer(createEntityRenderer());
            zoglinRendererCache = new WeakReference<>(zoglinRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ZoglinFarmTileentity.getZoglinSpawnTime(farm) && farm.getTimer() < ZoglinFarmTileentity.getZoglinExplodeTime(farm)) {
            renderMob(matrixStack);
            zoglinRenderer.render(zoglin, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
