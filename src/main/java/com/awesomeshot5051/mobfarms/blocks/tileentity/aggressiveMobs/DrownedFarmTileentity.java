package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;

import com.awesomeshot5051.mobfarms.*;
import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.awesomeshot5051.mobfarms.enums.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.inventory.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.parameters.*;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments.*;

public class DrownedFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    public Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = initializeSwordEnchantments();
    private static final ResourceKey<LootTable> DROWNED_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/drowned"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;
    public ItemStack swordType;

    public DrownedFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.DROWNED_FARM.get(), ModBlocks.DROWNED_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
        swordType = new ItemStack(Items.WOODEN_SWORD);
    }

    public static double getDrownedSpawnTime(DrownedFarmTileentity farm) {
        SwordType sword = SwordType.fromItem(farm.getSwordType().getItem());
        return (double) Main.SERVER_CONFIG.drownedSpawnTime.get() /
                (sword.equals(SwordType.NETHERITE) ? 30 :
                        sword.equals(SwordType.DIAMOND) ? 25 :
                                sword.equals(SwordType.GOLDEN) ? 20 :
                                        sword.equals(SwordType.IRON) ? 15 :
                                                sword.equals(SwordType.STONE) ? 10
                                                        : 1);
    }

    public static double getDrownedExplodeTime(DrownedFarmTileentity farm) {
        SwordType sword = SwordType.fromItem(farm.getSwordType().getItem());
        if (farm.getSwordType().isEnchanted()) {
            farm.setEnchantmentStatus(farm);
        }
        int baseValue = 20;
        if (SwordEnchantments.getEnchantmentStatus(farm.swordEnchantments, Enchantments.SHARPNESS)) {
            baseValue = 10;
        }
        return getDrownedSpawnTime(farm) + (sword.equals(SwordType.NETHERITE) ? (baseValue * 3.2) :
                sword.equals(SwordType.DIAMOND) ? (baseValue * 5.6) :
                        sword.equals(SwordType.IRON) ? (baseValue * 4.8) :
                                sword.equals(SwordType.STONE) ? (baseValue * 6.4) :
                                        sword.equals(SwordType.WOODEN) ? (baseValue * 6.4) :
                                                6.4); // 30 seconds spawn time + 10 seconds kill time
    }

    @Override
    public ItemStack getSwordType() {
        return swordType;
    }

    @Override
    protected Map<ResourceKey<Enchantment>, Boolean> getEnchantments() {
        return swordEnchantments;
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

        if (timer == getDrownedSpawnTime(this)) {
//            // Play drowned spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.DROWNED_PRIMED);
            sync();
//        } else if (timer > getDrownedSpawnTime() && timer < getDrownedExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.DROWNED_HURT);
//            }
        } else if (timer >= getDrownedExplodeTime(this)) {
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
        LootParams.Builder builder = new LootParams.Builder(serverWorld)
                .withParameter(LootContextParams.THIS_ENTITY, new Drowned(EntityType.DROWNED, level))
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().explosion(null));
        LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(DROWNED_LOOT_TABLE);
        // Default drops

        int dropCount = serverWorld.random.nextIntBetweenInclusive(0, 1);
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING)) {
            dropCount = serverWorld.random.nextIntBetweenInclusive(4, 8);
        }

        // Add default drops
        List<ItemStack> drops = new ArrayList<>(lootTable.getRandomItems(lootContext));

        // Custom drop logic for Nautilus Shell and Trident
        if (serverWorld.random.nextFloat() < 0.5F) { // 50% chance for Nautilus Shell
            drops.add(new ItemStack(Items.NAUTILUS_SHELL, dropCount));
        }

        if (serverWorld.random.nextFloat() < 0.1F) { // 10% chance for Trident
            drops.add(new ItemStack(Items.TRIDENT, 1));
        }

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
