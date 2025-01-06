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

public class PufferfishFarmRenderer extends RendererBase<PufferfishFarmTileentity> {

    private WeakReference<Pufferfish> pufferfishCache = new WeakReference<>(null);
    private WeakReference<PufferfishRenderer> pufferfishRendererCache = new WeakReference<>(null);

    public PufferfishFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(PufferfishFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Pufferfish pufferfish = pufferfishCache.get();
        if (pufferfish == null) {
            pufferfish = new Pufferfish(EntityType.PUFFERFISH, minecraft.level);
            pufferfishCache = new WeakReference<>(pufferfish);
        }

        PufferfishRenderer pufferfishRenderer = pufferfishRendererCache.get();
        if (pufferfishRenderer == null) {
            pufferfishRenderer = new PufferfishRenderer(createEntityRenderer());
            pufferfishRendererCache = new WeakReference<>(pufferfishRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PufferfishFarmTileentity.getPufferfishSpawnTime(farm) && farm.getTimer() < PufferfishFarmTileentity.getPufferfishKillTime(farm)) {
            renderMob(matrixStack);
            matrixStack.scale(5f, 5f, 5f);
            pufferfishRenderer.render(pufferfish, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }
}
