package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.tileentity.InventoryViewerTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class ModItemStackHandler extends ItemStackHandler {
   protected final InventoryViewerTileentity inventoryViewer;
   
   public ModItemStackHandler(NonNullList<ItemStack> stacks, InventoryViewerTileentity inventoryViewer) {
     super(stacks);
/*  16 */     this.inventoryViewer = inventoryViewer;
   }
   
   public boolean isItemValid(int slot, @NotNull ItemStack stack) {
/*  21 */     EasyVillagerEntity v = this.inventoryViewer.getVillagerEntity();
/*  22 */     return (super.isItemValid(slot, stack) && v != null && v.wantsToPickUp(stack));
   }
}
