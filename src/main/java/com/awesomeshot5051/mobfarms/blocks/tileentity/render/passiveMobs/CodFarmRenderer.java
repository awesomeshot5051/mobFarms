package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CodFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.CodRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cod;

import java.lang.ref.WeakReference;

public class CodFarmRenderer extends RendererBase<CodFarmTileentity> {

    private WeakReference<Cod> codCache = new WeakReference<>(null);
    private WeakReference<CodRenderer> codRendererCache = new WeakReference<>(null);
    private LivingEntityRenderState codRenderState;

    public CodFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(CodFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Cod cod = codCache.get();
        if (cod == null) {
            cod = new Cod(EntityType.COD, minecraft.level);
            codCache = new WeakReference<>(cod);
        }

        CodRenderer codRenderer = codRendererCache.get();
        if (codRenderer == null) {
            codRenderer = new CodRenderer(createEntityRenderer());
            codRendererCache = new WeakReference<>(codRenderer);
        }

        Direction direction = Direction.SOUTH;
        codRenderState = getRenderState(codRenderer, codRenderState);
        if (farm.getTimer() >= CodFarmTileentity.getCodSpawnTime() && farm.getTimer() < CodFarmTileentity.getCodKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            codRenderer.render(codRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
