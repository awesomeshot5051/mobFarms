package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherSkeletonFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitherSkeletonFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class WitherSkeletonFarmItemRenderer extends BlockItemRendererBase<WitherSkeletonFarmRenderer, WitherSkeletonFarmTileentity> {

    public WitherSkeletonFarmItemRenderer() {
        super(WitherSkeletonFarmRenderer::new, () -> new WitherSkeletonFarmTileentity(BlockPos.ZERO, ModBlocks.WITHER_SKELETON_FARM.get().defaultBlockState()));
    }

}
