package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZombieFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;

import java.lang.ref.WeakReference;

public class ZombieFarmRenderer extends RendererBase<ZombieFarmTileentity> {

    private WeakReference<Zombie> zombieCache = new WeakReference<>(null);
    private WeakReference<ZombieRenderer> zombieRendererCache = new WeakReference<>(null);
    private ZombieRenderState zombieRenderState;
    public ZombieFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ZombieFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Zombie zombie = zombieCache.get();
        if (zombie == null) {
            zombie = new Zombie(EntityType.ZOMBIE, minecraft.level);
            zombieCache = new WeakReference<>(zombie);
        }

        ZombieRenderer zombieRenderer = zombieRendererCache.get();
        if (zombieRenderer == null) {
            zombieRenderer = new ZombieRenderer(createEntityRenderer());
            zombieRendererCache = new WeakReference<>(zombieRenderer);
        }
        zombieRenderState = getRenderState(zombieRenderer, zombieRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ZombieFarmTileentity.getZombieSpawnTime() && farm.getTimer() < ZombieFarmTileentity.getZombieExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(.05F, .05F, .05F);
            zombieRenderer.render(zombieRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
