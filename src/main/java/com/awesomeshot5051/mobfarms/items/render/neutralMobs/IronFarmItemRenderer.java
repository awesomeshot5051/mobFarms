/*   0 */ package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.IronFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.IronFarmTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.IronFarmRenderer;
/*   0 */ import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class IronFarmItemRenderer extends BlockItemRendererBase<IronFarmRenderer, IronFarmTileentity> {
/*   0 */   public IronFarmItemRenderer() {
/*  12 */     super(IronFarmRenderer::new, () -> new IronFarmTileentity(BlockPos.ZERO, ((IronFarmBlock)ModBlocks.IRON_FARM.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
