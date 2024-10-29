package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.StriderFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.StriderFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.StriderFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class StriderFarmItemRenderer extends BlockItemRendererBase<StriderFarmRenderer, StriderFarmTileentity> {
   public StriderFarmItemRenderer() {
/*  11 */     super(StriderFarmRenderer::new, () -> new StriderFarmTileentity(BlockPos.ZERO, ((StriderFarmBlock)ModBlocks.STRIDER_FARM.get()).defaultBlockState()));
   }
}
