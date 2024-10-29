package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;

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
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.Collections;
import java.util.List;

public class TropicalFishFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    private static final ResourceKey<LootTable> TROPICAL_FISH_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/tropical_fish"));

    protected NonNullList<ItemStack> inventory;

    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public TropicalFishFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.TROPICAL_FISH_FARM.get(), ModBlocks.TROPICAL_FISH_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getTropicalFishSpawnTime() {
        return Main.SERVER_CONFIG.tropicalFishSpawnTime.get() - 20 * 10;
    }

    public static int getTropicalFishKillTime() {
        return getTropicalFishSpawnTime() + 20 * 10;
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // VillagerBlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.VILLAGER_AMBIENT);
        // VillagerBlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_AMBIENT);

//            if (advanceAge()) {
//                sync();
//            }

        timer++;
        setChanged();

        if (timer == getTropicalFishSpawnTime()) {
            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_AMBIENT);
            sync();
        } else if (timer > getTropicalFishSpawnTime() && timer < getTropicalFishKillTime()) {
            if (timer % 20L == 0L) {
                // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.TROPICAL_FISH_HURT);
            }
        } else if (timer >= getTropicalFishKillTime()) {
            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.TROPICAL_FISH_DEATH);
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

        LootParams.Builder builder = new LootParams.Builder(serverWorld)
                .withParameter(LootContextParams.THIS_ENTITY, new TropicalFish(EntityType.TROPICAL_FISH, level))
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());

        LootParams lootContext = builder.create(LootContextParamSets.ENTITY);

        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(TROPICAL_FISH_LOOT_TABLE);

        return lootTable.getRandomItems(lootContext);
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