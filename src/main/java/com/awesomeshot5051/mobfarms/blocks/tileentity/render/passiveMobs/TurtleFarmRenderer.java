package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TurtleFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.TurtleRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Turtle;

import java.lang.ref.WeakReference;

public class TurtleFarmRenderer extends RendererBase<TurtleFarmTileentity> {

    private WeakReference<Turtle> turtleCache = new WeakReference<>(null);
    private WeakReference<TurtleRenderer> turtleRendererCache = new WeakReference<>(null);

    public TurtleFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(TurtleFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Turtle turtle = turtleCache.get();
        if (turtle == null) {
            turtle = new Turtle(EntityType.TURTLE, minecraft.level);
            turtleCache = new WeakReference<>(turtle);
        }

        TurtleRenderer turtleRenderer = turtleRendererCache.get();
        if (turtleRenderer == null) {
            turtleRenderer = new TurtleRenderer(createEntityRenderer());
            turtleRendererCache = new WeakReference<>(turtleRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= TurtleFarmTileentity.getTurtleSpawnTime() && farm.getTimer() < TurtleFarmTileentity.getTurtleKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            turtleRenderer.render(turtle, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
