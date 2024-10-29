/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.StriderFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.StriderFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.StriderFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class StriderFarmItemRenderer extends BlockItemRendererBase<StriderFarmRenderer, StriderFarmTileentity> {
/*   0 */   public StriderFarmItemRenderer() {
/*  11 */     super(StriderFarmRenderer::new, () -> new StriderFarmTileentity(BlockPos.ZERO, ((StriderFarmBlock)ModBlocks.STRIDER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
