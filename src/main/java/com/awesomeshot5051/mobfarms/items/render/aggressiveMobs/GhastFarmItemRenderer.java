/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GhastFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GhastFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.GhastFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class GhastFarmItemRenderer extends BlockItemRendererBase<GhastFarmRenderer, GhastFarmTileentity> {
/*   0 */   public GhastFarmItemRenderer() {
/*  12 */     super(GhastFarmRenderer::new, () -> new GhastFarmTileentity(BlockPos.ZERO, ((GhastFarmBlock)ModBlocks.GHAST_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
