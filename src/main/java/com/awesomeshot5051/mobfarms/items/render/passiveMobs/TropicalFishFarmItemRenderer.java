package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TropicalFishFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TropicalFishFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.TropicalFishFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class TropicalFishFarmItemRenderer extends BlockItemRendererBase<TropicalFishFarmRenderer, TropicalFishFarmTileentity> {
   public TropicalFishFarmItemRenderer() {
/*  11 */     super(TropicalFishFarmRenderer::new, () -> new TropicalFishFarmTileentity(BlockPos.ZERO, ((TropicalFishFarmBlock)ModBlocks.TROPICAL_FISH_FARM.get()).defaultBlockState()));
   }
}
