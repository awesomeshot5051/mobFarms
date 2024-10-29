/*   0 */ package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.ZombifiedPiglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.ZombifiedPiglinFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.ZombifiedPiglinFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class ZombifiedPiglinFarmItemRenderer extends BlockItemRendererBase<ZombifiedPiglinFarmRenderer, ZombifiedPiglinFarmTileentity> {
/*   0 */   public ZombifiedPiglinFarmItemRenderer() {
/*  13 */     super(ZombifiedPiglinFarmRenderer::new, () -> new ZombifiedPiglinFarmTileentity(BlockPos.ZERO, ((ZombifiedPiglinFarmBlock)ModBlocks.ZOMBIFIED_PIGLIN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
