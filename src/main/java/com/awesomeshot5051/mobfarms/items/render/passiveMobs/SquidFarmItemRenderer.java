/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SquidFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SquidFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SquidFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class SquidFarmItemRenderer extends BlockItemRendererBase<SquidFarmRenderer, SquidFarmTileentity> {
/*   0 */   public SquidFarmItemRenderer() {
/*  11 */     super(SquidFarmRenderer::new, () -> new SquidFarmTileentity(BlockPos.ZERO, ((SquidFarmBlock)ModBlocks.SQUID_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
