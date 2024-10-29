package com.awesomeshot5051.mobfarms.items.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.EndermanFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.EndermanFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.EndermanFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class EndermanFarmItemRenderer extends BlockItemRendererBase<EndermanFarmRenderer, EndermanFarmTileentity> {
   public EndermanFarmItemRenderer() {
/*  11 */     super(EndermanFarmRenderer::new, () -> new EndermanFarmTileentity(BlockPos.ZERO, ((EndermanFarmBlock)ModBlocks.ENDERMAN_FARM.get()).defaultBlockState()));
   }
}
