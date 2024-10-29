package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PufferfishFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PufferfishFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class PufferfishFarmItemRenderer extends BlockItemRendererBase<PufferfishFarmRenderer, PufferfishFarmTileentity> {  
  
  public PufferfishFarmItemRenderer() {  
    super(PufferfishFarmRenderer::new, () -> new PufferfishFarmTileentity(BlockPos.ZERO, ModBlocks.PUFFERFISH_FARM.get().defaultBlockState()));  
  }

}
