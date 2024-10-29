package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.MooshroomFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.MushroomCowRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.MushroomCow;

import java.lang.ref.WeakReference;

public class MooshroomFarmRenderer extends RendererBase<MooshroomFarmTileentity> {

    private WeakReference<MushroomCow> mooshroomCache = new WeakReference<>(null);
    private WeakReference<MushroomCowRenderer> mooshroomRendererCache = new WeakReference<>(null);

    public MooshroomFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(MooshroomFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        MushroomCow mooshroom = mooshroomCache.get();
        if (mooshroom == null) {
            mooshroom = new MushroomCow(EntityType.MOOSHROOM, minecraft.level);
            mooshroomCache = new WeakReference<>(mooshroom);
        }

        MushroomCowRenderer mooshroomRenderer = mooshroomRendererCache.get();
        if (mooshroomRenderer == null) {
            mooshroomRenderer = new MushroomCowRenderer(createEntityRenderer());
            mooshroomRendererCache = new WeakReference<>(mooshroomRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PigFarmTileentity.getPigSpawnTime() && farm.getTimer() < PigFarmTileentity.getPorkKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            mooshroomRenderer.render(mooshroom, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
