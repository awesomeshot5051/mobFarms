package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SalmonFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SalmonRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Salmon;

import java.lang.ref.WeakReference;

public class SalmonFarmRenderer extends RendererBase<SalmonFarmTileentity> {

    private WeakReference<Salmon> salmonCache = new WeakReference<>(null);
    private WeakReference<SalmonRenderer> salmonRendererCache = new WeakReference<>(null);

    public SalmonFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SalmonFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Salmon salmon = salmonCache.get();
        if (salmon == null) {
            salmon = new Salmon(EntityType.SALMON, minecraft.level);
            salmonCache = new WeakReference<>(salmon);
        }

        SalmonRenderer salmonRenderer = salmonRendererCache.get();
        if (salmonRenderer == null) {
            salmonRenderer = new SalmonRenderer(createEntityRenderer());
            salmonRendererCache = new WeakReference<>(salmonRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SalmonFarmTileentity.getSalmonSpawnTime(farm) && farm.getTimer() < SalmonFarmTileentity.getSalmonKillTime(farm)) {
            renderMob(matrixStack);
            salmonRenderer.render(salmon, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
