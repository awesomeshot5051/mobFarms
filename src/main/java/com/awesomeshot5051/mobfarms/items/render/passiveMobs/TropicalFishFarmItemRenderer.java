/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TropicalFishFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TropicalFishFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.TropicalFishFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class TropicalFishFarmItemRenderer extends BlockItemRendererBase<TropicalFishFarmRenderer, TropicalFishFarmTileentity> {
/*   0 */   public TropicalFishFarmItemRenderer() {
/*  11 */     super(TropicalFishFarmRenderer::new, () -> new TropicalFishFarmTileentity(BlockPos.ZERO, ((TropicalFishFarmBlock)ModBlocks.TROPICAL_FISH_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
