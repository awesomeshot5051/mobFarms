package com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.GoatFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.GoatRenderer;
import net.minecraft.client.renderer.entity.state.GoatRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.goat.Goat;

import java.lang.ref.WeakReference;

public class GoatFarmRenderer extends RendererBase<GoatFarmTileentity> {

    private WeakReference<Goat> goatCache = new WeakReference<>(null);
    private WeakReference<GoatRenderer> goatRendererCache = new WeakReference<>(null);
    private GoatRenderState goatRenderState;
    public GoatFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(GoatFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();


        Goat goat = goatCache.get();
        if (goat == null) {
            goat = new Goat(EntityType.GOAT, minecraft.level);
            goatCache = new WeakReference<>(goat);
        }

        GoatRenderer goatRenderer = goatRendererCache.get();
        if (goatRenderer == null) {
            goatRenderer = new GoatRenderer(createEntityRenderer());
            goatRendererCache = new WeakReference<>(goatRenderer);
        }
        goatRenderState = getRenderState(goatRenderer, goatRenderState);
        Direction direction = Direction.SOUTH;

        matrixStack.pushPose();
        matrixStack.translate(0.5D, 1D / 16D, 0.5D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        matrixStack.translate(5D / 16D, 0D, -5D / 16D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
        matrixStack.scale(0.3F, 0.3F, 0.3F);
        matrixStack.popPose();

        if (farm.getTimer() >= GoatFarmTileentity.getGoatSpawnTime() && farm.getTimer() < GoatFarmTileentity.getGoatKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            if (farm.getTimer() % 20 < 10) {
                goat.hurtTime = 20;
            } else {
                goat.hurtTime = 0;
            }
            goatRenderer.render(goatRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
