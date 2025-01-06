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

public class EvokerFarmRenderer extends RendererBase<EvokerFarmTileentity> {

    private WeakReference<Evoker> evokerCache = new WeakReference<>(null);
    private WeakReference<EvokerRenderer> evokerRendererCache = new WeakReference<>(null);

    public EvokerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(EvokerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Evoker evoker = evokerCache.get();
        if (evoker == null) {
            evoker = new Evoker(EntityType.EVOKER, minecraft.level);
            evokerCache = new WeakReference<>(evoker);
        }

        EvokerRenderer evokerRenderer = evokerRendererCache.get();
        if (evokerRenderer == null) {
            evokerRenderer = new EvokerRenderer(createEntityRenderer());
            evokerRendererCache = new WeakReference<>(evokerRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= EvokerFarmTileentity.getEvokerSpawnTime(farm) && farm.getTimer() < EvokerFarmTileentity.getEvokerExplodeTime(farm)) {
            renderMob(matrixStack);
            evokerRenderer.render(evoker, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
