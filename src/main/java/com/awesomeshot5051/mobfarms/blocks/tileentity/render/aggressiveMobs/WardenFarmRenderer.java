package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.warden.*;

import java.lang.ref.*;

public class WardenFarmRenderer extends RendererBase<WardenFarmTileentity> {

    private WeakReference<Warden> wardenCache = new WeakReference<>(null);
    private WeakReference<WardenRenderer> wardenRendererCache = new WeakReference<>(null);

    public WardenFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(WardenFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Warden warden = wardenCache.get();
        if (warden == null) {
            warden = new Warden(EntityType.WARDEN, minecraft.level);
            wardenCache = new WeakReference<>(warden);
        }

        WardenRenderer wardenRenderer = wardenRendererCache.get();
        if (wardenRenderer == null) {
            wardenRenderer = new WardenRenderer(createEntityRenderer());
            wardenRendererCache = new WeakReference<>(wardenRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WardenFarmTileentity.getWardenSpawnTime(farm) && farm.getTimer() < WardenFarmTileentity.getWardenExplodeTime(farm)) {
            renderMob(matrixStack);
            matrixStack.scale(.6f, .6f, .6f);
            wardenRenderer.render(warden, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
