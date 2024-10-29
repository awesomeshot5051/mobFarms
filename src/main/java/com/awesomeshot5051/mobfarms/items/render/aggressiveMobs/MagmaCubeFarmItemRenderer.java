/*   0 */ package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.MagmaCubeFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.MagmaCubeFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.MagmaCubeFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class MagmaCubeFarmItemRenderer extends BlockItemRendererBase<MagmaCubeFarmRenderer, MagmaCubeFarmTileentity> {
/*   0 */   public MagmaCubeFarmItemRenderer() {
/*  12 */     super(MagmaCubeFarmRenderer::new, () -> new MagmaCubeFarmTileentity(BlockPos.ZERO, ((MagmaCubeFarmBlock)ModBlocks.MAGMA_CUBE_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
