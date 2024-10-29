/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PillagerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PillagerFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.PillagerFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class PillagerFarmItemRenderer extends BlockItemRendererBase<PillagerFarmRenderer, PillagerFarmTileentity> {
/*   0 */   public PillagerFarmItemRenderer() {
/*  12 */     super(PillagerFarmRenderer::new, () -> new PillagerFarmTileentity(BlockPos.ZERO, ((PillagerFarmBlock)ModBlocks.PILLAGER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
