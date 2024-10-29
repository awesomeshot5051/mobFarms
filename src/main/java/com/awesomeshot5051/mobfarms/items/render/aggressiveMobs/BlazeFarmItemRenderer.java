/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.BlazeFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.BlazeFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.BlazeFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class BlazeFarmItemRenderer extends BlockItemRendererBase<BlazeFarmRenderer, BlazeFarmTileentity> {
/*   0 */   public BlazeFarmItemRenderer() {
/*  12 */     super(BlazeFarmRenderer::new, () -> new BlazeFarmTileentity(BlockPos.ZERO, ((BlazeFarmBlock)ModBlocks.BLAZE_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
