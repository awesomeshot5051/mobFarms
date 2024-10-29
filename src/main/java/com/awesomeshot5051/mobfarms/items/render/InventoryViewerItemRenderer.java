/*   0 */ package com.awesomeshot5051.mobfarms.items.render;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.InventoryViewerBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.InventoryViewerTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.render.InventoryViewerRenderer;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ 
/*   0 */ public class InventoryViewerItemRenderer extends BlockItemRendererBase<InventoryViewerRenderer, InventoryViewerTileentity> {
/*   0 */   public InventoryViewerItemRenderer() {
/*  11 */     super(InventoryViewerRenderer::new, () -> new InventoryViewerTileentity(BlockPos.ZERO, ((InventoryViewerBlock)ModBlocks.INVENTORY_VIEWER.get()).defaultBlockState()));
/*   0 */   }
/*   0 */ }
