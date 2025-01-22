package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ChickenFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;

import java.lang.ref.WeakReference;

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
           renderMob(matrixStack);
            chickenRenderer.render(chicken, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
