package com.awesomeshot5051.mobfarms.items.render.neutralMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.IronFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.IronFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.IronFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class IronFarmItemRenderer extends BlockItemRendererBase<IronFarmRenderer, IronFarmTileentity> {
   public IronFarmItemRenderer() {
/*  12 */     super(IronFarmRenderer::new, () -> new IronFarmTileentity(BlockPos.ZERO, ((IronFarmBlock)ModBlocks.IRON_FARM.get()).defaultBlockState()));
   }
}
