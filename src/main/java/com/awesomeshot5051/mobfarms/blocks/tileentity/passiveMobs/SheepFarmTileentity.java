package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;
//TODO make it so that whether the meat is cooked is modifiable in-game.

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.OutputItemHandler;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.mobfarms.blocks.tileentity.SyncableTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
import com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments;
import com.awesomeshot5051.mobfarms.enums.SwordType;
import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
import de.maxhenkel.corelib.inventory.ItemListInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock.COLOR;
import static com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments.initializeSwordEnchantments;

public class SheepFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    private static final ResourceKey<LootTable> SHEEP_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/sheep"));

    protected NonNullList<ItemStack> inventory;

    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;
    public ItemStack swordType;

    public SheepFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.SHEEP_FARM.get(), ModBlocks.SHEEP_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
        swordType = new ItemStack(Items.WOODEN_SWORD);
    }

    public static double getSheepSpawnTime(SheepFarmTileentity farm) {
        SwordType sword = SwordType.fromItem(farm.getSwordType().getItem());
        return (double) Main.SERVER_CONFIG.sheepSpawnTime.get() /
                (sword.equals(SwordType.NETHERITE) ? 30 :
                        sword.equals(SwordType.DIAMOND) ? 25 :
                                sword.equals(SwordType.GOLDEN) ? 20 :
                                        sword.equals(SwordType.IRON) ? 15 :
                                                sword.equals(SwordType.STONE) ? 10
                                                        : 1);
    }

    public static double getSheepKillTime(SheepFarmTileentity farm) {
        // Iterate through the enchantments
        SwordType sword = SwordType.fromItem(farm.getSwordType().getItem());
        if (farm.getSwordType().isEnchanted()) {
            farm.setEnchantmentStatus(farm);
        }
        int baseValue = 20;
        if (SwordEnchantments.getEnchantmentStatus(farm.swordEnchantments, Enchantments.SHARPNESS)) {
            baseValue = 10;
        }
        return getSheepSpawnTime(farm) + (sword.equals(SwordType.NETHERITE) ? (baseValue * 3.2) :
                sword.equals(SwordType.DIAMOND) ? (baseValue * 5.6) :
                        sword.equals(SwordType.IRON) ? (baseValue * 4.8) :
                                sword.equals(SwordType.STONE) ? (baseValue * 6.4) :
                                        sword.equals(SwordType.WOODEN) ? (baseValue * 6.4) :
                                                6.4);
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
        // VillagerBlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.VILLAGER_AMBIENT);
        // VillagerBlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_AMBIENT);

//            if (advanceAge()) {
//                sync();
//            }

        timer++;
        setChanged();

        if (timer == getSheepSpawnTime(this)) {
            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ZOMBIE_AMBIENT);
            sync();
        } else if (timer >= getSheepKillTime(this)) {
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

        int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 3);
        if (SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.LOOTING)) {
            dropCount = serverWorld.random.nextIntBetweenInclusive(4, 8);
        }

        // List to hold the drops
        List<ItemStack> drops = new ArrayList<>();

        // Get the wool color from the block state
        DyeColor woolColor = getWoolColor(); // Use the method to get the wool color
        ItemStack WoolColor = setWoolColor(woolColor, dropCount);
        drops.add(WoolColor);

        // Manually add cooked mutton drop (since the sheep is killed by lava, we drop cooked mutton)
        drops.add(new ItemStack(SwordEnchantments.getEnchantmentStatus(swordEnchantments, Enchantments.FIRE_ASPECT) ? Items.COOKED_MUTTON : Items.MUTTON, dropCount));
        // Adjust the amount if needed

        return drops;
    }

    public Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = initializeSwordEnchantments();

    private ItemStack setWoolColor(DyeColor woolColor, int dropCount) {
        return switch (woolColor) {
            case WHITE -> new ItemStack(Items.WHITE_WOOL, dropCount);
            case ORANGE -> new ItemStack(Items.ORANGE_WOOL, dropCount);
            case MAGENTA -> new ItemStack(Items.MAGENTA_WOOL, dropCount);
            case LIGHT_BLUE -> new ItemStack(Items.LIGHT_BLUE_WOOL, dropCount);
            case YELLOW -> new ItemStack(Items.YELLOW_WOOL, dropCount);
            case LIME -> new ItemStack(Items.LIME_WOOL, dropCount);
            case PINK -> new ItemStack(Items.PINK_WOOL, dropCount);
            case GRAY -> new ItemStack(Items.GRAY_WOOL, dropCount);
            case LIGHT_GRAY -> new ItemStack(Items.LIGHT_GRAY_WOOL, dropCount);
            case CYAN -> new ItemStack(Items.CYAN_WOOL, dropCount);
            case PURPLE -> new ItemStack(Items.PURPLE_WOOL, dropCount);
            case BLUE -> new ItemStack(Items.BLUE_WOOL, dropCount);
            case BROWN -> new ItemStack(Items.BROWN_WOOL, dropCount);
            case GREEN -> new ItemStack(Items.GREEN_WOOL, dropCount);
            case RED -> new ItemStack(Items.RED_WOOL, dropCount);
            case BLACK -> new ItemStack(Items.BLACK_WOOL, dropCount);
            default -> new ItemStack(Items.WHITE_WOOL, dropCount); // Return an empty ItemStack for an unknown color
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
