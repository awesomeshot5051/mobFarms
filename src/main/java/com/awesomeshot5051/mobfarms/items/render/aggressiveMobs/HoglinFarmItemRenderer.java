/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.HoglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.HoglinFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.HoglinFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class HoglinFarmItemRenderer extends BlockItemRendererBase<HoglinFarmRenderer, HoglinFarmTileentity> {
/*   0 */   public HoglinFarmItemRenderer() {
/*  12 */     super(HoglinFarmRenderer::new, () -> new HoglinFarmTileentity(BlockPos.ZERO, ((HoglinFarmBlock)ModBlocks.HOGLIN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
