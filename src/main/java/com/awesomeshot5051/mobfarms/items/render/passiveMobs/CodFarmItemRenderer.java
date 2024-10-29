/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CodFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CodFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.CodFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class CodFarmItemRenderer extends BlockItemRendererBase<CodFarmRenderer, CodFarmTileentity> {
/*   0 */   public CodFarmItemRenderer() {
/*  11 */     super(CodFarmRenderer::new, () -> new CodFarmTileentity(BlockPos.ZERO, ((CodFarmBlock)ModBlocks.COD_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
