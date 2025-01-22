package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.CreeperFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;

import java.lang.ref.WeakReference;

public class CreeperFarmRenderer extends RendererBase<CreeperFarmTileentity> {

    private WeakReference<Creeper> creeperCache = new WeakReference<>(null);
    private WeakReference<CreeperRenderer> creeperRendererCache = new WeakReference<>(null);

    public CreeperFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(CreeperFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Creeper creeper = creeperCache.get();
        if (creeper == null) {
            creeper = new Creeper(EntityType.CREEPER, minecraft.level);
            creeperCache = new WeakReference<>(creeper);
        }

        CreeperRenderer creeperRenderer = creeperRendererCache.get();
        if (creeperRenderer == null) {
            creeperRenderer = new CreeperRenderer(createEntityRenderer());
            creeperRendererCache = new WeakReference<>(creeperRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= CreeperFarmTileentity.getCreeperSpawnTime(farm) && farm.getTimer() < CreeperFarmTileentity.getCreeperExplodeTime(farm)) {
            renderMob(matrixStack);
            creeperRenderer.render(creeper, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
