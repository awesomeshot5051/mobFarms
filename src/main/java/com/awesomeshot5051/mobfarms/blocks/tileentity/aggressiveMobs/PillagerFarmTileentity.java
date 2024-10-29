package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.OutputItemHandler;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
import com.awesomeshot5051.mobfarms.items.MobFarmClass;
import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
import de.maxhenkel.corelib.inventory.ItemListInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PillagerFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    private static final ResourceKey<LootTable> PILLAGER_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/pillager"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public PillagerFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.PILLAGER_FARM.get(), ModBlocks.PILLAGER_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getPillagerSpawnTime() {
        return Main.SERVER_CONFIG.pillagerSpawnTime.get() - 20 * 4;
    }

    public static int getPillagerExplodeTime() {
        return getPillagerSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.PILLAGER_PRIMED);

        timer++;
        setChanged();

        if (timer == getPillagerSpawnTime()) {
//            // Play pillager spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.PILLAGER_PRIMED);
            sync();
//        } else if (timer > getPillagerSpawnTime() && timer < getPillagerExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.PILLAGER_HURT);
//            }
        } else if (timer >= getPillagerExplodeTime()) {
            // Play pillager death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.PILLAGER_DEATH);
            for (ItemStack drop : getDrops()) {
                for (int i = 0; i < itemHandler.getSlots(); i++) {
                    drop = itemHandler.insertItem(i, drop, false);
                    if (drop.isEmpty()) {
                        break;
                    }
                }
            }

            timer = 0L;
            sync();
        }
    }

    private List<ItemStack> getDrops() {
        if (!(level instanceof ServerLevel serverWorld)) {
            return Collections.emptyList();
        }

        List<ItemStack> drops = new ArrayList<>();

        // Add emeralds with a chance based on difficulty
        int emeraldCount = 0;
        if (serverWorld.getDifficulty() == Difficulty.EASY) {
            emeraldCount = serverWorld.random.nextInt(2); // 0-1 emeralds
        } else if (serverWorld.getDifficulty() == Difficulty.NORMAL) {
            emeraldCount = serverWorld.random.nextInt(3); // 0-2 emeralds
        } else if (serverWorld.getDifficulty() == Difficulty.HARD) {
            emeraldCount = serverWorld.random.nextInt(6); // 0-5 emeralds
        }

        // Add emeralds to drops
        if (emeraldCount > 0) {
            drops.add(new ItemStack(Items.EMERALD, emeraldCount));
        }

        // Add a crossbow with a chance to be enchanted
        if (serverWorld.random.nextFloat() < 0.12F) { // 12% chance
            ItemStack crossbow = new ItemStack(Items.CROSSBOW);

            // Create a new instance of MobFarmClass for enchanting
            MobFarmClass mobFarmClass = new MobFarmClass(EntityType.PILLAGER, serverWorld);
            RandomSource random = RandomSource.create();

            // Get a specific difficulty instance
            DifficultyInstance difficultyInstance = new DifficultyInstance(
                    serverWorld.getDifficulty(),
                    serverWorld.getDayTime(),
                    0L,
                    serverWorld.getMoonBrightness()
            );

            // Enchant the crossbow
            mobFarmClass.enchantSpawnedEquipment(serverWorld, EquipmentSlot.MAINHAND, random, 1.0F, difficultyInstance, this, 0);

            // After enchanting, add the crossbow to the drops
            drops.add(crossbow);
        }

        // Add other drops like the ominous banner or Bad Omen effect if necessary...

        return drops;
    }


    public Container getOutputInventory() {
        return new ItemListInventory(inventory, this::setChanged);
    }
    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        super.saveAdditional(compound, provider);

        ContainerHelper.saveAllItems(compound, inventory, false, provider);
        compound.putLong("Timer", timer);
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        ContainerHelper.loadAllItems(compound, inventory, provider);
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }

    // Add the setItem method
    public void setItem(int slot, ItemStack itemStack) {
        if (slot >= 0 && slot < inventory.size()) {
            inventory.set(slot, itemStack);
            setChanged(); // Notify that the inventory has changed
        }
    }
}
