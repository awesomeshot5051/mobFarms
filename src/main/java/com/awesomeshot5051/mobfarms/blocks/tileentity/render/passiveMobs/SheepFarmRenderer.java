package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SheepFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;

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
        // Get the color from the SheepFarmTileentity
        DyeColor woolColor = farm.getBlockState().getValue(SheepFarmBlock.COLOR);
        sheep.setColor(woolColor); // Set the sheep's color based on the block's color
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= SheepFarmTileentity.getSheepSpawnTime(farm) && farm.getTimer() < SheepFarmTileentity.getSheepKillTime(farm)) {
            renderMob(matrixStack);
            sheepRenderer.render(sheep, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
