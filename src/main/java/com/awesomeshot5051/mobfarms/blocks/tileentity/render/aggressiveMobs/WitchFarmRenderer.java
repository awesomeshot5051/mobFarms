package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitchFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.WitchRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Witch;

import java.lang.ref.WeakReference;

public class WitchFarmRenderer extends RendererBase<WitchFarmTileentity> {

    private WeakReference<Witch> witchCache = new WeakReference<>(null);
    private WeakReference<WitchRenderer> witchRendererCache = new WeakReference<>(null);

    public WitchFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(WitchFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Witch witch = witchCache.get();
        if (witch == null) {
            witch = new Witch(EntityType.WITCH, minecraft.level);
            witchCache = new WeakReference<>(witch);
        }

        WitchRenderer witchRenderer = witchRendererCache.get();
        if (witchRenderer == null) {
            witchRenderer = new WitchRenderer(createEntityRenderer());
            witchRendererCache = new WeakReference<>(witchRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WitchFarmTileentity.getWitchSpawnTime() && farm.getTimer() < WitchFarmTileentity.getWitchExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            witchRenderer.render(witch, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
