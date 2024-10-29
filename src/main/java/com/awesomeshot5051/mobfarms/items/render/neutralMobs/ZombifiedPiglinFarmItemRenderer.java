package com.awesomeshot5051.mobfarms.items.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.ZombifiedPiglinFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.ZombifiedPiglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.ZombifiedPiglinFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class ZombifiedPiglinFarmItemRenderer extends BlockItemRendererBase<ZombifiedPiglinFarmRenderer, ZombifiedPiglinFarmTileentity> {
   public ZombifiedPiglinFarmItemRenderer() {
/*  13 */     super(ZombifiedPiglinFarmRenderer::new, () -> new ZombifiedPiglinFarmTileentity(BlockPos.ZERO, ((ZombifiedPiglinFarmBlock)ModBlocks.ZOMBIFIED_PIGLIN_FARM.get()).defaultBlockState()));
   }
}
