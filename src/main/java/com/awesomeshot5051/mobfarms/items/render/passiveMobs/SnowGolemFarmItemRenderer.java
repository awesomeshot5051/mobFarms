/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SnowGolemFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SnowGolemFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SnowGolemFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class SnowGolemFarmItemRenderer extends BlockItemRendererBase<SnowGolemFarmRenderer, SnowGolemFarmTileentity> {
/*   0 */   public SnowGolemFarmItemRenderer() {
/*  11 */     super(SnowGolemFarmRenderer::new, () -> new SnowGolemFarmTileentity(BlockPos.ZERO, ((SnowGolemFarmBlock)ModBlocks.SNOW_GOLEM_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
