package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GhastFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.GhastRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Ghast;

import java.lang.ref.WeakReference;

public class GhastFarmRenderer extends RendererBase<GhastFarmTileentity> {

    private WeakReference<Ghast> ghastCache = new WeakReference<>(null);
    private WeakReference<GhastRenderer> ghastRendererCache = new WeakReference<>(null);

    public GhastFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(GhastFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Ghast ghast = ghastCache.get();
        if (ghast == null) {
            ghast = new Ghast(EntityType.GHAST, minecraft.level);
            ghastCache = new WeakReference<>(ghast);
        }

        GhastRenderer ghastRenderer = ghastRendererCache.get();
        if (ghastRenderer == null) {
            ghastRenderer = new GhastRenderer(createEntityRenderer());
            ghastRendererCache = new WeakReference<>(ghastRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= GhastFarmTileentity.getGhastSpawnTime() && farm.getTimer() < GhastFarmTileentity.getGhastExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);

            // Adjust the scaling factor here
            matrixStack.scale(0.09F, 0.09F, 0.09F); // Change to 0.09F


            ghastRenderer.render(ghast, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }


}
