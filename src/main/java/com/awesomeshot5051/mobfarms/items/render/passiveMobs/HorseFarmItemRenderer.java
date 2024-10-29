/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.HorseFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.HorseFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.HorseFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class HorseFarmItemRenderer extends BlockItemRendererBase<HorseFarmRenderer, HorseFarmTileentity> {
/*   0 */   public HorseFarmItemRenderer() {
/*  12 */     super(HorseFarmRenderer::new, () -> new HorseFarmTileentity(BlockPos.ZERO, ((HorseFarmBlock)ModBlocks.HORSE_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
