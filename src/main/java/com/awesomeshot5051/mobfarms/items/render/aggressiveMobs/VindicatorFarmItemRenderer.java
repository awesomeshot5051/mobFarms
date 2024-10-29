package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.VindicatorFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.VindicatorFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.VindicatorFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class VindicatorFarmItemRenderer extends BlockItemRendererBase<VindicatorFarmRenderer, VindicatorFarmTileentity> {
   public VindicatorFarmItemRenderer() {
/*  12 */     super(VindicatorFarmRenderer::new, () -> new VindicatorFarmTileentity(BlockPos.ZERO, ((VindicatorFarmBlock)ModBlocks.VINDICATOR_FARM.get()).defaultBlockState()));
   }
}
