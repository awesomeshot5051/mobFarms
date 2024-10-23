package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;

import java.lang.ref.WeakReference;

public class PigFarmRenderer extends RendererBase<PigFarmTileentity> {

    private WeakReference<Pig> pigCache = new WeakReference<>(null);
    private WeakReference<PigRenderer> pigRendererCache = new WeakReference<>(null);

    public PigFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(PigFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Pig pig = pigCache.get();
        if (pig == null) {
            pig = new Pig(EntityType.PIG, minecraft.level);
            pigCache = new WeakReference<>(pig);
        }

        PigRenderer pigRenderer = pigRendererCache.get();
        if (pigRenderer == null) {
            pigRenderer = new PigRenderer(createEntityRenderer());
            pigRendererCache = new WeakReference<>(pigRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PigFarmTileentity.getPigSpawnTime() && farm.getTimer() < PigFarmTileentity.getPorkKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            pigRenderer.render(pig, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
