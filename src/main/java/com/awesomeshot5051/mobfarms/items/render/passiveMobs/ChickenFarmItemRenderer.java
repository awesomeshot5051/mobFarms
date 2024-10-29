/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.ChickenFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ChickenFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.ChickenFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class ChickenFarmItemRenderer extends BlockItemRendererBase<ChickenFarmRenderer, ChickenFarmTileentity> {
/*   0 */   public ChickenFarmItemRenderer() {
/*  13 */     super(ChickenFarmRenderer::new, () -> new ChickenFarmTileentity(BlockPos.ZERO, ((ChickenFarmBlock)ModBlocks.CHICKEN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
