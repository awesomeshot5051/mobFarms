/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ElderGuardianFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ElderGuardianFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ElderGuardianFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class ElderGuardianFarmItemRenderer extends BlockItemRendererBase<ElderGuardianFarmRenderer, ElderGuardianFarmTileentity> {
/*   0 */   public ElderGuardianFarmItemRenderer() {
/*  12 */     super(ElderGuardianFarmRenderer::new, () -> new ElderGuardianFarmTileentity(BlockPos.ZERO, ((ElderGuardianFarmBlock)ModBlocks.ELDER_GUARDIAN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
