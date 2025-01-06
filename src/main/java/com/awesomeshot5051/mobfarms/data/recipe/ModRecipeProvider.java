package com.awesomeshot5051.mobfarms.data.recipe;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.data.recipe.recipe.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.*;
import net.minecraft.tags.*;
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
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CREEPER_FARM.get())
                .pattern("GGG")
                .pattern("GFG")
                .pattern("BSB")
                .define('G', Tags.Items.GLASS_PANES)
                .define('F', Ingredient.of(Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.DIAMOND_SWORD, Items.NETHERITE_SWORD))
                .define('B', Items.GUNPOWDER)
                .define('S', Items.STONE)
                .unlockedBy("has_gunpowder", has(Items.GUNPOWDER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.CREEPER_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DROWNED_FARM.get())
                .pattern("GGG")
                .pattern("GFG")
                .pattern("RSN")
                .define('G', Tags.Items.GLASS_PANES)
                .define('F', Ingredient.of(Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.DIAMOND_SWORD, Items.NETHERITE_SWORD))
                .define('N', Ingredient.of(Items.NAUTILUS_SHELL, Items.TRIDENT))
                .define('R', Items.ROTTEN_FLESH)
                .define('S', Items.STONE)
                .unlockedBy("has_trident", has(Items.TRIDENT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.DROWNED_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ELDER_GUARDIAN_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("PSA")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('P', Items.PRISMARINE_CRYSTALS)
                .define('S', Items.STONE)
                .define('A', Items.PRISMARINE_SHARD)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ELDER_GUARDIAN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GHAST_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("GSG")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('G', Items.GHAST_TEAR)
                .define('S', Items.STONE)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.GHAST_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HOGLIN_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("YSP")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('Y', Items.LEATHER)
                .define('S', Items.STONE)
                .define('P', Ingredient.of(Items.PORKCHOP, Items.COOKED_PORKCHOP))
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.HOGLIN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHANTOM_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("PSP")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('P', Items.PHANTOM_MEMBRANE)
                .define('S', Items.STONE)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.PHANTOM_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PILLAGER_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("ESO")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('E', Items.EMERALD)
                .define('S', Items.STONE)
                .define('O', Items.OMINOUS_BOTTLE)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.PILLAGER_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SHULKER_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("SNU")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('S', Items.SHULKER_BOX)
                .define('N', Items.STONE)
                .define('U', Items.SHULKER_SHELL)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.SHULKER_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SKELETON_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("STB")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('S', Items.SKELETON_SKULL)
                .define('T', Items.STONE)
                .define('B', Items.BONE)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.SKELETON_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SLIME_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("SIF")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS)
                .define('S', Items.SLIME_BLOCK)
                .define('I', Items.STONE)
                .define('F', Items.SLIME_BALL)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.SLIME_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINDICATOR_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("ISE")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('I', Ingredient.of(Items.IRON_SHOVEL, Items.IRON_AXE))
                .define('S', Items.STONE)
                .define('E', Ingredient.of(Items.EMERALD, Items.ENCHANTED_BOOK))
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.VINDICATOR_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WARDEN_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("SMS")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('S', Items.SCULK_CATALYST)
                .define('M', Items.STONE)
                .unlockedBy("has_sculk_catalyst", has(Items.SCULK_CATALYST))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.WARDEN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WITCH_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("GSR")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('G', Items.GLASS_BOTTLE)
                .define('S', Items.STONE)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.WITCH_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WITHER_SKELETON_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("WSW")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('W', Items.WITHER_SKELETON_SKULL)
                .define('S', Items.STONE)
                .unlockedBy("has_wither_skeleton_skull", has(Items.WITHER_SKELETON_SKULL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.WITHER_SKELETON_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WITHER_SKELETON_FARM.get())
                .pattern("WWW")
                .pattern("SSS")
                .pattern("BSB")
                .define('W', Items.WITHER_SKELETON_SKULL)
                .define('S', Ingredient.of(Items.SOUL_SOIL, Items.SOUL_SAND))
                .define('B', Items.NETHER_STAR)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.WITHER_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZOGLIN_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("RSR")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('R', Items.ROTTEN_FLESH)
                .define('S', Items.STONE)
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ZOGLIN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZOMBIE_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("RSZ")
                .define('#', Items.GLASS_PANE)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('R', Items.ROTTEN_FLESH)
                .define('S', Items.STONE)
                .define('Z', Items.ZOMBIE_HEAD)
                .unlockedBy("has_zombie_head", has(Items.ZOMBIE_HEAD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ZOMBIE_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENDERMAN_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("ESE")
                .define('#', Items.GLASS_PANE)
                .define('L', Items.LAVA_BUCKET)
                .define('E', Ingredient.of(Items.ENDER_EYE, Items.ENDER_PEARL))
                .define('S', Items.STONE)
                .unlockedBy("has_ender_eye", has(Items.ENDER_EYE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ENDERMAN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOAT_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("GSG")
                .define('#', Items.GLASS_PANE)
                .define('L', Items.LAVA_BUCKET)
                .define('G', Items.GOAT_HORN)
                .define('S', Items.STONE)
                .unlockedBy("has_goat_horn", has(Items.GOAT_HORN))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.GOAT_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRON_FARM.get())
                .pattern("GGG")
                .pattern("GLG")
                .pattern("ISI")
                .define('G', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STONE)
                .define('L', Items.LAVA_BUCKET)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.IRON_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PIGLIN_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("PSP")
                .define('#', Items.GLASS_PANE)
                .define('L', Items.LAVA_BUCKET)
                .define('P', Items.PIGLIN_HEAD)
                .define('S', Items.STONE)
                .unlockedBy("has_piglin_head", has(Items.PIGLIN_HEAD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.PIGLIN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SPIDER_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("SEN")
                .define('#', Items.GLASS_PANE)
                .define('L', Items.LAVA_BUCKET)
                .define('S', Items.STRING)
                .define('E', Items.STONE)
                .define('N', Items.SPIDER_EYE)
                .unlockedBy("has_spider_eye", has(Items.SPIDER_EYE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.SPIDER_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZOMBIFIED_PIGLIN_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("gSG")
                .define('#', Items.GLASS_PANE)
                .define('L', Items.LAVA_BUCKET)
                .define('g', Items.GOLD_INGOT)
                .define('S', Items.STONE)
                .define('G', Items.GOLD_NUGGET)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ZOMBIFIED_PIGLIN_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHICKEN_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("CSF")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.IRON_SWORD)
                .define('C', Items.CHICKEN)
                .define('F', Items.FEATHER)
                .unlockedBy("has_chicken", has(Items.CHICKEN))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "chicken_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COD_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("CSO")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.DIAMOND_SWORD)
                .define('C', Items.COD)
                .define('O', Items.COOKED_COD)
                .unlockedBy("has_cod", has(Items.COD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "cod_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COW_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("BSX")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.GOLDEN_SWORD)
                .define('B', Items.BEEF)
                .define('X', Items.LEATHER)
                .unlockedBy("has_beef", has(Items.BEEF))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "cow_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GLOW_SQUID_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("GSG")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.NETHERITE_SWORD)
                .define('G', Items.GLOW_INK_SAC)
                .unlockedBy("has_glow_ink_sac", has(Items.GLOW_INK_SAC))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "glow_squid_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HORSE_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("YSY")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.IRON_SWORD)
                .define('Y', Items.LEATHER)
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "horse_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOOSHROOM_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("BSR")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.DIAMOND_SWORD)
                .define('B', Items.BEEF)
                .define('R', Items.RED_MUSHROOM)
                .unlockedBy("has_red_mushroom", has(Items.RED_MUSHROOM))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "mooshroom_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PARROT_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("FSF")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.GOLDEN_SWORD)
                .define('F', Items.FEATHER)
                .unlockedBy("has_feather", has(Items.FEATHER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "parrot_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PIG_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("PSC")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.NETHERITE_SWORD)
                .define('P', Items.PORKCHOP)
                .define('C', Items.COOKED_PORKCHOP)
                .unlockedBy("has_porkchop", has(Items.PORKCHOP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "pig_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PUFFERFISH_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("PSP")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.IRON_SWORD)
                .define('P', Items.PUFFERFISH)
                .unlockedBy("has_pufferfish", has(Items.PUFFERFISH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "pufferfish_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RABBIT_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("RSK")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.DIAMOND_SWORD)
                .define('R', Items.RABBIT)
                .define('K', Ingredient.of(Items.RABBIT_FOOT, Items.RABBIT_HIDE))
                .unlockedBy("has_rabbit", has(Items.RABBIT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "rabbit_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RABBIT_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("RSO")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.GOLDEN_SWORD)
                .define('R', Items.RABBIT_HIDE)
                .define('O', Items.RABBIT_FOOT)
                .unlockedBy("has_rabbit_hide", has(Items.RABBIT_HIDE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "rabbit_farm_recipe"));
// Salmon Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SALMON_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("SYB")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.SALMON)
                .define('Y', Items.STONE)
                .define('B', Items.BONE_MEAL)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_salmon", has(Items.SALMON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "salmon_farm_recipe"));

// Sheep Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SHEEP_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("MSW")
                .define('#', Items.GLASS_PANE)
                .define('M', Items.MUTTON)
                .define('S', Items.STONE)
                .define('W', ItemTags.WOOL)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_mutton", has(Items.MUTTON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "sheep_farm_recipe"));

// Snow Golem Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SNOW_GOLEM_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("SZC")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.SNOWBALL)
                .define('Z', Items.STONE)
                .define('C', Items.CARVED_PUMPKIN)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_snowball", has(Items.SNOWBALL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "snow_golem_farm_recipe"));

// Squid Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SQUID_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("ISI")
                .define('#', Items.GLASS_PANE)
                .define('I', Items.INK_SAC)
                .define('S', Items.STONE)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_ink_sac", has(Items.INK_SAC))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "squid_farm_recipe"));

// Strider Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIDER_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("SOS")
                .define('#', Items.GLASS_PANE)
                .define('S', Items.STRING)
                .define('O', Items.STONE)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_string", has(Items.STRING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "strider_farm_recipe"));

// Tropical Fish Farm Recipe (Merged as same pattern)
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TROPICAL_FISH_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("TST")
                .define('#', Items.GLASS_PANE)
                .define('T', Items.TROPICAL_FISH)
                .define('S', Items.STONE)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_tropical_fish", has(Items.TROPICAL_FISH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "tropical_fish_farm_recipe"));

// Turtle Farm Recipe (Merged)
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TURTLE_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("TSU")
                .define('#', Items.GLASS_PANE)
                .define('T', Items.TURTLE_SCUTE)
                .define('S', Items.STONE)
                .define('U', Items.SEAGRASS)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_turtle_scute", has(Items.TURTLE_SCUTE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "turtle_farm_recipe"));


    }

    private String convertToRegistryName(String block) {
        return block.toLowerCase().replace(' ', '_').replace("block.mob_farms.", "");
    }

}
