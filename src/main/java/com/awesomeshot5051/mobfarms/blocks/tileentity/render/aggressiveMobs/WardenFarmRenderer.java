package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WardenFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.WardenRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.warden.Warden;

import java.lang.ref.WeakReference;

public class WardenFarmRenderer extends RendererBase<WardenFarmTileentity> {

    private WeakReference<Warden> wardenCache = new WeakReference<>(null);
    private WeakReference<WardenRenderer> wardenRendererCache = new WeakReference<>(null);

    public WardenFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(WardenFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Warden warden = wardenCache.get();
        if (warden == null) {
            warden = new Warden(EntityType.WARDEN, minecraft.level);
            wardenCache = new WeakReference<>(warden);
        }

        WardenRenderer wardenRenderer = wardenRendererCache.get();
        if (wardenRenderer == null) {
            wardenRenderer = new WardenRenderer(createEntityRenderer());
            wardenRendererCache = new WeakReference<>(wardenRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WardenFarmTileentity.getWardenSpawnTime() && farm.getTimer() < WardenFarmTileentity.getWardenExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            wardenRenderer.render(warden, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
