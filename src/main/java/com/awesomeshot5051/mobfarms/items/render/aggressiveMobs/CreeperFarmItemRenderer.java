/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.CreeperFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.CreeperFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.CreeperFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class CreeperFarmItemRenderer extends BlockItemRendererBase<CreeperFarmRenderer, CreeperFarmTileentity> {
/*   0 */   public CreeperFarmItemRenderer() {
/*  11 */     super(CreeperFarmRenderer::new, () -> new CreeperFarmTileentity(BlockPos.ZERO, ((CreeperFarmBlock)ModBlocks.CREEPER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
