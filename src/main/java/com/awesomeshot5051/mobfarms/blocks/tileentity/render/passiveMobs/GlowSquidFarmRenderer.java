package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.GlowSquidFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.SquidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.GlowSquidRenderer;
import net.minecraft.client.renderer.entity.state.SquidRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.GlowSquid;

import java.lang.ref.WeakReference;

public class GlowSquidFarmRenderer extends RendererBase<GlowSquidFarmTileentity> {

    private WeakReference<GlowSquid> glowSquidCache = new WeakReference<>(null);
    private WeakReference<GlowSquidRenderer> glowSquidRendererCache = new WeakReference<>(null);
    private SquidRenderState glowSquidRenderState;

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
            // Create two GlowSquidModel instances as required by the constructor
            SquidModel glowSquidModel1 = new SquidModel(createEntityRenderer().bakeLayer(ModelLayers.GLOW_SQUID));
            SquidModel glowSquidModel2 = new SquidModel(createEntityRenderer().bakeLayer(ModelLayers.GLOW_SQUID));

            // Create a new GlowSquidRenderer instance with both models
            glowSquidRenderer = new GlowSquidRenderer(createEntityRenderer(), glowSquidModel1, glowSquidModel2);

            // Cache the renderer in the WeakReference
            glowSquidRendererCache = new WeakReference<>(glowSquidRenderer);
        }

        glowSquidRenderState = getRenderState(glowSquidRenderer, glowSquidRenderState);

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= GlowSquidFarmTileentity.getGlowSquidSpawnTime() && farm.getTimer() < GlowSquidFarmTileentity.getGlowSquidKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            glowSquidRenderer.render(glowSquidRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
