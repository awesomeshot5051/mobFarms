package com.awesomeshot5051.mobfarms.integration.jei;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                Optional<RecipeHolder<?>> recipe = recipeManager.byKey(ResourceLocation.fromNamespaceAndPath(Main.MODID, "empty_farm_recipe"));
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
