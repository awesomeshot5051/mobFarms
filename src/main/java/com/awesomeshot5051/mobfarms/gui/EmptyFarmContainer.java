package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.EmptyFarmTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class EmptyFarmContainer extends ModContainerBase {

    public static final ResourceLocation EMPTY_ARMOR_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    public static final ResourceLocation[] TEXTURE_EMPTY_SLOTS = new ResourceLocation[]{
            EMPTY_ARMOR_SLOT_BOOTS, EMPTY_ARMOR_SLOT_LEGGINGS, EMPTY_ARMOR_SLOT_CHESTPLATE, EMPTY_ARMOR_SLOT_HELMET
    };
    private static final EquipmentSlot[] SLOT_IDS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    protected EmptyFarmTileentity EmptyFarm;
    protected EasyVillagerEntity villager;

    public EmptyFarmContainer(int id, Container playerInventory, EmptyFarmTileentity EmptyFarm, ContainerLevelAccess access) {
        super(Containers.EMPTY_FARM_CONTAINER.get(), id, playerInventory, null, access);
        this.EmptyFarm = EmptyFarm;
        villager = EmptyFarm.getVillagerEntity();

        Container villagerInventory = EmptyFarm.getVillagerInventory();
        Container armorInventory = EmptyFarm.getVillagerArmorInventory();

        for (int i = 0; i < villagerInventory.getContainerSize() && i < 4; i++) {
            addSlot(new ModInventorySlot(villagerInventory, i, 52 + i * 18, 20, EmptyFarm));
        }
        for (int i = 4; i < villagerInventory.getContainerSize() && i < 8; i++) {
            addSlot(new ModInventorySlot(villagerInventory, i, 52 + (i - 4) * 18, 38, EmptyFarm));
        }

        for (int i = 0; i < 4; i++) {
            EquipmentSlot equipmentslot = SLOT_IDS[i];
            addSlot(new Slot(armorInventory, 3 - i, 52 + i * 18, 69) { //51

                @Override
                public int getMaxStackSize() {
                    return 1;
                }

                @Override
                public boolean mayPlace(ItemStack stack) {
                    return villager.getEquipmentSlotForItem(stack) == equipmentslot;
                }

                @Override
                public boolean mayPickup(Player player) {
                    ItemStack itemstack = getItem();
                    return (itemstack.isEmpty() || player.isCreative() || !EnchantmentHelper.has(itemstack, EnchantmentEffectComponents.PREVENT_ARMOR_CHANGE)) && super.mayPickup(player);
                }

                @Override
                public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                    return Pair.of(InventoryMenu.BLOCK_ATLAS, TEXTURE_EMPTY_SLOTS[equipmentslot.getIndex()]);
                }
            });
        }

        addPlayerInventorySlots();
    }

    public EmptyFarmContainer(int id, Inventory playerInventory, BlockPos pos) {
        this(id, playerInventory, get(pos));
    }

    public EmptyFarmContainer(int id, Inventory playerInventory, EmptyFarmTileentity te) {
        this(id, playerInventory, te, ContainerLevelAccess.create(te.getLevel(), te.getBlockPos()));
    }

    @OnlyIn(Dist.CLIENT)
    private static EmptyFarmTileentity get(BlockPos pos) {
        ClientLevel level = Minecraft.getInstance().level;
        if (level == null) {
            throw new IllegalStateException("No client level present");
        }
        if (!(level.getBlockEntity(pos) instanceof EmptyFarmTileentity iv)) {
            throw new IllegalStateException("Could not find block entity");
        }
        return iv;
    }

    @Override
    public Block getBlock() {
        return ModBlocks.EMPTY_FARM.get();
    }

    @Override
    public int getInvOffset() {
        return -2 + 18;
    }

    @Override
    public int getInventorySize() {
        return 12;
    }

    @Override
    public boolean stillValid(Player player) {
        return super.stillValid(player) && villager == EmptyFarm.getVillagerEntity();
    }
}
