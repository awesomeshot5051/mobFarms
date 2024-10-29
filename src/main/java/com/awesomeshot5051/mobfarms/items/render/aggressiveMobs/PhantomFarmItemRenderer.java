/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PhantomFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PhantomFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.PhantomFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class PhantomFarmItemRenderer extends BlockItemRendererBase<PhantomFarmRenderer, PhantomFarmTileentity> {
/*   0 */   public PhantomFarmItemRenderer() {
/*  12 */     super(PhantomFarmRenderer::new, () -> new PhantomFarmTileentity(BlockPos.ZERO, ((PhantomFarmBlock)ModBlocks.PHANTOM_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
