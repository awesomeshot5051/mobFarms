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

public class IllusionerFarmRenderer extends RendererBase<IllusionerFarmTileentity> {

    private WeakReference<Illusioner> illusionerCache = new WeakReference<>(null);
    private WeakReference<IllusionerRenderer> illusionerRendererCache = new WeakReference<>(null);

    public IllusionerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(IllusionerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Illusioner illusioner = illusionerCache.get();
        if (illusioner == null) {
            illusioner = new Illusioner(EntityType.ILLUSIONER, minecraft.level);
            illusionerCache = new WeakReference<>(illusioner);
        }

        IllusionerRenderer illusionerRenderer = illusionerRendererCache.get();
        if (illusionerRenderer == null) {
            illusionerRenderer = new IllusionerRenderer(createEntityRenderer());
            illusionerRendererCache = new WeakReference<>(illusionerRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= IllusionerFarmTileentity.getIllusionerSpawnTime(farm) && farm.getTimer() < IllusionerFarmTileentity.getIllusionerExplodeTime(farm)) {
            renderMob(matrixStack);
            illusionerRenderer.render(illusioner, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
