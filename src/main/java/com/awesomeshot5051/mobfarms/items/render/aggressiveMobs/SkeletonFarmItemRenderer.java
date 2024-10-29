package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SkeletonFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SkeletonFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.SkeletonFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class SkeletonFarmItemRenderer extends BlockItemRendererBase<SkeletonFarmRenderer, SkeletonFarmTileentity> {
   public SkeletonFarmItemRenderer() {
/*  12 */     super(SkeletonFarmRenderer::new, () -> new SkeletonFarmTileentity(BlockPos.ZERO, ((SkeletonFarmBlock)ModBlocks.SKELETON_FARM.get()).defaultBlockState()));
   }
}
