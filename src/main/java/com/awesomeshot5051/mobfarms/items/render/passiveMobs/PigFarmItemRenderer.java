/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PigFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PigFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class PigFarmItemRenderer extends BlockItemRendererBase<PigFarmRenderer, PigFarmTileentity> {
/*   0 */   public PigFarmItemRenderer() {
/*  11 */     super(PigFarmRenderer::new, () -> new PigFarmTileentity(BlockPos.ZERO, ((PigFarmBlock)ModBlocks.PIG_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
