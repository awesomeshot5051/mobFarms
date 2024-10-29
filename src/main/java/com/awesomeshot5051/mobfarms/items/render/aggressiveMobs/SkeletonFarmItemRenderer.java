/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SkeletonFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SkeletonFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.SkeletonFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class SkeletonFarmItemRenderer extends BlockItemRendererBase<SkeletonFarmRenderer, SkeletonFarmTileentity> {
/*   0 */   public SkeletonFarmItemRenderer() {
/*  12 */     super(SkeletonFarmRenderer::new, () -> new SkeletonFarmTileentity(BlockPos.ZERO, ((SkeletonFarmBlock)ModBlocks.SKELETON_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
