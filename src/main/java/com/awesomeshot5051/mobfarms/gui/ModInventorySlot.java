package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.tileentity.EmptyFarmTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ModInventorySlot extends Slot {

    protected final EmptyFarmTileentity EmptyFarm;

    public ModInventorySlot(Container c, int index, int xPos, int yPos, EmptyFarmTileentity EmptyFarm) {
        super(c, index, xPos, yPos);
        this.EmptyFarm = EmptyFarm;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        EasyVillagerEntity v = EmptyFarm.getVillagerEntity();
        if (v == null) {
            return false;
        }
        return super.mayPlace(stack) && v.wantsToPickUp(stack);
    }

}
