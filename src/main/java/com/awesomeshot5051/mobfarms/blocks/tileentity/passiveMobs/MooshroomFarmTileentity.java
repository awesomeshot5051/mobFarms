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
import net.minecraft.world.entity.animal.MushroomCow;
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

import static com.awesomeshot5051.mobfarms.blocks.passiveMobs.DoesDropCooked.dropsCookedMeat;

public class MooshroomFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    // Update the loot table for mooshrooms instead of iron golems
    private static final ResourceKey<LootTable> MOOSHROOM_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/mooshroom"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public MooshroomFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.MOOSHROOM_FARM.get(), ModBlocks.MOOSHROOM_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getMooshroomSpawnTime() {
        return Main.SERVER_CONFIG.mooshroomSpawnTime.get() - 20 * 10;
    }

    public static int getMooshroomKillTime() {
        return getMooshroomSpawnTime() + 20 * 10;
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_PRIMED);

        timer++;
        setChanged();

        if (timer == getMooshroomSpawnTime()) {
//            // Play creeper spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_PRIMED);
            sync();
//        } else if (timer > getCreeperSpawnTime() && timer < getCreeperExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_HURT);
//            }
        } else if (timer >= getMooshroomKillTime()) {
            // Play creeper death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_DEATH);
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

        // Add emeralds with a 50% chance
        drops.add(new ItemStack(Items.COOKED_BEEF)); // Drop 0 or 1 emerald
        drops.add(new ItemStack(dropsCookedMeat.get() ? Items.COOKED_BEEF : Items.BEEF, 3));
        // Add an iron axe with a chance to enchant it
        ItemStack leather = new ItemStack(Items.LEATHER);
        drops.add(leather);


        LootParams.Builder builder = new LootParams.Builder(serverWorld)
                .withParameter(LootContextParams.THIS_ENTITY, new MushroomCow(EntityType.MOOSHROOM, level)) // Change to Mooshroom
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());

        LootParams lootContext = builder.create(LootContextParamSets.ENTITY);

        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(MOOSHROOM_LOOT_TABLE);
        drops.add(new ItemStack(Items.MUSHROOM_STEW));
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
