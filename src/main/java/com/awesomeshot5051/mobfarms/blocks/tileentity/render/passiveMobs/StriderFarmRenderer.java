package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.StriderFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.StriderRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Strider;

import java.lang.ref.WeakReference;

public class StriderFarmRenderer extends RendererBase<StriderFarmTileentity> {

    private WeakReference<Strider> striderCache = new WeakReference<>(null);
    private WeakReference<StriderRenderer> striderRendererCache = new WeakReference<>(null);

    public StriderFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(StriderFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Strider strider = striderCache.get();
        if (strider == null) {
            strider = new Strider(EntityType.STRIDER, minecraft.level);
            striderCache = new WeakReference<>(strider);
        }

        StriderRenderer striderRenderer = striderRendererCache.get();
        if (striderRenderer == null) {
            striderRenderer = new StriderRenderer(createEntityRenderer());
            striderRendererCache = new WeakReference<>(striderRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= StriderFarmTileentity.getStriderSpawnTime() && farm.getTimer() < StriderFarmTileentity.getStriderKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            striderRenderer.render(strider, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
