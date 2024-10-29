package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZoglinFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZoglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZoglinFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class ZoglinFarmItemRenderer extends BlockItemRendererBase<ZoglinFarmRenderer, ZoglinFarmTileentity> {
   public ZoglinFarmItemRenderer() {
/*  12 */     super(ZoglinFarmRenderer::new, () -> new ZoglinFarmTileentity(BlockPos.ZERO, ((ZoglinFarmBlock)ModBlocks.ZOGLIN_FARM.get()).defaultBlockState()));
   }
}
