package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ShulkerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ShulkerRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Shulker;

import java.lang.ref.WeakReference;

public class ShulkerFarmRenderer extends RendererBase<ShulkerFarmTileentity> {

    private WeakReference<Shulker> shulkerCache = new WeakReference<>(null);
    private WeakReference<ShulkerRenderer> shulkerRendererCache = new WeakReference<>(null);

    public ShulkerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ShulkerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Shulker shulker = shulkerCache.get();
        if (shulker == null) {
            shulker = new Shulker(EntityType.SHULKER, minecraft.level);
            shulkerCache = new WeakReference<>(shulker);
        }

        ShulkerRenderer shulkerRenderer = shulkerRendererCache.get();
        if (shulkerRenderer == null) {
            shulkerRenderer = new ShulkerRenderer(createEntityRenderer());
            shulkerRendererCache = new WeakReference<>(shulkerRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ShulkerFarmTileentity.getShulkerSpawnTime() && farm.getTimer() < ShulkerFarmTileentity.getShulkerExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            shulkerRenderer.render(shulker, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
