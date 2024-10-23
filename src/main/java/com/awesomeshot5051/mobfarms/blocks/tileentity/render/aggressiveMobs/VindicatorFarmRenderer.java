package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.VindicatorFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.VindicatorRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Vindicator;

import java.lang.ref.WeakReference;

public class VindicatorFarmRenderer extends RendererBase<VindicatorFarmTileentity> {

    private WeakReference<Vindicator> vindicatorCache = new WeakReference<>(null);
    private WeakReference<VindicatorRenderer> vindicatorRendererCache = new WeakReference<>(null);

    public VindicatorFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(VindicatorFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Vindicator vindicator = vindicatorCache.get();
        if (vindicator == null) {
            vindicator = new Vindicator(EntityType.VINDICATOR, minecraft.level);
            vindicatorCache = new WeakReference<>(vindicator);
        }

        VindicatorRenderer vindicatorRenderer = vindicatorRendererCache.get();
        if (vindicatorRenderer == null) {
            vindicatorRenderer = new VindicatorRenderer(createEntityRenderer());
            vindicatorRendererCache = new WeakReference<>(vindicatorRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= VindicatorFarmTileentity.getVindicatorSpawnTime() && farm.getTimer() < VindicatorFarmTileentity.getVindicatorExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            vindicatorRenderer.render(vindicator, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
