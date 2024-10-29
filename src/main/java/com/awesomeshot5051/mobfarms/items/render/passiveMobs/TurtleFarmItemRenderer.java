package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TurtleFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TurtleFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.TurtleFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class TurtleFarmItemRenderer extends BlockItemRendererBase<TurtleFarmRenderer, TurtleFarmTileentity> {
   public TurtleFarmItemRenderer() {
/*  11 */     super(TurtleFarmRenderer::new, () -> new TurtleFarmTileentity(BlockPos.ZERO, ((TurtleFarmBlock)ModBlocks.TURTLE_FARM.get()).defaultBlockState()));
   }
}
