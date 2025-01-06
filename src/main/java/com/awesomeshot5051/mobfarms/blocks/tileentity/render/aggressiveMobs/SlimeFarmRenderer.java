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

public class SlimeFarmRenderer extends RendererBase<SlimeFarmTileentity> {

    private WeakReference<Slime> slimeCache = new WeakReference<>(null);
    private WeakReference<SlimeRenderer> slimeRendererCache = new WeakReference<>(null);

    public SlimeFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SlimeFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Slime slime = slimeCache.get();
        if (slime == null) {
            slime = new Slime(EntityType.SLIME, minecraft.level);
            slimeCache = new WeakReference<>(slime);
        }

        SlimeRenderer slimeRenderer = slimeRendererCache.get();
        if (slimeRenderer == null) {
            slimeRenderer = new SlimeRenderer(createEntityRenderer());
            slimeRendererCache = new WeakReference<>(slimeRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SlimeFarmTileentity.getSlimeSpawnTime(farm) && farm.getTimer() < SlimeFarmTileentity.getSlimeExplodeTime(farm)) {
            renderMob(matrixStack);
            slimeRenderer.render(slime, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
