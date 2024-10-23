package com.awesomeshot5051.mobfarms.integration.jei;

import com.awesomeshot5051.mobfarms.Main;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, "mob_farms");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<ItemStack> foods = Villager.FOOD_POINTS.entrySet().stream().map(itemIntegerEntry -> new ItemStack(itemIntegerEntry.getKey(), (int) Math.ceil(24D / (double) itemIntegerEntry.getValue()))).toList();

        List<ItemStack> potions = new ArrayList<>();
        potions.add(PotionContents.createItemStack(Items.POTION, Potions.WEAKNESS));
        potions.add(PotionContents.createItemStack(Items.POTION, Potions.LONG_WEAKNESS));
        potions.add(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.WEAKNESS));
        potions.add(PotionContents.createItemStack(Items.SPLASH_POTION, Potions.LONG_WEAKNESS));
        potions.add(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.WEAKNESS));
        potions.add(PotionContents.createItemStack(Items.LINGERING_POTION, Potions.LONG_WEAKNESS));
    }

}
