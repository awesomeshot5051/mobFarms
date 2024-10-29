/*   0 */ package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.PiglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.PiglinFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.PiglinFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class PiglinFarmItemRenderer extends BlockItemRendererBase<PiglinFarmRenderer, PiglinFarmTileentity> {
/*   0 */   public PiglinFarmItemRenderer() {
/*  11 */     super(PiglinFarmRenderer::new, () -> new PiglinFarmTileentity(BlockPos.ZERO, ((PiglinFarmBlock)ModBlocks.PIGLIN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
