package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;

import java.lang.ref.*;

public class GlowSquidFarmRenderer extends RendererBase<GlowSquidFarmTileentity> {

    private WeakReference<GlowSquid> glowSquidCache = new WeakReference<>(null);
    private WeakReference<GlowSquidRenderer> glowSquidRendererCache = new WeakReference<>(null);

    public GlowSquidFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(GlowSquidFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        GlowSquid glowSquid = glowSquidCache.get();
        if (glowSquid == null) {
            glowSquid = new GlowSquid(EntityType.GLOW_SQUID, minecraft.level);
            glowSquidCache = new WeakReference<>(glowSquid);
        }

        GlowSquidRenderer glowSquidRenderer = glowSquidRendererCache.get();
        if (glowSquidRenderer == null) {
            // Create the SquidModel for GlowSquid
            SquidModel<GlowSquid> glowSquidModel = new SquidModel<>(createEntityRenderer().bakeLayer(ModelLayers.GLOW_SQUID));

            // Create the GlowSquidRenderer with the correct parameters
            glowSquidRenderer = new GlowSquidRenderer(createEntityRenderer(), glowSquidModel);
            glowSquidRendererCache = new WeakReference<>(glowSquidRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= GlowSquidFarmTileentity.getGlowSquidSpawnTime(farm) && farm.getTimer() < GlowSquidFarmTileentity.getGlowSquidKillTime(farm)) {
            renderMob(matrixStack);
            glowSquidRenderer.render(glowSquid, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
