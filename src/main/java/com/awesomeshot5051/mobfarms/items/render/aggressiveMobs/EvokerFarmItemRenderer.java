/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.EvokerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.EvokerFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.EvokerFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class EvokerFarmItemRenderer extends BlockItemRendererBase<EvokerFarmRenderer, EvokerFarmTileentity> {
/*   0 */   public EvokerFarmItemRenderer() {
/*  12 */     super(EvokerFarmRenderer::new, () -> new EvokerFarmTileentity(BlockPos.ZERO, ((EvokerFarmBlock)ModBlocks.EVOKER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
