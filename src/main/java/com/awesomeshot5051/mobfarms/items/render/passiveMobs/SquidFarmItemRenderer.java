package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SquidFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SquidFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SquidFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class SquidFarmItemRenderer extends BlockItemRendererBase<SquidFarmRenderer, SquidFarmTileentity> {
   public SquidFarmItemRenderer() {
/*  11 */     super(SquidFarmRenderer::new, () -> new SquidFarmTileentity(BlockPos.ZERO, ((SquidFarmBlock)ModBlocks.SQUID_FARM.get()).defaultBlockState()));
   }
}
