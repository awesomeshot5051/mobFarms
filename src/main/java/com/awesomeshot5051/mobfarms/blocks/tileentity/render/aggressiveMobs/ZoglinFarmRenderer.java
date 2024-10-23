package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZoglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ZoglinRenderer;
import net.minecraft.client.renderer.entity.state.HoglinRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zoglin;

import java.lang.ref.WeakReference;

public class ZoglinFarmRenderer extends RendererBase<ZoglinFarmTileentity> {

    private WeakReference<Zoglin> zoglinCache = new WeakReference<>(null);
    private WeakReference<ZoglinRenderer> zoglinRendererCache = new WeakReference<>(null);
    private HoglinRenderState zoglinRenderState;

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
        zoglinRenderState = getRenderState(zoglinRenderer, zoglinRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ZoglinFarmTileentity.getZoglinSpawnTime() && farm.getTimer() < ZoglinFarmTileentity.getZoglinExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            zoglinRenderer.render(zoglinRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
