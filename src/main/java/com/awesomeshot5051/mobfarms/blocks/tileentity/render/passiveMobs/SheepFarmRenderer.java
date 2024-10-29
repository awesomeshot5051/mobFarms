package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SheepFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;

import java.lang.ref.WeakReference;

public class SheepFarmRenderer extends RendererBase<SheepFarmTileentity> {

    private WeakReference<Sheep> sheepCache = new WeakReference<>(null);
    private WeakReference<SheepRenderer> sheepRendererCache = new WeakReference<>(null);

    public SheepFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SheepFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Sheep sheep = sheepCache.get();
        if (sheep == null) {
            sheep = new Sheep(EntityType.SHEEP, minecraft.level);
            sheepCache = new WeakReference<>(sheep);
        }

        SheepRenderer sheepRenderer = sheepRendererCache.get();
        if (sheepRenderer == null) {
            sheepRenderer = new SheepRenderer(createEntityRenderer());
            sheepRendererCache = new WeakReference<>(sheepRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SheepFarmTileentity.getSheepSpawnTime() && farm.getTimer() < SheepFarmTileentity.getSheepKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            sheepRenderer.render(sheep, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
