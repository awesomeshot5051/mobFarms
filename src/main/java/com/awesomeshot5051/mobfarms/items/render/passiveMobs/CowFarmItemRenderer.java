package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CowFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CowFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.CowFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class CowFarmItemRenderer extends BlockItemRendererBase<CowFarmRenderer, CowFarmTileentity> {
   public CowFarmItemRenderer() {
/*  12 */     super(CowFarmRenderer::new, () -> new CowFarmTileentity(BlockPos.ZERO, ((CowFarmBlock)ModBlocks.COW_FARM.get()).defaultBlockState()));
   }
}
