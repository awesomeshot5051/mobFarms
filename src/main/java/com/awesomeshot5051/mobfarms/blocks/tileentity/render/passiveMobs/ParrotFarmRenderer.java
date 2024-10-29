package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ParrotFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ParrotRenderer;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;

import java.lang.ref.WeakReference;

public class ParrotFarmRenderer extends RendererBase<ParrotFarmTileentity> {

    private WeakReference<Parrot> parrotCache = new WeakReference<>(null);
    private WeakReference<ParrotRenderer> parrotRendererCache = new WeakReference<>(null);

    public ParrotFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ParrotFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Parrot parrot = parrotCache.get();
        if (parrot == null) {
            parrot = new Parrot(EntityType.PARROT, minecraft.level);
            parrotCache = new WeakReference<>(parrot);
        }

        ParrotRenderer parrotRenderer = parrotRendererCache.get();
        if (parrotRenderer == null) {
            parrotRenderer = new ParrotRenderer(createEntityRenderer());
            parrotRendererCache = new WeakReference<>(parrotRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PigFarmTileentity.getPigSpawnTime() && farm.getTimer() < PigFarmTileentity.getPorkKillTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            parrotRenderer.render(parrot, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
