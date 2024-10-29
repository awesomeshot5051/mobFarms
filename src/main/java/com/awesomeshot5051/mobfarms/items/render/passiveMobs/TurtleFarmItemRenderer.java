/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TurtleFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TurtleFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.TurtleFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class TurtleFarmItemRenderer extends BlockItemRendererBase<TurtleFarmRenderer, TurtleFarmTileentity> {
/*   0 */   public TurtleFarmItemRenderer() {
/*  11 */     super(TurtleFarmRenderer::new, () -> new TurtleFarmTileentity(BlockPos.ZERO, ((TurtleFarmBlock)ModBlocks.TURTLE_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
