package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.hoglin.*;

import java.lang.ref.*;

public class HoglinFarmRenderer extends RendererBase<HoglinFarmTileentity> {

    private WeakReference<Hoglin> hoglinCache = new WeakReference<>(null);
    private WeakReference<HoglinRenderer> hoglinRendererCache = new WeakReference<>(null);

    public HoglinFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(HoglinFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Hoglin hoglin = hoglinCache.get();
        if (hoglin == null) {
            hoglin = new Hoglin(EntityType.HOGLIN, minecraft.level);
            hoglinCache = new WeakReference<>(hoglin);
        }

        HoglinRenderer hoglinRenderer = hoglinRendererCache.get();
        if (hoglinRenderer == null) {
            hoglinRenderer = new HoglinRenderer(createEntityRenderer());
            hoglinRendererCache = new WeakReference<>(hoglinRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= HoglinFarmTileentity.getHoglinSpawnTime(farm) && farm.getTimer() < HoglinFarmTileentity.getHoglinExplodeTime(farm)) {
            renderMob(matrixStack);
            hoglinRenderer.render(hoglin, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
