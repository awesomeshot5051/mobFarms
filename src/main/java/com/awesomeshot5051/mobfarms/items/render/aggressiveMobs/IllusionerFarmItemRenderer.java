/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.IllusionerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.IllusionerFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.IllusionerFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class IllusionerFarmItemRenderer extends BlockItemRendererBase<IllusionerFarmRenderer, IllusionerFarmTileentity> {
/*   0 */   public IllusionerFarmItemRenderer() {
/*  12 */     super(IllusionerFarmRenderer::new, () -> new IllusionerFarmTileentity(BlockPos.ZERO, ((IllusionerFarmBlock)ModBlocks.ILLUSIONER_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
