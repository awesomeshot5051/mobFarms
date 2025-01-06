package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.horse.*;

import java.lang.ref.*;

public class HorseFarmRenderer extends RendererBase<HorseFarmTileentity> {

    private WeakReference<Horse> horseCache = new WeakReference<>(null);
    private WeakReference<HorseRenderer> horseRendererCache = new WeakReference<>(null);

    public HorseFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(HorseFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Horse horse = horseCache.get();
        if (horse == null) {
            horse = new Horse(EntityType.HORSE, minecraft.level);
            horseCache = new WeakReference<>(horse);
        }

        HorseRenderer horseRenderer = horseRendererCache.get();
        if (horseRenderer == null) {
            horseRenderer = new HorseRenderer(createEntityRenderer());
            horseRendererCache = new WeakReference<>(horseRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= HorseFarmTileentity.getHorseSpawnTime(farm) && farm.getTimer() < HorseFarmTileentity.getHorseKillTime(farm)) {
            renderMob(matrixStack);
            matrixStack.scale(0.7F, 0.7F, 0.7F);
            horseRenderer.render(horse, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }
}
