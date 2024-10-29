package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitherFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class WitherFarmItemRenderer extends BlockItemRendererBase<WitherFarmRenderer, WitherFarmTileentity> {
   public WitherFarmItemRenderer() {
/*  12 */     super(WitherFarmRenderer::new, () -> new WitherFarmTileentity(BlockPos.ZERO, ((WitherFarmBlock)ModBlocks.WITHER_FARM.get()).defaultBlockState()));
   }
}
