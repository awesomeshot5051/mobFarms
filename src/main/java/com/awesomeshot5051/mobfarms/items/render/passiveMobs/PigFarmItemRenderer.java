package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PigFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PigFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class PigFarmItemRenderer extends BlockItemRendererBase<PigFarmRenderer, PigFarmTileentity> {
   public PigFarmItemRenderer() {
/*  11 */     super(PigFarmRenderer::new, () -> new PigFarmTileentity(BlockPos.ZERO, ((PigFarmBlock)ModBlocks.PIG_FARM.get()).defaultBlockState()));
   }
}
