package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SlimeFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.client.renderer.entity.state.SlimeRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;

import java.lang.ref.WeakReference;

public class SlimeFarmRenderer extends RendererBase<SlimeFarmTileentity> {

    private WeakReference<Slime> slimeCache = new WeakReference<>(null);
    private WeakReference<SlimeRenderer> slimeRendererCache = new WeakReference<>(null);
    SlimeRenderState slimeRenderState;
    public SlimeFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SlimeFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Slime slime = slimeCache.get();
        if (slime == null) {
            slime = new Slime(EntityType.SLIME, minecraft.level);
            slimeCache = new WeakReference<>(slime);
        }

        SlimeRenderer slimeRenderer = slimeRendererCache.get();
        if (slimeRenderer == null) {
            slimeRenderer = new SlimeRenderer(createEntityRenderer());
            slimeRendererCache = new WeakReference<>(slimeRenderer);
        }
        slimeRenderState = getRenderState(slimeRenderer, slimeRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SlimeFarmTileentity.getSlimeSpawnTime() && farm.getTimer() < SlimeFarmTileentity.getSlimeExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            slimeRenderer.render(slimeRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
