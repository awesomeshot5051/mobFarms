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

public class VindicatorFarmRenderer extends RendererBase<VindicatorFarmTileentity> {

    private WeakReference<Vindicator> vindicatorCache = new WeakReference<>(null);
    private WeakReference<VindicatorRenderer> vindicatorRendererCache = new WeakReference<>(null);

    public VindicatorFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(VindicatorFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Vindicator vindicator = vindicatorCache.get();
        if (vindicator == null) {
            vindicator = new Vindicator(EntityType.VINDICATOR, minecraft.level);
            vindicatorCache = new WeakReference<>(vindicator);
        }

        VindicatorRenderer vindicatorRenderer = vindicatorRendererCache.get();
        if (vindicatorRenderer == null) {
            vindicatorRenderer = new VindicatorRenderer(createEntityRenderer());
            vindicatorRendererCache = new WeakReference<>(vindicatorRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= VindicatorFarmTileentity.getVindicatorSpawnTime(farm) && farm.getTimer() < VindicatorFarmTileentity.getVindicatorExplodeTime(farm)) {
            renderMob(matrixStack);
            vindicatorRenderer.render(vindicator, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
