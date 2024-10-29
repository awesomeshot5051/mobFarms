/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SlimeFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SlimeFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.SlimeFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class SlimeFarmItemRenderer extends BlockItemRendererBase<SlimeFarmRenderer, SlimeFarmTileentity> {
/*   0 */   public SlimeFarmItemRenderer() {
/*  12 */     super(SlimeFarmRenderer::new, () -> new SlimeFarmTileentity(BlockPos.ZERO, ((SlimeFarmBlock)ModBlocks.SLIME_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
