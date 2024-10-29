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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class MobFarmClass extends Mob {
   public MobFarmClass(EntityType<? extends Mob> entityType, Level level) {
/*  18 */     super(entityType, level);
   }
   
   public void enchantSpawnedEquipment(ServerLevelAccessor level, EquipmentSlot slot, RandomSource random, float enchantChance, DifficultyInstance difficulty, PillagerFarmTileentity tileEntity, int slotIndex) {
/*  27 */     ItemStack itemstack = new ItemStack((ItemLike)Items.CROSSBOW);
/*  30 */     if (!itemstack.isEmpty() && random.nextFloat() < enchantChance * difficulty.getSpecialMultiplier())
/*  32 */       EnchantmentHelper.enchantItemFromProvider(itemstack, level.registryAccess(), VanillaEnchantmentProviders.PILLAGER_SPAWN_CROSSBOW, difficulty, random); 
/*  36 */     if (tileEntity != null)
/*  37 */       tileEntity.setItem(slotIndex, itemstack); 
   }
}
