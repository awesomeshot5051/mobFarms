/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.DrownedFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.DrownedFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.DrownedFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class DrownedFarmItemRenderer extends BlockItemRendererBase<DrownedFarmRenderer, DrownedFarmTileentity> {
/*   0 */   public DrownedFarmItemRenderer() {
/*  12 */     super(DrownedFarmRenderer::new, () -> new DrownedFarmTileentity(BlockPos.ZERO, ((DrownedFarmBlock)ModBlocks.DROWNED_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
