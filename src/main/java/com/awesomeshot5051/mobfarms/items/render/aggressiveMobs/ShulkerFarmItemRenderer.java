/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ShulkerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ShulkerFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ShulkerFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class ShulkerFarmItemRenderer extends BlockItemRendererBase<ShulkerFarmRenderer, ShulkerFarmTileentity> {
/*   0 */   public ShulkerFarmItemRenderer() {
/*  12 */     super(ShulkerFarmRenderer::new, () -> new ShulkerFarmTileentity(BlockPos.ZERO, ((ShulkerFarmBlock)ModBlocks.SHULKER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
