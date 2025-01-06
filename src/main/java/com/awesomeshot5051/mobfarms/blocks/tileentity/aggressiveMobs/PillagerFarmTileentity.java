package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;

import com.awesomeshot5051.mobfarms.*;
import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.awesomeshot5051.mobfarms.items.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.inventory.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.loot.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments.*;

public class PillagerFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    public static Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = initializeSwordEnchantments();
    private static final ResourceKey<LootTable> PILLAGER_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/pillager"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;
    public ItemStack swordType;

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
        int dropCount = 0;
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING)) {
            dropCount = serverWorld.random.nextIntBetweenInclusive(0, 5); // 0-5 emeralds
        }

        // Add emeralds to drops
        if (dropCount > 0) {
            drops.add(new ItemStack(Items.EMERALD, dropCount));
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

    // Add the setItem method
    public void setItem(int slot, ItemStack itemStack) {
        if (slot >= 0 && slot < inventory.size()) {
            inventory.set(slot, itemStack);
            setChanged(); // Notify that the inventory has changed
        }
    }
}
