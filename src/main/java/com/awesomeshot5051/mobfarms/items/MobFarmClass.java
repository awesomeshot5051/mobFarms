package com.awesomeshot5051.mobfarms.items;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PillagerFarmTileentity;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.providers.VanillaEnchantmentProviders;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class MobFarmClass extends Mob {
    public MobFarmClass(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

//    @Override
//    public void enchantSpawnedWeapon(ServerLevelAccessor level, RandomSource random, DifficultyInstance difficulty) {
//        this.enchantSpawnedEquipment(level, EquipmentSlot.MAINHAND, random, 0.25F, difficulty);
//    }

    public void enchantSpawnedEquipment(ServerLevelAccessor level, EquipmentSlot slot, RandomSource random, float enchantChance, DifficultyInstance difficulty, PillagerFarmTileentity tileEntity, int slotIndex) {
        ItemStack itemstack = new ItemStack(Items.CROSSBOW);

        // Check if the itemstack is not empty and if the enchant chance is met
        if (!itemstack.isEmpty() && random.nextFloat() < enchantChance * difficulty.getSpecialMultiplier()) {
            // Enchant the item using the specified providers
            EnchantmentHelper.enchantItemFromProvider(itemstack, level.registryAccess(), VanillaEnchantmentProviders.PILLAGER_SPAWN_CROSSBOW, difficulty, random);
        }

        // Set the enchanted item in the specified slot of the TileEntity's inventory
        if (tileEntity != null) {
            tileEntity.setItem(slotIndex, itemstack); // Use the method to set the item in the inventory
        }
    }
}
