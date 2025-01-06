package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;

import java.lang.ref.*;

public class StriderFarmRenderer extends RendererBase<StriderFarmTileentity> {

    private WeakReference<Strider> striderCache = new WeakReference<>(null);
    private WeakReference<StriderRenderer> striderRendererCache = new WeakReference<>(null);

    public StriderFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(StriderFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Strider strider = striderCache.get();
        if (strider == null) {
            strider = new Strider(EntityType.STRIDER, minecraft.level);
            striderCache = new WeakReference<>(strider);
        }

        StriderRenderer striderRenderer = striderRendererCache.get();
        if (striderRenderer == null) {
            striderRenderer = new StriderRenderer(createEntityRenderer());
            striderRendererCache = new WeakReference<>(striderRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= StriderFarmTileentity.getStriderSpawnTime(farm) && farm.getTimer() < StriderFarmTileentity.getStriderKillTime(farm)) {
            renderMob(matrixStack);
            striderRenderer.render(strider, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
