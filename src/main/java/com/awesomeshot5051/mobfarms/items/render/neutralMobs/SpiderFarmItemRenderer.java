/*   0 */ package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.SpiderFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.SpiderFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.SpiderFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class SpiderFarmItemRenderer extends BlockItemRendererBase<SpiderFarmRenderer, SpiderFarmTileentity> {
/*   0 */   public SpiderFarmItemRenderer() {
/*  11 */     super(SpiderFarmRenderer::new, () -> new SpiderFarmTileentity(BlockPos.ZERO, ((SpiderFarmBlock)ModBlocks.SPIDER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
