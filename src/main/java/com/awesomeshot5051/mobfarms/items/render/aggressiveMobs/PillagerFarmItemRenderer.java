package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PillagerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PillagerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.PillagerFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class PillagerFarmItemRenderer extends BlockItemRendererBase<PillagerFarmRenderer, PillagerFarmTileentity> {
   public PillagerFarmItemRenderer() {
/*  12 */     super(PillagerFarmRenderer::new, () -> new PillagerFarmTileentity(BlockPos.ZERO, ((PillagerFarmBlock)ModBlocks.PILLAGER_FARM.get()).defaultBlockState()));
   }
}
