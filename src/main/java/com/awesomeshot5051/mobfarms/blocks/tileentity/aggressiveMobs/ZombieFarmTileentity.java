package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;

import com.awesomeshot5051.mobfarms.*;
import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import com.awesomeshot5051.mobfarms.datacomponents.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.inventory.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.loot.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments.*;

public class ZombieFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    public static Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = initializeSwordEnchantments();
    private static final ResourceKey<LootTable> ZOMBIE_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/zombie"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;
    public ItemStack swordType;

    public ZombieFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.ZOMBIE_FARM.get(), ModBlocks.ZOMBIE_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getZombieSpawnTime() {
        return Main.SERVER_CONFIG.zombieSpawnTime.get() - 20 * 4;
    }

    public static int getZombieExplodeTime() {
        return getZombieSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_PRIMED);

        timer++;
        setChanged();

        if (timer == getZombieSpawnTime()) {
//            // Play zombie spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_PRIMED);
            sync();
//        } else if (timer > getZombieSpawnTime() && timer < getZombieExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_HURT);
//            }
        } else if (timer >= getZombieExplodeTime()) {
            // Play zombie death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_DEATH);
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
        int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 3);
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING)) {
            dropCount = serverWorld.random.nextIntBetweenInclusive(4, 8);
        }
        List<Item> rareDrops = List.of(Items.IRON_INGOT, Items.CARROT, SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.FIRE_ASPECT) ? Items.BAKED_POTATO : Items.POTATO);
        List<Item> ironArmor = List.of(Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS);
        List<Item> uberRareDrops = List.of(Items.IRON_SHOVEL, Items.IRON_SWORD, ironArmor.get(serverWorld.random.nextIntBetweenInclusive(0, 4)));
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING) ? serverWorld.random.nextFloat() >= (float) 11 / 600 : serverWorld.random.nextFloat() >= (float) 5 / 600) {
            drops.add(new ItemStack(rareDrops.get(serverWorld.random.nextIntBetweenInclusive(0, 3))));
        }
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING) ? serverWorld.random.nextFloat() >= .085 : serverWorld.random.nextFloat() >= 0.115) {
            drops.add(new ItemStack(uberRareDrops.get(serverWorld.random.nextIntBetweenInclusive(0, 3))));
        }
        drops.add(new ItemStack(Items.ROTTEN_FLESH, dropCount));

        return drops;
    }

    public Container getOutputInventory() {
        return new ItemListInventory(inventory, this::setChanged);
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        super.saveAdditional(compound, provider);
        if (swordType != null) {
            CompoundTag swordTypeTag = new CompoundTag();
            swordTypeTag.putString("id", BuiltInRegistries.ITEM.getKey(swordType.getItem()).toString()); // Save the item ID
            swordTypeTag.putInt("count", swordType.getCount()); // Save the count
            compound.put("SwordType", swordTypeTag); // Add the tag to the main compound
        }
        ContainerHelper.saveAllItems(compound, inventory, false, provider);
        compound.putLong("Timer", timer);
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        ContainerHelper.loadAllItems(compound, inventory, provider);
        if (compound.contains("SwordType")) {
            SyncableTileentity.loadSwordType(compound, provider).ifPresent(stack -> this.swordType = stack);

        }
        if (swordType == null) {
// If no pickType is saved, set a default one (e.g., Stone Pickaxe)
            swordType = new ItemStack(Items.WOODEN_SWORD);
        }
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }

}
