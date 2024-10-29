/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.ParrotFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ParrotFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.ParrotFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class ParrotFarmItemRenderer extends BlockItemRendererBase<ParrotFarmRenderer, ParrotFarmTileentity> {
/*   0 */   public ParrotFarmItemRenderer() {
/*  11 */     super(ParrotFarmRenderer::new, () -> new ParrotFarmTileentity(BlockPos.ZERO, ((ParrotFarmBlock)ModBlocks.PARROT_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
