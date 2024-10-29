/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.MooshroomFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.MooshroomFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.MooshroomFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class MooshroomFarmItemRenderer extends BlockItemRendererBase<MooshroomFarmRenderer, MooshroomFarmTileentity> {
/*   0 */   public MooshroomFarmItemRenderer() {
/*  11 */     super(MooshroomFarmRenderer::new, () -> new MooshroomFarmTileentity(BlockPos.ZERO, ((MooshroomFarmBlock)ModBlocks.MOOSHROOM_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
