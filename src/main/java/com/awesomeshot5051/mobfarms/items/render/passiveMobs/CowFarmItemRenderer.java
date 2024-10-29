/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CowFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CowFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.CowFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class CowFarmItemRenderer extends BlockItemRendererBase<CowFarmRenderer, CowFarmTileentity> {
/*   0 */   public CowFarmItemRenderer() {
/*  12 */     super(CowFarmRenderer::new, () -> new CowFarmTileentity(BlockPos.ZERO, ((CowFarmBlock)ModBlocks.COW_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
