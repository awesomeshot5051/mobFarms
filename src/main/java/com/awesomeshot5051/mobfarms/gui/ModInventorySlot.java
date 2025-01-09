package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import com.awesomeshot5051.mobfarms.entity.*;
import net.minecraft.world.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;

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
