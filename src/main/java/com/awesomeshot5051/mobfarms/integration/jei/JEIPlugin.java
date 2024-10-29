package com.awesomeshot5051.mobfarms.integration.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
   public ResourceLocation getPluginUid() {
/*  22 */     return ResourceLocation.fromNamespaceAndPath("mob_farms", "mob_farms");
   }
   
   public void registerRecipes(IRecipeRegistration registration) {
/*  27 */     List<ItemStack> foods = Villager.FOOD_POINTS.entrySet().stream().map(itemIntegerEntry -> new ItemStack((ItemLike)itemIntegerEntry.getKey(), (int)Math.ceil(24.0D / ((Integer)itemIntegerEntry.getValue()).intValue()))).toList();
/*  29 */     List<ItemStack> potions = new ArrayList<>();
/*  30 */     potions.add(PotionContents.createItemStack(Items.POTION, Potions.WEAKNESS));
/*  31 */     potions.add(PotionContents.createItemStack(Items.POTION, Potions.LONG_WEAKNESS));
/*  32 */     potions.add(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.WEAKNESS));
/*  33 */     potions.add(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.LONG_WEAKNESS));
/*  34 */     potions.add(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.WEAKNESS));
/*  35 */     potions.add(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.LONG_WEAKNESS));
   }
}
