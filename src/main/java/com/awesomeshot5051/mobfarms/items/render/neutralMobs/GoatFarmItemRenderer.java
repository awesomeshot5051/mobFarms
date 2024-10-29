/*   0 */ package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.GoatFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.GoatFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.GoatFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class GoatFarmItemRenderer extends BlockItemRendererBase<GoatFarmRenderer, GoatFarmTileentity> {
/*   0 */   public GoatFarmItemRenderer() {
/*  11 */     super(GoatFarmRenderer::new, () -> new GoatFarmTileentity(BlockPos.ZERO, ((GoatFarmBlock)ModBlocks.GOAT_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
