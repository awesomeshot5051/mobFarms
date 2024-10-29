/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherSkeletonFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherSkeletonFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitherSkeletonFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class WitherSkeletonFarmItemRenderer extends BlockItemRendererBase<WitherSkeletonFarmRenderer, WitherSkeletonFarmTileentity> {
/*   0 */   public WitherSkeletonFarmItemRenderer() {
/*  12 */     super(WitherSkeletonFarmRenderer::new, () -> new WitherSkeletonFarmTileentity(BlockPos.ZERO, ((WitherSkeletonFarmBlock)ModBlocks.WITHER_SKELETON_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
