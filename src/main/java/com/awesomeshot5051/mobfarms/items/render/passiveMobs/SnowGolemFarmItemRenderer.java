package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SnowGolemFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SnowGolemFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SnowGolemFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class SnowGolemFarmItemRenderer extends BlockItemRendererBase<SnowGolemFarmRenderer, SnowGolemFarmTileentity> {
   public SnowGolemFarmItemRenderer() {
/*  11 */     super(SnowGolemFarmRenderer::new, () -> new SnowGolemFarmTileentity(BlockPos.ZERO, ((SnowGolemFarmBlock)ModBlocks.SNOW_GOLEM_FARM.get()).defaultBlockState()));
   }
}
