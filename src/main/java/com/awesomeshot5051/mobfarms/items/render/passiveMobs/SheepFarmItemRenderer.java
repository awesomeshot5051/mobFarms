/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SheepFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SheepFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class SheepFarmItemRenderer extends BlockItemRendererBase<SheepFarmRenderer, SheepFarmTileentity> {
/*   0 */   public SheepFarmItemRenderer() {
/*  11 */     super(SheepFarmRenderer::new, () -> new SheepFarmTileentity(BlockPos.ZERO, ((SheepFarmBlock)ModBlocks.SHEEP_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
