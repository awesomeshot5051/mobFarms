package com.awesomeshot5051.mobfarms.integration.jei;

import com.awesomeshot5051.mobfarms.*;
import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.*;
import mezz.jei.api.*;
import mezz.jei.api.constants.*;
import mezz.jei.api.recipe.*;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.*;
import net.minecraft.client.*;
import net.minecraft.resources.*;
import net.minecraft.world.entity.npc.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.*;

import java.util.*;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, "mob_farms");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IRecipeManager recipeRegistry = jeiRuntime.getRecipeManager();
        assert Minecraft.getInstance().level != null;
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<RecipeHolder<CraftingRecipe>> hiddenRecipes = new ArrayList<>();
        for (var sidedBlock : ModBlocks.BLOCK_REGISTER.getEntries()) {
            if (sidedBlock.get() instanceof WitherFarmBlock baseMachineBlock) {
                Optional<RecipeHolder<?>> recipe = recipeManager.byKey(ResourceLocation.parse(sidedBlock.getId() + "_nbtclear"));
                recipe.ifPresent(recipeHolder -> hiddenRecipes.add((RecipeHolder<CraftingRecipe>) recipeHolder));
            }
        }
        recipeRegistry.hideRecipes(RecipeTypes.CRAFTING, hiddenRecipes);
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
