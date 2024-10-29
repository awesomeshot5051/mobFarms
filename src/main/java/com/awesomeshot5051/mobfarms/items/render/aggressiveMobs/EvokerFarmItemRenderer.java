package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.EvokerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.EvokerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.EvokerFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class EvokerFarmItemRenderer extends BlockItemRendererBase<EvokerFarmRenderer, EvokerFarmTileentity> {
   public EvokerFarmItemRenderer() {
/*  12 */     super(EvokerFarmRenderer::new, () -> new EvokerFarmTileentity(BlockPos.ZERO, ((EvokerFarmBlock)ModBlocks.EVOKER_FARM.get()).defaultBlockState()));
   }
}
