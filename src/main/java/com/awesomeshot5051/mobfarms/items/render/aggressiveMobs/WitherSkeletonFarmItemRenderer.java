package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherSkeletonFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherSkeletonFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitherSkeletonFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class WitherSkeletonFarmItemRenderer extends BlockItemRendererBase<WitherSkeletonFarmRenderer, WitherSkeletonFarmTileentity> {
   public WitherSkeletonFarmItemRenderer() {
/*  12 */     super(WitherSkeletonFarmRenderer::new, () -> new WitherSkeletonFarmTileentity(BlockPos.ZERO, ((WitherSkeletonFarmBlock)ModBlocks.WITHER_SKELETON_FARM.get()).defaultBlockState()));
   }
}
