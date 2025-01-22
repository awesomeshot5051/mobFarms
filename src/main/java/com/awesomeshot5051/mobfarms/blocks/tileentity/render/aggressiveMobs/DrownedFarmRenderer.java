package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.DrownedFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.DrownedRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Drowned;

import java.lang.ref.WeakReference;

public class DrownedFarmRenderer extends RendererBase<DrownedFarmTileentity> {

    private WeakReference<Drowned> drownedCache = new WeakReference<>(null);
    private WeakReference<DrownedRenderer> drownedRendererCache = new WeakReference<>(null);

    public DrownedFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(DrownedFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Drowned drowned = drownedCache.get();
        if (drowned == null) {
            drowned = new Drowned(EntityType.DROWNED, minecraft.level);
            drownedCache = new WeakReference<>(drowned);
        }

        DrownedRenderer drownedRenderer = drownedRendererCache.get();
        if (drownedRenderer == null) {
            drownedRenderer = new DrownedRenderer(createEntityRenderer());
            drownedRendererCache = new WeakReference<>(drownedRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= DrownedFarmTileentity.getDrownedSpawnTime(farm) && farm.getTimer() < DrownedFarmTileentity.getDrownedExplodeTime(farm)) {
            renderMob(matrixStack);
            drownedRenderer.render(drowned, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
