package com.awesomeshot5051.mobfarms.items.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.PiglinFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.PiglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.PiglinFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class PiglinFarmItemRenderer extends BlockItemRendererBase<PiglinFarmRenderer, PiglinFarmTileentity> {
   public PiglinFarmItemRenderer() {
/*  11 */     super(PiglinFarmRenderer::new, () -> new PiglinFarmTileentity(BlockPos.ZERO, ((PiglinFarmBlock)ModBlocks.PIGLIN_FARM.get()).defaultBlockState()));
   }
}
