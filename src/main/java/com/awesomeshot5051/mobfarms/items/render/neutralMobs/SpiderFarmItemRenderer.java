package com.awesomeshot5051.mobfarms.items.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.SpiderFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.SpiderFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.SpiderFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class SpiderFarmItemRenderer extends BlockItemRendererBase<SpiderFarmRenderer, SpiderFarmTileentity> {
   public SpiderFarmItemRenderer() {
/*  11 */     super(SpiderFarmRenderer::new, () -> new SpiderFarmTileentity(BlockPos.ZERO, ((SpiderFarmBlock)ModBlocks.SPIDER_FARM.get()).defaultBlockState()));
   }
}
