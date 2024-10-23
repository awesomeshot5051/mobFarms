package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.tileentity.InventoryViewerTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ModInventorySlot extends Slot {

    protected final InventoryViewerTileentity inventoryViewer;

    public ModInventorySlot(Container c, int index, int xPos, int yPos, InventoryViewerTileentity inventoryViewer) {
        super(c, index, xPos, yPos);
        this.inventoryViewer = inventoryViewer;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        EasyVillagerEntity v = inventoryViewer.getVillagerEntity();
        if (v == null) {
            return false;
        }
        //TODO Check if this causes a crash
        return super.mayPlace(stack) && v.wantsToPickUp(null, stack);
    }

}
