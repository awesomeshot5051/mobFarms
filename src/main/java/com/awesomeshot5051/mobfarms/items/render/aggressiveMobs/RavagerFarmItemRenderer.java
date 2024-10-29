package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.RavagerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.RavagerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.RavagerFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class RavagerFarmItemRenderer extends BlockItemRendererBase<RavagerFarmRenderer, RavagerFarmTileentity> {
   public RavagerFarmItemRenderer() {
/*  12 */     super(RavagerFarmRenderer::new, () -> new RavagerFarmTileentity(BlockPos.ZERO, ((RavagerFarmBlock)ModBlocks.RAVAGER_FARM.get()).defaultBlockState()));
   }
}
