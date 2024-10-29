/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WardenFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WardenFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WardenFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class WardenFarmItemRenderer extends BlockItemRendererBase<WardenFarmRenderer, WardenFarmTileentity> {
/*   0 */   public WardenFarmItemRenderer() {
/*  12 */     super(WardenFarmRenderer::new, () -> new WardenFarmTileentity(BlockPos.ZERO, ((WardenFarmBlock)ModBlocks.WARDEN_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
