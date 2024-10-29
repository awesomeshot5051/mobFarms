package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.OutputItemHandler;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
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
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrownedFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    private static final ResourceKey<LootTable> DROWNED_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/drowned"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public DrownedFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.DROWNED_FARM.get(), ModBlocks.DROWNED_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getDrownedSpawnTime() {
        return Main.SERVER_CONFIG.drownedSpawnTime.get() - 20 * 4;
    }

    public static int getDrownedExplodeTime() {
        return getDrownedSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.DROWNED_PRIMED);

        timer++;
        setChanged();

        if (timer == getDrownedSpawnTime()) {
//            // Play drowned spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.DROWNED_PRIMED);
            sync();
//        } else if (timer > getDrownedSpawnTime() && timer < getDrownedExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.DROWNED_HURT);
//            }
        } else if (timer >= getDrownedExplodeTime()) {
            // Play drowned death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.DROWNED_DEATH);
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

        // Default drops
        LootParams.Builder builder = new LootParams.Builder(serverWorld)
                .withParameter(LootContextParams.THIS_ENTITY, new Drowned(EntityType.DROWNED, level))
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().explosion(null));

        LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(DROWNED_LOOT_TABLE);

        // Add default drops
        drops.addAll(lootTable.getRandomItems(lootContext));

        // Custom drop logic for Nautilus Shell and Trident
        if (serverWorld.random.nextFloat() < 0.5F) { // 50% chance for Nautilus Shell
            drops.add(new ItemStack(Items.NAUTILUS_SHELL));
        }

        if (serverWorld.random.nextFloat() < 0.1F) { // 10% chance for Trident
            drops.add(new ItemStack(Items.TRIDENT));
        }

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

}
