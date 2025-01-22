package com.awesomeshot5051.mobfarms.blocks.tileentity;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import com.awesomeshot5051.mobfarms.gui.ModItemStackHandler;
import de.maxhenkel.corelib.blockentity.IServerTickableBlockEntity;
import de.maxhenkel.corelib.inventory.ItemListInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;

public class EmptyFarmTileentity extends VillagerTileentity implements IServerTickableBlockEntity {

    public EmptyFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.EMPTY_FARM.get(), ModBlocks.EMPTY_FARM.get().defaultBlockState(), pos, state);
    }

    @Override
    public void tickServer() {
        if (hasVillager()) {
            // VillagerBlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.VILLAGER_AMBIENT);
        }
    }

    public Container getVillagerInventory() {
        return new ItemListInventory(getVillagerEntity().getInventory().getItems(), this::setChanged);
    }

    public Container getVillagerArmorInventory() {
        return new ItemListInventory((NonNullList<ItemStack>) getVillagerEntity().getArmorSlots(), this::setChanged);
    }

    public IItemHandler getItemHandler() {
        EasyVillagerEntity ve = getVillagerEntity();
        if (ve == null) {
            return null;
        }
        return new ModItemStackHandler(ve.getInventory().getItems(), this);
    }
}
