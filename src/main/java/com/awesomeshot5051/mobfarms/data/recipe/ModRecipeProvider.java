package com.awesomeshot5051.mobfarms.data.recipe;

import com.awesomeshot5051.mobfarms.blocks.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.conditions.*;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // List of blocks that require a pickaxe to mine
    public static final List<Supplier<Block>> PICKAXE_BLOCKS = List.of(
            ModBlocks.IRON_FARM::get
    );
    public static final List<Supplier<Block>> SHOVEL_BLOCKS = List.of(
    );


    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

    }

    private String convertToRegistryName(String block) {
        return block.toLowerCase().replace(' ', '_').replace("block.resource_farms.", "");
    }

}
