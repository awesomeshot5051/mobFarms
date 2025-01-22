package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.tileentity.EmptyFarmTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

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
