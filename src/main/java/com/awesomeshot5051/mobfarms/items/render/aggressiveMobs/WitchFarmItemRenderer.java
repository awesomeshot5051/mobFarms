/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitchFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitchFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitchFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class WitchFarmItemRenderer extends BlockItemRendererBase<WitchFarmRenderer, WitchFarmTileentity> {
/*   0 */   public WitchFarmItemRenderer() {
/*  12 */     super(WitchFarmRenderer::new, () -> new WitchFarmTileentity(BlockPos.ZERO, ((WitchFarmBlock)ModBlocks.WITCH_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
