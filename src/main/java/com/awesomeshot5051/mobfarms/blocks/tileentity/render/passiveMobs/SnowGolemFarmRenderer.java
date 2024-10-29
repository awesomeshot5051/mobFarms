package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SnowGolemFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SnowGolemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.SnowGolem;

import java.lang.ref.WeakReference;

public class SnowGolemFarmRenderer extends RendererBase<SnowGolemFarmTileentity> {

    private WeakReference<SnowGolem> snowGolemCache = new WeakReference<>(null);
    private WeakReference<SnowGolemRenderer> snowGolemRendererCache = new WeakReference<>(null);

    public SnowGolemFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SnowGolemFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        SnowGolem snowGolem = snowGolemCache.get();
        if (snowGolem == null) {
            snowGolem = new SnowGolem(EntityType.SNOW_GOLEM, minecraft.level);
            snowGolemCache = new WeakReference<>(snowGolem);
        }

        SnowGolemRenderer snowGolemRenderer = snowGolemRendererCache.get();
        if (snowGolemRenderer == null) {
            snowGolemRenderer = new SnowGolemRenderer(createEntityRenderer());
            snowGolemRendererCache = new WeakReference<>(snowGolemRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SnowGolemFarmTileentity.getSnowGolemSpawnTime() && farm.getTimer() < SnowGolemFarmTileentity.getSnowGolemKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            snowGolemRenderer.render(snowGolem, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
