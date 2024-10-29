/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.VindicatorFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.VindicatorFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.VindicatorFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class VindicatorFarmItemRenderer extends BlockItemRendererBase<VindicatorFarmRenderer, VindicatorFarmTileentity> {
/*   0 */   public VindicatorFarmItemRenderer() {
/*  12 */     super(VindicatorFarmRenderer::new, () -> new VindicatorFarmTileentity(BlockPos.ZERO, ((VindicatorFarmBlock)ModBlocks.VINDICATOR_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
