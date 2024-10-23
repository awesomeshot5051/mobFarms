package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.EvokerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EvokerRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Evoker;

import java.lang.ref.WeakReference;

public class EvokerFarmRenderer extends RendererBase<EvokerFarmTileentity> {

    private WeakReference<Evoker> evokerCache = new WeakReference<>(null);
    private WeakReference<EvokerRenderer> evokerRendererCache = new WeakReference<>(null);

    public EvokerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(EvokerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Evoker evoker = evokerCache.get();
        if (evoker == null) {
            evoker = new Evoker(EntityType.EVOKER, minecraft.level);
            evokerCache = new WeakReference<>(evoker);
        }

        EvokerRenderer evokerRenderer = evokerRendererCache.get();
        if (evokerRenderer == null) {
            evokerRenderer = new EvokerRenderer(createEntityRenderer());
            evokerRendererCache = new WeakReference<>(evokerRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= EvokerFarmTileentity.getEvokerSpawnTime() && farm.getTimer() < EvokerFarmTileentity.getEvokerExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            evokerRenderer.render(evoker, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
