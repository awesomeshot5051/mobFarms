package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.CreeperFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;

import java.lang.ref.WeakReference;

public class CreeperFarmRenderer extends RendererBase<CreeperFarmTileentity> {

    private WeakReference<Creeper> creeperCache = new WeakReference<>(null);
    private WeakReference<CreeperRenderer> creeperRendererCache = new WeakReference<>(null);
    private CreeperRenderState creeperRenderState;

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
        creeperRenderState = getRenderState(creeperRenderer, creeperRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= CreeperFarmTileentity.getCreeperSpawnTime() && farm.getTimer() < CreeperFarmTileentity.getCreeperExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            creeperRenderer.render(creeperRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
