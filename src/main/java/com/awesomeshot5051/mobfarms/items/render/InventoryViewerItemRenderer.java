package com.awesomeshot5051.mobfarms.items.render;

import com.awesomeshot5051.mobfarms.blocks.InventoryViewerBlock;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.InventoryViewerTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.InventoryViewerRenderer;
import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class InventoryViewerItemRenderer extends BlockItemRendererBase<InventoryViewerRenderer, InventoryViewerTileentity> {
   public InventoryViewerItemRenderer() {
/*  11 */     super(InventoryViewerRenderer::new, () -> new InventoryViewerTileentity(BlockPos.ZERO, ((InventoryViewerBlock)ModBlocks.INVENTORY_VIEWER.get()).defaultBlockState()));
   }
}
