package com.awesomeshot5051.mobfarms.data.recipe;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.data.recipe.recipe.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.*;
import net.neoforged.neoforge.common.conditions.*;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // List of blocks that require a pickaxe to mine
    public static final List<Supplier<Block>> REGULAR_FARMS = List.of(
            ModBlocks.IRON_FARM::get
    );
    public static final List<Supplier<Block>> SHOVEL_BLOCKS = List.of(
    );


    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLAZE_FARM.get())
                .pattern("GGG")
                .pattern("GFG")
                .pattern("BSB")
                .define('G', Tags.Items.GLASS_PANES)
                .define('F', Ingredient.of(Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.DIAMOND_SWORD, Items.NETHERITE_SWORD))
                .define('B', Items.BLAZE_ROD)
                .define('S', Items.STONE)
                .unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.BLAZE_FARM.get().getDescriptionId()) + "_recipe"));
CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC,Mo)
    }

    private String convertToRegistryName(String block) {
        return block.toLowerCase().replace(' ', '_').replace("block.mob_farms.", "");
    }

}
