/*   0 */ package com.awesomeshot5051.mobfarms.integration.jei;
/*   0 */ 
/*   0 */ import java.util.ArrayList;
/*   0 */ import java.util.List;
/*   0 */ import java.util.Map;
/*   0 */ import mezz.jei.api.IModPlugin;
/*   0 */ import mezz.jei.api.JeiPlugin;
/*   0 */ import mezz.jei.api.registration.IRecipeRegistration;
/*   0 */ import net.minecraft.resources.ResourceLocation;
/*   0 */ import net.minecraft.world.entity.npc.Villager;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.minecraft.world.item.Items;
/*   0 */ import net.minecraft.world.item.alchemy.PotionContents;
/*   0 */ import net.minecraft.world.item.alchemy.Potions;
/*   0 */ import net.minecraft.world.level.ItemLike;
/*   0 */ 
/*   0 */ @JeiPlugin
/*   0 */ public class JEIPlugin implements IModPlugin {
/*   0 */   public ResourceLocation getPluginUid() {
/*  22 */     return ResourceLocation.fromNamespaceAndPath("mob_farms", "mob_farms");
/*   0 */   }
/*   0 */   
/*   0 */   public void registerRecipes(IRecipeRegistration registration) {
/*  27 */     List<ItemStack> foods = Villager.FOOD_POINTS.entrySet().stream().map(itemIntegerEntry -> new ItemStack((ItemLike)itemIntegerEntry.getKey(), (int)Math.ceil(24.0D / ((Integer)itemIntegerEntry.getValue()).intValue()))).toList();
/*  29 */     List<ItemStack> potions = new ArrayList<>();
/*  30 */     potions.add(PotionContents.createItemStack(Items.POTION, Potions.WEAKNESS));
/*  31 */     potions.add(PotionContents.createItemStack(Items.POTION, Potions.LONG_WEAKNESS));
/*  32 */     potions.add(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.WEAKNESS));
/*  33 */     potions.add(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.LONG_WEAKNESS));
/*  34 */     potions.add(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.WEAKNESS));
/*  35 */     potions.add(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.LONG_WEAKNESS));
/*   0 */   }
/*   0 */ }
