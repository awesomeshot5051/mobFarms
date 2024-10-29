package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PufferfishFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PufferfishFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PufferfishFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class PufferfishFarmItemRenderer extends BlockItemRendererBase<PufferfishFarmRenderer, PufferfishFarmTileentity> {
   public PufferfishFarmItemRenderer() {
/*  12 */     super(PufferfishFarmRenderer::new, () -> new PufferfishFarmTileentity(BlockPos.ZERO, ((PufferfishFarmBlock)ModBlocks.PUFFERFISH_FARM.get()).defaultBlockState()));
   }
}
