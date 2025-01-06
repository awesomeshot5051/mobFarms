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

        if (farm.getTimer() >= SnowGolemFarmTileentity.getSnowGolemSpawnTime(farm) && farm.getTimer() < SnowGolemFarmTileentity.getSnowGolemKillTime(farm)) {
            renderMob(matrixStack);
            snowGolemRenderer.render(snowGolem, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
