/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZombieFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZombieFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZombieFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class ZombieFarmItemRenderer extends BlockItemRendererBase<ZombieFarmRenderer, ZombieFarmTileentity> {
/*   0 */   public ZombieFarmItemRenderer() {
/*  12 */     super(ZombieFarmRenderer::new, () -> new ZombieFarmTileentity(BlockPos.ZERO, ((ZombieFarmBlock)ModBlocks.ZOMBIE_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
