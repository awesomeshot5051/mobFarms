package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SquidFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.SquidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SquidRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Squid;

import java.lang.ref.WeakReference;

public class SquidFarmRenderer extends RendererBase<SquidFarmTileentity> {

    private WeakReference<Squid> squidCache = new WeakReference<>(null);
    private WeakReference<SquidRenderer> squidRendererCache = new WeakReference<>(null);

    public SquidFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(SquidFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Squid squid = squidCache.get();
        if (squid == null) {
            squid = new Squid(EntityType.SQUID, minecraft.level);
            squidCache = new WeakReference<>(squid);
        }

        SquidRenderer squidRenderer = squidRendererCache.get();
        if (squidRenderer == null) {
            SquidModel<Squid> squidModel = new SquidModel<>(createEntityRenderer().bakeLayer(ModelLayers.SQUID));
            squidRenderer = new SquidRenderer(createEntityRenderer(),squidModel);
            squidRendererCache = new WeakReference<>(squidRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SquidFarmTileentity.getSquidSpawnTime() && farm.getTimer() < SquidFarmTileentity.getSquidKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            squidRenderer.render(squid, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
