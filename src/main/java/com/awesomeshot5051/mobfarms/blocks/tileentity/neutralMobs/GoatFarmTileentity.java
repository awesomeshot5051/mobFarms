package com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs;

import com.awesomeshot5051.mobfarms.*;
import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.inventory.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.loot.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments.*;

public class GoatFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    // Update the loot table for goats instead of iron golems
    private static final ResourceKey<LootTable> GOAT_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/goat"));
    public static Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = initializeSwordEnchantments();
    protected NonNullList<ItemStack> inventory;
    protected long timer;
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;
    public ItemStack swordType;

    public GoatFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.GOAT_FARM.get(), ModBlocks.GOAT_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getGoatSpawnTime() {
        return Main.SERVER_CONFIG.goatSpawnTime.get() - 20 * 10;
    }

    public static int getGoatKillTime() {
        return getGoatSpawnTime() + 20 * 10;
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

        if (timer == getGoatSpawnTime()) {
//            // Play creeper spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_PRIMED);
            sync();
//        } else if (timer > getCreeperSpawnTime() && timer < getCreeperExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.CREEPER_HURT);
//            }
        } else if (timer >= getGoatKillTime()) {
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

    //    private List<ItemStack> getDrops() {
//        if (!(level instanceof ServerLevel)) {
//            return Collections.emptyList();
//        }
//        ServerLevel serverWorld = (ServerLevel) level;
//
//        LootParams.Builder builder = new LootParams.Builder(serverWorld)
//                .withParameter(LootContextParams.THIS_ENTITY, new Goat(EntityType.GOAT, level)) // Change to Goat
//                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
//                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());
//
//

    //
//        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(GOAT_LOOT_TABLE);
//
//        return lootTable.getRandomItems(lootContext);
//    }
    private List<ItemStack> getDrops() {
        if (!(level instanceof ServerLevel serverWorld)) {
            return Collections.emptyList();
        }

        // Create an ItemStack for the goat horn
        TagKey<Instrument> tagkey = this.isScreamingGoat() ? InstrumentTags.SCREAMING_GOAT_HORNS : InstrumentTags.REGULAR_GOAT_HORNS;
        HolderSet<Instrument> holderset = BuiltInRegistries.INSTRUMENT.getOrCreateTag(tagkey);
        // Return a list containing the goat horn
        RandomSource randomsource = serverWorld.getRandom();
        return Collections.singletonList(InstrumentItem.create(Items.GOAT_HORN, holderset.getRandomElement(randomsource).get()));
    }

    public Container getOutputInventory() {
        return new ItemListInventory(inventory, this::setChanged);
    }

    private boolean SCREAMING = false;

    public boolean isScreamingGoat() {
        SCREAMING = !SCREAMING;
        return SCREAMING;
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
