package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.*;

import java.lang.ref.*;

public class ChickenFarmRenderer extends RendererBase<ChickenFarmTileentity> {

    private WeakReference<Chicken> chickenCache = new WeakReference<>(null);
    private WeakReference<ChickenRenderer> chickenRendererCache = new WeakReference<>(null);

    public ChickenFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ChickenFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Chicken chicken = chickenCache.get();
        if (chicken == null) {
            assert minecraft.level != null;
            chicken = new Chicken(EntityType.CHICKEN, minecraft.level);
            chickenCache = new WeakReference<>(chicken);
        }

        ChickenRenderer chickenRenderer = chickenRendererCache.get();
        if (chickenRenderer == null) {
            chickenRenderer = new ChickenRenderer(createEntityRenderer());
            chickenRendererCache = new WeakReference<>(chickenRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ChickenFarmTileentity.getChickenSpawnTime(farm) && farm.getTimer() < ChickenFarmTileentity.getChickenKillTime(farm)) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            chickenRenderer.render(chicken, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
