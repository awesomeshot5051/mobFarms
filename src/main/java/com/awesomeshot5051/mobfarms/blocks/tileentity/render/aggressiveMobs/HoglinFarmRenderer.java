package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.HoglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.HoglinRenderer;
import net.minecraft.client.renderer.entity.state.HoglinRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.hoglin.Hoglin;

import java.lang.ref.WeakReference;

public class HoglinFarmRenderer extends RendererBase<HoglinFarmTileentity> {

    private WeakReference<Hoglin> hoglinCache = new WeakReference<>(null);
    private WeakReference<HoglinRenderer> hoglinRendererCache = new WeakReference<>(null);
    private HoglinRenderState hoglinRenderState;
    public HoglinFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(HoglinFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Hoglin hoglin = hoglinCache.get();
        if (hoglin == null) {
            hoglin = new Hoglin(EntityType.HOGLIN, minecraft.level);
            hoglinCache = new WeakReference<>(hoglin);
        }

        HoglinRenderer hoglinRenderer = hoglinRendererCache.get();
        if (hoglinRenderer == null) {
            hoglinRenderer = new HoglinRenderer(createEntityRenderer());
            hoglinRendererCache = new WeakReference<>(hoglinRenderer);
        }
        hoglinRenderState = getRenderState(hoglinRenderer, hoglinRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= HoglinFarmTileentity.getHoglinSpawnTime() && farm.getTimer() < HoglinFarmTileentity.getHoglinExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            hoglinRenderer.render(hoglinRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
