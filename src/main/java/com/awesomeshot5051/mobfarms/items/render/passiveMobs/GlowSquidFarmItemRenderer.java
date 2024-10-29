/*   0 */ package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.GlowSquidFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.GlowSquidFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.GlowSquidFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class GlowSquidFarmItemRenderer extends BlockItemRendererBase<GlowSquidFarmRenderer, GlowSquidFarmTileentity> {
/*   0 */   public GlowSquidFarmItemRenderer() {
/*  13 */     super(GlowSquidFarmRenderer::new, () -> new GlowSquidFarmTileentity(BlockPos.ZERO, ((GlowSquidFarmBlock)ModBlocks.GLOW_SQUID_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
