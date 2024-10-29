/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZoglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZoglinFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZoglinFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class ZoglinFarmItemRenderer extends BlockItemRendererBase<ZoglinFarmRenderer, ZoglinFarmTileentity> {
/*   0 */   public ZoglinFarmItemRenderer() {
/*  12 */     super(ZoglinFarmRenderer::new, () -> new ZoglinFarmTileentity(BlockPos.ZERO, ((ZoglinFarmBlock)ModBlocks.ZOGLIN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
