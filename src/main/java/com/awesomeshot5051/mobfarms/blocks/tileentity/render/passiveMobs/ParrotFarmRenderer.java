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

public class ParrotFarmRenderer extends RendererBase<ParrotFarmTileentity> {

    private WeakReference<Parrot> parrotCache = new WeakReference<>(null);
    private WeakReference<ParrotRenderer> parrotRendererCache = new WeakReference<>(null);

    public ParrotFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ParrotFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Parrot parrot = parrotCache.get();
        if (parrot == null) {
            parrot = new Parrot(EntityType.PARROT, minecraft.level);
            parrotCache = new WeakReference<>(parrot);
        }

        ParrotRenderer parrotRenderer = parrotRendererCache.get();
        if (parrotRenderer == null) {
            parrotRenderer = new ParrotRenderer(createEntityRenderer());
            parrotRendererCache = new WeakReference<>(parrotRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ParrotFarmTileentity.getParrotSpawnTime(farm) && farm.getTimer() < ParrotFarmTileentity.getParrotKillTime(farm)) {
            renderMob(matrixStack);
            parrotRenderer.render(parrot, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
