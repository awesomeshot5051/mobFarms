/*   0 */ package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.EndermanFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.EndermanFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.EndermanFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class EndermanFarmItemRenderer extends BlockItemRendererBase<EndermanFarmRenderer, EndermanFarmTileentity> {
/*   0 */   public EndermanFarmItemRenderer() {
/*  11 */     super(EndermanFarmRenderer::new, () -> new EndermanFarmTileentity(BlockPos.ZERO, ((EndermanFarmBlock)ModBlocks.ENDERMAN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
