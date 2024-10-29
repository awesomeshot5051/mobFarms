package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitchFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitchFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitchFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class WitchFarmItemRenderer extends BlockItemRendererBase<WitchFarmRenderer, WitchFarmTileentity> {
   public WitchFarmItemRenderer() {
/*  12 */     super(WitchFarmRenderer::new, () -> new WitchFarmTileentity(BlockPos.ZERO, ((WitchFarmBlock)ModBlocks.WITCH_FARM.get()).defaultBlockState()));
   }
}
