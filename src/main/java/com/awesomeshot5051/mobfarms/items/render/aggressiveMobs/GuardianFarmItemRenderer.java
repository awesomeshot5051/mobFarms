package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GuardianFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GuardianFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.GuardianFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class GuardianFarmItemRenderer extends BlockItemRendererBase<GuardianFarmRenderer, GuardianFarmTileentity> {
   public GuardianFarmItemRenderer() {
/*  12 */     super(GuardianFarmRenderer::new, () -> new GuardianFarmTileentity(BlockPos.ZERO, ((GuardianFarmBlock)ModBlocks.GUARDIAN_FARM.get()).defaultBlockState()));
   }
}
