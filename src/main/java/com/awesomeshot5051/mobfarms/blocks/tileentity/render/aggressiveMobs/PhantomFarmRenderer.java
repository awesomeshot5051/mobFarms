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

public class PhantomFarmRenderer extends RendererBase<PhantomFarmTileentity> {

    private WeakReference<Phantom> phantomCache = new WeakReference<>(null);
    private WeakReference<PhantomRenderer> phantomRendererCache = new WeakReference<>(null);

    public PhantomFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(PhantomFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Phantom phantom = phantomCache.get();
        if (phantom == null) {
            phantom = new Phantom(EntityType.PHANTOM, minecraft.level);
            phantomCache = new WeakReference<>(phantom);
        }

        PhantomRenderer phantomRenderer = phantomRendererCache.get();
        if (phantomRenderer == null) {
            phantomRenderer = new PhantomRenderer(createEntityRenderer());
            phantomRendererCache = new WeakReference<>(phantomRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PhantomFarmTileentity.getPhantomSpawnTime(farm) && farm.getTimer() < PhantomFarmTileentity.getPhantomExplodeTime(farm)) {
            renderMob(matrixStack);
            phantomRenderer.render(phantom, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
