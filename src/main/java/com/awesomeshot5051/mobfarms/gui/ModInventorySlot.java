package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.tileentity.InventoryViewerTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ModInventorySlot extends Slot {
   protected final InventoryViewerTileentity inventoryViewer;
   
   public ModInventorySlot(Container c, int index, int xPos, int yPos, InventoryViewerTileentity inventoryViewer) {
/*  14 */     super(c, index, xPos, yPos);
     this.inventoryViewer = inventoryViewer;
   }
   
   public boolean mayPlace(ItemStack stack) {
/*  20 */     EasyVillagerEntity v = this.inventoryViewer.getVillagerEntity();
/*  21 */     if (v == null)
/*  22 */       return false; 
/*  24 */     return (super.mayPlace(stack) && v.wantsToPickUp(stack));
   }
}
