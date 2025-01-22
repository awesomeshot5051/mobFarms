package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.RabbitFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Rabbit;

import java.lang.ref.WeakReference;

public class RabbitFarmRenderer extends RendererBase<RabbitFarmTileentity> {

    private WeakReference<Rabbit> rabbitCache = new WeakReference<>(null);
    private WeakReference<RabbitRenderer> rabbitRendererCache = new WeakReference<>(null);

    public RabbitFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(RabbitFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Rabbit rabbit = rabbitCache.get();
        if (rabbit == null) {
            rabbit = new Rabbit(EntityType.RABBIT, minecraft.level);
            rabbitCache = new WeakReference<>(rabbit);
        }

        RabbitRenderer rabbitRenderer = rabbitRendererCache.get();
        if (rabbitRenderer == null) {
            rabbitRenderer = new RabbitRenderer(createEntityRenderer());
            rabbitRendererCache = new WeakReference<>(rabbitRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= RabbitFarmTileentity.getRabbitSpawnTime(farm) && farm.getTimer() < RabbitFarmTileentity.getRabbitKillTime(farm)) {
            renderMob(matrixStack);
            rabbitRenderer.render(rabbit, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
