/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GuardianFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GuardianFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.GuardianFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class GuardianFarmItemRenderer extends BlockItemRendererBase<GuardianFarmRenderer, GuardianFarmTileentity> {
/*   0 */   public GuardianFarmItemRenderer() {
/*  12 */     super(GuardianFarmRenderer::new, () -> new GuardianFarmTileentity(BlockPos.ZERO, ((GuardianFarmBlock)ModBlocks.GUARDIAN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
