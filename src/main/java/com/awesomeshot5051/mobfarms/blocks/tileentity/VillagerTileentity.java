package com.awesomeshot5051.mobfarms.blocks.tileentity;

//import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;

import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.awesomeshot5051.mobfarms.entity.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

import javax.annotation.*;
import java.util.*;

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
