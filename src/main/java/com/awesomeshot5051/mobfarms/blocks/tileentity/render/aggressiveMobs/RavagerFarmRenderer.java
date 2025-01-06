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

public class RavagerFarmRenderer extends RendererBase<RavagerFarmTileentity> {

    private WeakReference<Ravager> ravagerCache = new WeakReference<>(null);
    private WeakReference<RavagerRenderer> ravagerRendererCache = new WeakReference<>(null);

    public RavagerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(RavagerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Ravager ravager = ravagerCache.get();
        if (ravager == null) {
            ravager = new Ravager(EntityType.RAVAGER, minecraft.level);
            ravagerCache = new WeakReference<>(ravager);
        }

        RavagerRenderer ravagerRenderer = ravagerRendererCache.get();
        if (ravagerRenderer == null) {
            ravagerRenderer = new RavagerRenderer(createEntityRenderer());
            ravagerRendererCache = new WeakReference<>(ravagerRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= RavagerFarmTileentity.getRavagerSpawnTime(farm) && farm.getTimer() < RavagerFarmTileentity.getRavagerExplodeTime(farm)) {
            renderMob(matrixStack);
            matrixStack.scale(.5f, .5f, .5f);
            ravagerRenderer.render(ravager, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
