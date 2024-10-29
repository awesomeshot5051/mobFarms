package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZombieFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZombieFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZombieFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class ZombieFarmItemRenderer extends BlockItemRendererBase<ZombieFarmRenderer, ZombieFarmTileentity> {
   public ZombieFarmItemRenderer() {
/*  12 */     super(ZombieFarmRenderer::new, () -> new ZombieFarmTileentity(BlockPos.ZERO, ((ZombieFarmBlock)ModBlocks.ZOMBIE_FARM.get()).defaultBlockState()));
   }
}
