/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitherFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class WitherFarmItemRenderer extends BlockItemRendererBase<WitherFarmRenderer, WitherFarmTileentity> {
/*   0 */   public WitherFarmItemRenderer() {
/*  12 */     super(WitherFarmRenderer::new, () -> new WitherFarmTileentity(BlockPos.ZERO, ((WitherFarmBlock)ModBlocks.WITHER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
