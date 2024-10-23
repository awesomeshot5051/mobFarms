package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.HorseFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.state.HorseRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.Horse;

import java.lang.ref.WeakReference;

public class HorseFarmRenderer extends RendererBase<HorseFarmTileentity> {

    private WeakReference<Horse> horseCache = new WeakReference<>(null);
    private WeakReference<HorseRenderer> horseRendererCache = new WeakReference<>(null);
    private HorseRenderState horseRenderState;
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
        horseRenderState = getRenderState(horseRenderer, horseRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= HorseFarmTileentity.getHorseSpawnTime() && farm.getTimer() < HorseFarmTileentity.getHorseKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 0D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 0.2D);
            matrixStack.scale(0.4F, 0.4F, 0.4F);
            horseRenderer.render(horseRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }
}
