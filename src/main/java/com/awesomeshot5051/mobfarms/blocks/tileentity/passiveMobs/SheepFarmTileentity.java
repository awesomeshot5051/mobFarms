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
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
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
import static com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock.COLOR;

public class SheepFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    private static final ResourceKey<LootTable> SHEEP_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/sheep"));

    protected NonNullList<ItemStack> inventory;

    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public SheepFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.SHEEP_FARM.get(), ModBlocks.SHEEP_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getSheepSpawnTime() {
        return Main.SERVER_CONFIG.sheepSpawnTime.get() - 20 * 10;
    }

    public static int getSheepKillTime() {
        return getSheepSpawnTime() + 20 * 10;
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

        if (timer == getSheepSpawnTime()) {
            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_AMBIENT);
            sync();
        } else if (timer > getSheepSpawnTime() && timer < getSheepKillTime()) {
            if (timer % 20L == 0L) {
                // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.SHEEP_HURT);
            }
        } else if (timer >= getSheepKillTime()) {
            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.SHEEP_DEATH);
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

        // Create a loot parameter builder for generating loot context
        LootParams.Builder builder = new LootParams.Builder(serverWorld)
                .withParameter(LootContextParams.THIS_ENTITY, new Sheep(EntityType.SHEEP, level))
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());

        LootParams lootContext = builder.create(LootContextParamSets.ENTITY);

        // List to hold the drops
        List<ItemStack> drops = new ArrayList<>();

        // Get the wool color from the block state
        DyeColor woolColor = getWoolColor(); // Use the method to get the wool color
        ItemStack WoolColor = setWoolColor(woolColor);
        drops.add(WoolColor);

        // Manually add cooked mutton drop (since the sheep is killed by lava, we drop cooked mutton)
        drops.add(new ItemStack(dropsCookedMeat.get() ? Items.COOKED_MUTTON : Items.MUTTON, 3)); // Adjust the amount if needed

        return drops;
    }

    private ItemStack setWoolColor(DyeColor woolColor) {
        return switch (woolColor) {
            case WHITE -> new ItemStack(Items.WHITE_WOOL, 3);
            case ORANGE -> new ItemStack(Items.ORANGE_WOOL, 3);
            case MAGENTA -> new ItemStack(Items.MAGENTA_WOOL, 3);
            case LIGHT_BLUE -> new ItemStack(Items.LIGHT_BLUE_WOOL, 3);
            case YELLOW -> new ItemStack(Items.YELLOW_WOOL, 3);
            case LIME -> new ItemStack(Items.LIME_WOOL, 3);
            case PINK -> new ItemStack(Items.PINK_WOOL, 3);
            case GRAY -> new ItemStack(Items.GRAY_WOOL, 3);
            case LIGHT_GRAY -> new ItemStack(Items.LIGHT_GRAY_WOOL, 3);
            case CYAN -> new ItemStack(Items.CYAN_WOOL, 3);
            case PURPLE -> new ItemStack(Items.PURPLE_WOOL, 3);
            case BLUE -> new ItemStack(Items.BLUE_WOOL, 3);
            case BROWN -> new ItemStack(Items.BROWN_WOOL, 3);
            case GREEN -> new ItemStack(Items.GREEN_WOOL, 3);
            case RED -> new ItemStack(Items.RED_WOOL, 3);
            case BLACK -> new ItemStack(Items.BLACK_WOOL, 3);
            default -> new ItemStack(Items.WHITE_WOOL, 3); // Return an empty ItemStack for an unknown color
        };
    }


    private DyeColor getWoolColor() {
        BlockState state = this.getBlockState(); // Get the current block state
        if (state.hasProperty(COLOR)) {
            return state.getValue(COLOR); // Return the color set on the block
        }
        return DyeColor.WHITE; // Default to white if no color is set
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

    private Item getWoolFromColor(DyeColor color) {
        switch (color) {
            case RED:
                return Items.RED_WOOL;
            case BLUE:
                return Items.BLUE_WOOL;
            case GREEN:
                return Items.GREEN_WOOL;
            // Add more cases for all DyeColor values
            default:
                return Items.WHITE_WOOL;
        }
    }

}
