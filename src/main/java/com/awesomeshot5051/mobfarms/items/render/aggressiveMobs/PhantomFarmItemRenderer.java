package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PhantomFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PhantomFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.PhantomFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class PhantomFarmItemRenderer extends BlockItemRendererBase<PhantomFarmRenderer, PhantomFarmTileentity> {
   public PhantomFarmItemRenderer() {
/*  12 */     super(PhantomFarmRenderer::new, () -> new PhantomFarmTileentity(BlockPos.ZERO, ((PhantomFarmBlock)ModBlocks.PHANTOM_FARM.get()).defaultBlockState()));
   }
}
