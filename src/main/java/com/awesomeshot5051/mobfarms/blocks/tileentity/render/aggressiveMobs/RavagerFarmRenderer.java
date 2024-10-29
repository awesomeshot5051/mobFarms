package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.RavagerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.RavagerRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Ravager;

import java.lang.ref.WeakReference;

public class RavagerFarmRenderer extends RendererBase<RavagerFarmTileentity> {

    private WeakReference<Ravager> ravagerCache = new WeakReference<>(null);
    private WeakReference<RavagerRenderer> ravagerRendererCache = new WeakReference<>(null);

    public RavagerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(RavagerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Ravager ravager = ravagerCache.get();
        if (ravager == null) {
            ravager = new Ravager(EntityType.RAVAGER, minecraft.level);
            ravagerCache = new WeakReference<>(ravager);
        }

        RavagerRenderer ravagerRenderer = ravagerRendererCache.get();
        if (ravagerRenderer == null) {
            ravagerRenderer = new RavagerRenderer(createEntityRenderer());
            ravagerRendererCache = new WeakReference<>(ravagerRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= RavagerFarmTileentity.getRavagerSpawnTime() && farm.getTimer() < RavagerFarmTileentity.getRavagerExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            ravagerRenderer.render(ravager, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
