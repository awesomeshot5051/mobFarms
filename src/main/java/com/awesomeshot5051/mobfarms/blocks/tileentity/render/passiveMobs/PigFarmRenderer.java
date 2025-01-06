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

public class PigFarmRenderer extends RendererBase<PigFarmTileentity> {

    private WeakReference<Pig> pigCache = new WeakReference<>(null);
    private WeakReference<PigRenderer> pigRendererCache = new WeakReference<>(null);

    public PigFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(PigFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Pig pig = pigCache.get();
        if (pig == null) {
            pig = new Pig(EntityType.PIG, minecraft.level);
            pigCache = new WeakReference<>(pig);
        }

        PigRenderer pigRenderer = pigRendererCache.get();
        if (pigRenderer == null) {
            pigRenderer = new PigRenderer(createEntityRenderer());
            pigRendererCache = new WeakReference<>(pigRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PigFarmTileentity.getPigSpawnTime(farm) && farm.getTimer() < PigFarmTileentity.getPorkKillTime(farm)) {
            renderMob(matrixStack);
            pigRenderer.render(pig, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
