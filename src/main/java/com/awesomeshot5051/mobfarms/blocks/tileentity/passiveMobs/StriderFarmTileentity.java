package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;
//TODO make it so that whether the meat is cooked is modifiable in-game.

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
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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

public class StriderFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    private static final ResourceKey<LootTable> STRIDER_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/strider"));

    protected NonNullList<ItemStack> inventory;

    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public StriderFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.STRIDER_FARM.get(), ModBlocks.STRIDER_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getStriderSpawnTime() {
        return Main.SERVER_CONFIG.striderSpawnTime.get() - 20 * 10;
    }

    public static int getStriderKillTime() {
        return getStriderSpawnTime() + 20 * 10;
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        if (!level.dimension().equals(Level.NETHER)) {
            return; // Do nothing if not in the Nether
        }
        // VillagerBlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.VILLAGER_AMBIENT);
        // VillagerBlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_AMBIENT);

//            if (advanceAge()) {
//                sync();
//            }

        timer++;
        setChanged();

        if (timer == getStriderSpawnTime()) {
            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_AMBIENT);
            sync();
        } else if (timer > getStriderSpawnTime() && timer < getStriderKillTime()) {
            if (timer % 20L == 0L) {
                // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.STRIDER_HURT);
            }
        } else if (timer >= getStriderKillTime()) {
            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.STRIDER_DEATH);
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
                .withParameter(LootContextParams.THIS_ENTITY, new Strider(EntityType.STRIDER, level))
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());

        LootParams lootContext = builder.create(LootContextParamSets.ENTITY);

        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(STRIDER_LOOT_TABLE);

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
