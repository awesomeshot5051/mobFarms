/*   0 */ package com.awesomeshot5051.mobfarms.items;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PillagerFarmTileentity;
/*   0 */ import net.minecraft.util.RandomSource;
/*   0 */ import net.minecraft.world.DifficultyInstance;
/*   0 */ import net.minecraft.world.entity.EntityType;
/*   0 */ import net.minecraft.world.entity.EquipmentSlot;
/*   0 */ import net.minecraft.world.entity.Mob;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.minecraft.world.item.Items;
/*   0 */ import net.minecraft.world.item.enchantment.EnchantmentHelper;
/*   0 */ import net.minecraft.world.item.enchantment.providers.VanillaEnchantmentProviders;
/*   0 */ import net.minecraft.world.level.ItemLike;
/*   0 */ import net.minecraft.world.level.Level;
/*   0 */ import net.minecraft.world.level.ServerLevelAccessor;
/*   0 */ 
/*   0 */ public class MobFarmClass extends Mob {
/*   0 */   public MobFarmClass(EntityType<? extends Mob> entityType, Level level) {
/*  18 */     super(entityType, level);
/*   0 */   }
/*   0 */   
/*   0 */   public void enchantSpawnedEquipment(ServerLevelAccessor level, EquipmentSlot slot, RandomSource random, float enchantChance, DifficultyInstance difficulty, PillagerFarmTileentity tileEntity, int slotIndex) {
/*  27 */     ItemStack itemstack = new ItemStack((ItemLike)Items.CROSSBOW);
/*  30 */     if (!itemstack.isEmpty() && random.nextFloat() < enchantChance * difficulty.getSpecialMultiplier())
/*  32 */       EnchantmentHelper.enchantItemFromProvider(itemstack, level.registryAccess(), VanillaEnchantmentProviders.PILLAGER_SPAWN_CROSSBOW, difficulty, random); 
/*  36 */     if (tileEntity != null)
/*  37 */       tileEntity.setItem(slotIndex, itemstack); 
/*   0 */   }
/*   0 */ }
