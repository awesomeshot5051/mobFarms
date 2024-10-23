package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PillagerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.PillagerRenderer;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Pillager;

import java.lang.ref.WeakReference;

public class PillagerFarmRenderer extends RendererBase<PillagerFarmTileentity> {

    private WeakReference<Pillager> pillagerCache = new WeakReference<>(null);
    private WeakReference<PillagerRenderer> pillagerRendererCache = new WeakReference<>(null);
    private IllagerRenderState pillagerRenderState;
    public PillagerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(PillagerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Pillager pillager = pillagerCache.get();
        if (pillager == null) {
            pillager = new Pillager(EntityType.PILLAGER, minecraft.level);
            pillagerCache = new WeakReference<>(pillager);
        }

        PillagerRenderer pillagerRenderer = pillagerRendererCache.get();
        if (pillagerRenderer == null) {
            pillagerRenderer = new PillagerRenderer(createEntityRenderer());
            pillagerRendererCache = new WeakReference<>(pillagerRenderer);
        }
        pillagerRenderState = getRenderState(pillagerRenderer, pillagerRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PillagerFarmTileentity.getPillagerSpawnTime() && farm.getTimer() < PillagerFarmTileentity.getPillagerExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            pillagerRenderer.render(pillagerRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
