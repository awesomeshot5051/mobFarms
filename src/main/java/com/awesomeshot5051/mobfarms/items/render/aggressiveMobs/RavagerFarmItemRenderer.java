/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.RavagerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.RavagerFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.RavagerFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class RavagerFarmItemRenderer extends BlockItemRendererBase<RavagerFarmRenderer, RavagerFarmTileentity> {
/*   0 */   public RavagerFarmItemRenderer() {
/*  12 */     super(RavagerFarmRenderer::new, () -> new RavagerFarmTileentity(BlockPos.ZERO, ((RavagerFarmBlock)ModBlocks.RAVAGER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
