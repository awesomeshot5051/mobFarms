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

public class PillagerFarmRenderer extends RendererBase<PillagerFarmTileentity> {

    private WeakReference<Pillager> pillagerCache = new WeakReference<>(null);
    private WeakReference<PillagerRenderer> pillagerRendererCache = new WeakReference<>(null);

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

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PillagerFarmTileentity.getPillagerSpawnTime(farm) && farm.getTimer() < PillagerFarmTileentity.getPillagerExplodeTime(farm)) {
            renderMob(matrixStack);
            pillagerRenderer.render(pillager, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
