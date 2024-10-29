/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SalmonFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SalmonFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SalmonFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class SalmonFarmItemRenderer extends BlockItemRendererBase<SalmonFarmRenderer, SalmonFarmTileentity> {
/*   0 */   public SalmonFarmItemRenderer() {
/*  11 */     super(SalmonFarmRenderer::new, () -> new SalmonFarmTileentity(BlockPos.ZERO, ((SalmonFarmBlock)ModBlocks.SALMON_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
