package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.MooshroomFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.MooshroomFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.MooshroomFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class MooshroomFarmItemRenderer extends BlockItemRendererBase<MooshroomFarmRenderer, MooshroomFarmTileentity> {
   public MooshroomFarmItemRenderer() {
/*  11 */     super(MooshroomFarmRenderer::new, () -> new MooshroomFarmTileentity(BlockPos.ZERO, ((MooshroomFarmBlock)ModBlocks.MOOSHROOM_FARM.get()).defaultBlockState()));
   }
}
