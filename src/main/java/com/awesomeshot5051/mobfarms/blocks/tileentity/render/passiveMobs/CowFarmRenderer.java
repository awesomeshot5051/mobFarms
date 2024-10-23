package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CowFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;

import java.lang.ref.WeakReference;

public class CowFarmRenderer extends RendererBase<CowFarmTileentity> {

    private WeakReference<Cow> cowCache = new WeakReference<>(null);
    private WeakReference<CowRenderer> cowRendererCache = new WeakReference<>(null);

    public CowFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(CowFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Cow cow = cowCache.get();
        if (cow == null) {
            cow = new Cow(EntityType.COW, minecraft.level);
            cowCache = new WeakReference<>(cow);
        }

        CowRenderer cowRenderer = cowRendererCache.get();
        if (cowRenderer == null) {
            cowRenderer = new CowRenderer(createEntityRenderer());
            cowRendererCache = new WeakReference<>(cowRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= CowFarmTileentity.getCowSpawnTime() && farm.getTimer() < CowFarmTileentity.getCowKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            cowRenderer.render(cow, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
