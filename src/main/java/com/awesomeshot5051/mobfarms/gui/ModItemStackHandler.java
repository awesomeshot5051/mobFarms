package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import com.awesomeshot5051.mobfarms.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.items.*;
import org.jetbrains.annotations.*;

public class ModItemStackHandler extends ItemStackHandler {

    protected final EmptyFarmTileentity EmptyFarm;

    public ModItemStackHandler(NonNullList<ItemStack> stacks, EmptyFarmTileentity EmptyFarm) {
        super(stacks);
        this.EmptyFarm = EmptyFarm;
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        EasyVillagerEntity v = EmptyFarm.getVillagerEntity();
        return super.isItemValid(slot, stack) && v != null && v.wantsToPickUp(stack);
    }

}
