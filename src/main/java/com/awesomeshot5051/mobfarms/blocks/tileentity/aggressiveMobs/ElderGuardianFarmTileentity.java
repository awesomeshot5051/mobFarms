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

public class ElderGuardianFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    public static Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = initializeSwordEnchantments();
    private static final ResourceKey<LootTable> ELDERGUARDIAN_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/elder_guardian"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;
    public ItemStack swordType;

    public ElderGuardianFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.ELDER_GUARDIAN_FARM.get(), ModBlocks.ELDER_GUARDIAN_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getElderGuardianSpawnTime() {
        return Main.SERVER_CONFIG.elderGuardianSpawnTime.get() - 20 * 4;
    }

    public static int getElderGuardianExplodeTime() {
        return getElderGuardianSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_PRIMED);

        timer++;
        setChanged();

        if (timer == getElderGuardianSpawnTime()) {
//            // Play elderGuardian spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_PRIMED);
            sync();
//        } else if (timer > getElderGuardianSpawnTime() && timer < getElderGuardianExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_HURT);
//            }
        } else if (timer >= getElderGuardianExplodeTime()) {
            // Play elderGuardian death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_DEATH);
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
                .withParameter(LootContextParams.THIS_ENTITY, new ElderGuardian(EntityType.ELDER_GUARDIAN, level))
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().explosion(null));

        List<ItemStack> drops = new ArrayList<>();
        int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 3);
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING)) {
            dropCount = serverWorld.random.nextIntBetweenInclusive(4, 8);
        }
        drops.add(new ItemStack(Items.PRISMARINE_SHARD, serverWorld.random.nextIntBetweenInclusive(0, 2)));
        drops.add(new ItemStack(Items.WET_SPONGE));
        if (serverWorld.random.nextFloat() >= .20) {
            drops.add(new ItemStack(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE));
        }
        if (serverWorld.random.nextFloat() >= .5) {
            drops.add(new ItemStack(SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.FIRE_ASPECT) ? Items.COOKED_COD : Items.COD, dropCount));
        }
        if (serverWorld.random.nextFloat() >= (float) 1 / 3) {
            drops.add(new ItemStack(Items.PRISMARINE_CRYSTALS, dropCount));
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
