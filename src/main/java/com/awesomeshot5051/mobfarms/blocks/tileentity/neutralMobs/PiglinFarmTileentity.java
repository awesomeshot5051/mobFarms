package com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs;

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
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.loot.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments.*;

public class PiglinFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    public static Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = initializeSwordEnchantments();
    // Update the loot table for piglins instead of iron golems
    private static final ResourceKey<LootTable> PIGLIN_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/piglin"));
    public boolean isSword = true;
    protected NonNullList<ItemStack> inventory;
    protected long timer;
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;
    public ItemStack swordType;

    public PiglinFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.PIGLIN_FARM.get(), ModBlocks.PIGLIN_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getPiglinSpawnTime() {
        return Main.SERVER_CONFIG.piglinSpawnTime.get() - 20 * 10;
    }

    public static int getPiglinKillTime() {
        return getPiglinSpawnTime() + 20 * 10;
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        if (!level.dimension().equals(Level.NETHER)) {
            return; // Do nothing if not in the Nether
        }
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_PRIMED);
        isSword = !isSword;
        timer++;
        setChanged();

        if (timer == getPiglinSpawnTime()) {
//            // Play creeper spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_PRIMED);
            sync();
//        } else if (timer > getCreeperSpawnTime() && timer < getCreeperExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_HURT);
//            }
        } else if (timer >= getPiglinKillTime()) {
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

        int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 3);
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING)) {
            dropCount = serverWorld.random.nextIntBetweenInclusive(4, 8);
        }
        if (serverWorld.random.nextDouble() < .085)
            drops.add(new ItemStack(isSword ? Items.GOLDEN_SWORD : Items.CROSSBOW, dropCount));
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
