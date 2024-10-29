package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.DrownedFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.DrownedFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.DrownedFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class DrownedFarmItemRenderer extends BlockItemRendererBase<DrownedFarmRenderer, DrownedFarmTileentity> {
   public DrownedFarmItemRenderer() {
/*  12 */     super(DrownedFarmRenderer::new, () -> new DrownedFarmTileentity(BlockPos.ZERO, ((DrownedFarmBlock)ModBlocks.DROWNED_FARM.get()).defaultBlockState()));
   }
}
