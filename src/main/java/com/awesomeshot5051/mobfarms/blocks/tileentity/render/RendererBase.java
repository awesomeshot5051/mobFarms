package com.awesomeshot5051.mobfarms.blocks.tileentity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.awesomeshot5051.mobfarms.blocks.tileentity.FakeWorldTileentity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.core.*;
import net.minecraft.world.level.block.state.*;

import java.lang.ref.WeakReference;

public class RendererBase<T extends FakeWorldTileentity> extends BlockRendererBase<T> {

    protected WeakReference<VillagerRenderer> villagerRendererCache = new WeakReference<>(null);

    public RendererBase(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }
    private T tileEntity;
    @Override
    public void render(T tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(tileEntity, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        this.tileEntity = tileEntity;
    }

    protected VillagerRenderer getVillagerRenderer() {
        VillagerRenderer villagerRenderer = villagerRendererCache.get();
        if (villagerRenderer == null) {
            villagerRenderer = new VillagerRenderer(createEntityRenderer());
            villagerRendererCache = new WeakReference<>(villagerRenderer);
        }
        return villagerRenderer;
    }
    public Direction getDirection() {
        if (tileEntity != null && tileEntity.getLevel() != null) {
            tileEntity.getBlockPos();// Get the block state at the tile entity's position
            BlockState blockState = tileEntity.getLevel().getBlockState(tileEntity.getBlockPos());

            // Check if the block state has the FACING property
            if (blockState.hasProperty(FakeWorldTileentity.FACING)) {
                return blockState.getValue(FakeWorldTileentity.FACING);
            }
        }
        return Direction.NORTH; // Default or fallback direction
    }
    public void renderMob(PoseStack matrixStack) {
        Direction direction = getDirection();
        MobRendererUtil.renderMob(matrixStack, direction);
    }

}
