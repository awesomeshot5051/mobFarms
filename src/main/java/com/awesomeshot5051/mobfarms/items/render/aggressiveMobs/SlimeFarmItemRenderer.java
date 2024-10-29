package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SlimeFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SlimeFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.SlimeFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class SlimeFarmItemRenderer extends BlockItemRendererBase<SlimeFarmRenderer, SlimeFarmTileentity> {
   public SlimeFarmItemRenderer() {
/*  12 */     super(SlimeFarmRenderer::new, () -> new SlimeFarmTileentity(BlockPos.ZERO, ((SlimeFarmBlock)ModBlocks.SLIME_FARM.get()).defaultBlockState()));
   }
}
