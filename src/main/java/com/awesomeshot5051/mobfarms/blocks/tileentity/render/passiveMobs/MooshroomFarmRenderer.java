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

public class MooshroomFarmRenderer extends RendererBase<MooshroomFarmTileentity> {

    private WeakReference<MushroomCow> mooshroomCache = new WeakReference<>(null);
    private WeakReference<MushroomCowRenderer> mooshroomRendererCache = new WeakReference<>(null);

    public MooshroomFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(MooshroomFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        MushroomCow mooshroom = mooshroomCache.get();
        if (mooshroom == null) {
            mooshroom = new MushroomCow(EntityType.MOOSHROOM, minecraft.level);
            mooshroomCache = new WeakReference<>(mooshroom);
        }

        MushroomCowRenderer mooshroomRenderer = mooshroomRendererCache.get();
        if (mooshroomRenderer == null) {
            mooshroomRenderer = new MushroomCowRenderer(createEntityRenderer());
            mooshroomRendererCache = new WeakReference<>(mooshroomRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= MooshroomFarmTileentity.getMooshroomKillTime(farm) && farm.getTimer() < MooshroomFarmTileentity.getMooshroomKillTime(farm)) {
            renderMob(matrixStack);
            mooshroomRenderer.render(mooshroom, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
