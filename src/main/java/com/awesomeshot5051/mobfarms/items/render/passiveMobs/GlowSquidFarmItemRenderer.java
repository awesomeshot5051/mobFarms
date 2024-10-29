package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.GlowSquidFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.GlowSquidFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.GlowSquidFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class GlowSquidFarmItemRenderer extends BlockItemRendererBase<GlowSquidFarmRenderer, GlowSquidFarmTileentity> {
   public GlowSquidFarmItemRenderer() {
/*  13 */     super(GlowSquidFarmRenderer::new, () -> new GlowSquidFarmTileentity(BlockPos.ZERO, ((GlowSquidFarmBlock)ModBlocks.GLOW_SQUID_FARM.get()).defaultBlockState()));
   }
}
