package com.awesomeshot5051.mobfarms.items.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.GoatFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.GoatFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.GoatFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class GoatFarmItemRenderer extends BlockItemRendererBase<GoatFarmRenderer, GoatFarmTileentity> {
   public GoatFarmItemRenderer() {
/*  11 */     super(GoatFarmRenderer::new, () -> new GoatFarmTileentity(BlockPos.ZERO, ((GoatFarmBlock)ModBlocks.GOAT_FARM.get()).defaultBlockState()));
   }
}
