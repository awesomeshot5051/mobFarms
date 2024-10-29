/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PufferfishFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PufferfishFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PufferfishFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class PufferfishFarmItemRenderer extends BlockItemRendererBase<PufferfishFarmRenderer, PufferfishFarmTileentity> {
/*   0 */   public PufferfishFarmItemRenderer() {
/*  12 */     super(PufferfishFarmRenderer::new, () -> new PufferfishFarmTileentity(BlockPos.ZERO, ((PufferfishFarmBlock)ModBlocks.PUFFERFISH_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
