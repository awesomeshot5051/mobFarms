/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.RabbitFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.RabbitFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.RabbitFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class RabbitFarmItemRenderer extends BlockItemRendererBase<RabbitFarmRenderer, RabbitFarmTileentity> {
/*   0 */   public RabbitFarmItemRenderer() {
/*  11 */     super(RabbitFarmRenderer::new, () -> new RabbitFarmTileentity(BlockPos.ZERO, ((RabbitFarmBlock)ModBlocks.RABBIT_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
