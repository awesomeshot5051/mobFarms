package com.awesomeshot5051.mobfarms.blocks.tileentity;

//import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;

import com.awesomeshot5051.mobfarms.datacomponents.SwordEnchantments;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Map;

public class VillagerTileentity extends FakeWorldTileentity {

    protected ItemStack villager;
    protected EasyVillagerEntity villagerEntity;

    public VillagerTileentity(BlockEntityType<?> type, BlockState defaultState, BlockPos pos, BlockState state) {
        super(type, defaultState, pos, state);
        villager = ItemStack.EMPTY;
    }


    public boolean hasVillager() {
        return !villager.isEmpty();
    }

    public <T extends VillagerTileentity> void setEnchantmentStatus(T farm) {
        Map<ResourceKey<Enchantment>, Boolean> swordEnchantments = farm.getEnchantments();
        ItemEnchantments enchantments = farm.getSwordType().getTagEnchantments();
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
            // Check and toggle enchantments based on their presence in the map
            if (entry.getKey().is(Enchantments.SHARPNESS.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.SHARPNESS, true);
            } else if (entry.getKey().is(Enchantments.FIRE_ASPECT.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.FIRE_ASPECT, true);
            } else if (entry.getKey().is(Enchantments.LOOTING.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.LOOTING, true);
            } else if (entry.getKey().is(Enchantments.KNOCKBACK.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.KNOCKBACK, true);
            } else if (entry.getKey().is(Enchantments.SMITE.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.SMITE, true);
            } else if (entry.getKey().is(Enchantments.SWEEPING_EDGE.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.SWEEPING_EDGE, true);
            } else if (entry.getKey().is(Enchantments.UNBREAKING.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.UNBREAKING, true);
            } else if (entry.getKey().is(Enchantments.BANE_OF_ARTHROPODS.location())) {
                SwordEnchantments.toggleEnchantment(swordEnchantments, Enchantments.BANE_OF_ARTHROPODS, true);
            }
        }

    }

    protected Map<ResourceKey<Enchantment>, Boolean> getEnchantments() {
        return null;
    }


    @Nullable
    public EasyVillagerEntity getVillagerEntity() {
        if (villagerEntity == null && !villager.isEmpty()) {
            villagerEntity = VillagerData.createEasyVillager(villager, level);
        }
        return villagerEntity;
    }


    protected void onAddVillager(EasyVillagerEntity villager) {

    }

    public ItemStack getSwordType() {
        return ItemStack.EMPTY;
    }

}
