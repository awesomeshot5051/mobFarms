package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.BlazeFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.BlazeRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Blaze;

import java.lang.ref.WeakReference;

public class BlazeFarmRenderer extends RendererBase<BlazeFarmTileentity> {

    private WeakReference<Blaze> blazeCache = new WeakReference<>(null);
    private WeakReference<BlazeRenderer> blazeRendererCache = new WeakReference<>(null);

    public BlazeFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(BlazeFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Blaze blaze = blazeCache.get();
        if (blaze == null) {
            blaze = new Blaze(EntityType.BLAZE, minecraft.level);
            blazeCache = new WeakReference<>(blaze);
        }

        BlazeRenderer blazeRenderer = blazeRendererCache.get();
        if (blazeRenderer == null) {
            blazeRenderer = new BlazeRenderer(createEntityRenderer());
            blazeRendererCache = new WeakReference<>(blazeRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= BlazeFarmTileentity.getBlazeSpawnTime() && farm.getTimer() < BlazeFarmTileentity.getBlazeExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            blazeRenderer.render(blaze, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
