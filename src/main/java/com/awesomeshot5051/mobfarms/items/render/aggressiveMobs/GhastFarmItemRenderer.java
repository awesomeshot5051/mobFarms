package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GhastFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GhastFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.GhastFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class GhastFarmItemRenderer extends BlockItemRendererBase<GhastFarmRenderer, GhastFarmTileentity> {
   public GhastFarmItemRenderer() {
/*  12 */     super(GhastFarmRenderer::new, () -> new GhastFarmTileentity(BlockPos.ZERO, ((GhastFarmBlock)ModBlocks.GHAST_FARM.get()).defaultBlockState()));
   }
}
