package com.awesomeshot5051.mobfarms.data.providers.recipe;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.data.providers.recipe.recipe.CustomShapedRecipeBuilder;
import com.awesomeshot5051.mobfarms.data.providers.recipe.recipe.CustomShapelessRecipeBuilder;
import com.awesomeshot5051.mobfarms.data.providers.recipe.recipe.EnchantmentAdditionRecipeBuilder;
import com.awesomeshot5051.mobfarms.data.providers.recipe.recipe.EnchantmentRemovalRecipeBuilder;
import com.awesomeshot5051.mobfarms.data.providers.recipe.recipe.UpgradeRecipeBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.BLAZE_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.CHICKEN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.COD_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.COW_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.CREEPER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.DROWNED_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.ELDER_GUARDIAN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.EMPTY_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.ENDERMAN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.EVOKER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.GHAST_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.GLOW_SQUID_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.GOAT_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.GUARDIAN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.HOGLIN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.HORSE_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.ILLUSIONER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.IRON_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.MAGMA_CUBE_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.MOOSHROOM_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.PARROT_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.PHANTOM_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.PIGLIN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.PIG_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.PILLAGER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.PUFFERFISH_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.RABBIT_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.RAVAGER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SALMON_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SHEEP_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SHULKER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SKELETON_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SLIME_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SNOW_GOLEM_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SPIDER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.SQUID_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.STRIDER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.TROPICAL_FISH_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.TURTLE_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.VINDICATOR_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.WARDEN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.WITCH_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.WITHER_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.WITHER_SKELETON_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.ZOGLIN_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.ZOMBIE_FARM;
import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.ZOMBIFIED_PIGLIN_FARM;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // List of blocks that require a pickaxe to mine
    public static final List<DeferredHolder<Block, ?>> ALL_FARMS = List.of(
            // Passive Mobs
            CHICKEN_FARM,
            COD_FARM,
            COW_FARM,
            GLOW_SQUID_FARM,
            HORSE_FARM,
            MOOSHROOM_FARM,
            PARROT_FARM,
            PIG_FARM,
            PUFFERFISH_FARM,
            RABBIT_FARM,
            SALMON_FARM,
            SHEEP_FARM,
            SNOW_GOLEM_FARM,
            SQUID_FARM,
            STRIDER_FARM,
            TROPICAL_FISH_FARM,
            TURTLE_FARM,

            // Neutral Mobs
            ENDERMAN_FARM,
            GOAT_FARM,
            IRON_FARM,
            SPIDER_FARM,
            PIGLIN_FARM,
            ZOMBIFIED_PIGLIN_FARM,

            // Aggressive Mobs
            BLAZE_FARM,
            CREEPER_FARM,
            DROWNED_FARM,
            ELDER_GUARDIAN_FARM,
            EVOKER_FARM,
            GHAST_FARM,
            GUARDIAN_FARM,
            HOGLIN_FARM,
            ILLUSIONER_FARM,
            MAGMA_CUBE_FARM,
            PHANTOM_FARM,
            PILLAGER_FARM,
            RAVAGER_FARM,
            SHULKER_FARM,
            SKELETON_FARM,
            SLIME_FARM,
            VINDICATOR_FARM,
            WARDEN_FARM,
            WITCH_FARM,
            WITHER_SKELETON_FARM,
            WITHER_FARM,
            ZOGLIN_FARM,
            ZOMBIE_FARM
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
                .define('#', Tags.Items.GLASS_PANES)
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
                .define('#', Tags.Items.GLASS_PANES)
                .define('F', ItemTags.SWORDS)
                .define('G', Items.GHAST_TEAR)
                .define('S', Items.STONE)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.GHAST_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HOGLIN_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("YSP")
                .define('#', Tags.Items.GLASS_PANES)
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
                .define('#', Tags.Items.GLASS_PANES)
                .define('F', ItemTags.SWORDS)
                .define('P', Items.PHANTOM_MEMBRANE)
                .define('S', Items.STONE)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.PHANTOM_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PILLAGER_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("ESO")
                .define('#', Tags.Items.GLASS_PANES)
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
                .define('#', Tags.Items.GLASS_PANES)
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
                .define('#', Tags.Items.GLASS_PANES)
                .define('F', ItemTags.SWORDS)
                .define('S', Items.SKELETON_SKULL)
                .define('T', Items.STONE)
                .define('B', Items.BONE)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.SKELETON_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SLIME_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("SIB")
                .define('#', Tags.Items.GLASS_PANES)
                .define('F', ItemTags.SWORDS)
                .define('S', Items.SLIME_BLOCK)
                .define('I', Items.STONE)
                .define('B', Items.SLIME_BALL)
                .unlockedBy("has_sword", has(ItemTags.SWORDS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.SLIME_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINDICATOR_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("ISE")
                .define('#', Tags.Items.GLASS_PANES)
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
                .define('#', Tags.Items.GLASS_PANES)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('S', Items.SCULK_CATALYST)
                .define('M', Items.STONE)
                .unlockedBy("has_sculk_catalyst", has(Items.SCULK_CATALYST))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.WARDEN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WITCH_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("GSR")
                .define('#', Tags.Items.GLASS_PANES)
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
                .define('#', Tags.Items.GLASS_PANES)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('W', Items.WITHER_SKELETON_SKULL)
                .define('S', Items.STONE)
                .unlockedBy("has_wither_skeleton_skull", has(Items.WITHER_SKELETON_SKULL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.WITHER_SKELETON_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, EMPTY_FARM.get())
                .pattern("WWW")
                .pattern("SSS")
                .pattern("BSB")
                .define('W', Items.WITHER_SKELETON_SKULL)
                .define('S', Ingredient.of(Items.SOUL_SOIL, Items.SOUL_SAND))
                .define('B', Items.NETHER_STAR)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.EMPTY_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WITHER_FARM.get())
                .requires(EMPTY_FARM.get())
                .requires(Ingredient.of(ItemTags.SWORDS))
                .unlockedBy("has_empty_farm", has(EMPTY_FARM.get()))  // Unlock condition
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(WITHER_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZOGLIN_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("RSR")
                .define('#', Tags.Items.GLASS_PANES)
                .define('F', ItemTags.SWORDS) // Replace lava bucket with swords
                .define('R', Items.ROTTEN_FLESH)
                .define('S', Items.STONE)
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ZOGLIN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZOMBIE_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("RSZ")
                .define('#', Tags.Items.GLASS_PANES)
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
                .define('#', Tags.Items.GLASS_PANES)
                .define('L', ItemTags.SWORDS)
                .define('E', Ingredient.of(Items.ENDER_EYE, Items.ENDER_PEARL))
                .define('S', Items.STONE)
                .unlockedBy("has_ender_eye", has(Items.ENDER_EYE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ENDERMAN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOAT_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("GSG")
                .define('#', Tags.Items.GLASS_PANES)
                .define('L', ItemTags.SWORDS)
                .define('G', Items.GOAT_HORN)
                .define('S', Items.STONE)
                .unlockedBy("has_goat_horn", has(Items.GOAT_HORN))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.GOAT_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRON_FARM.get())
                .pattern("GGG")
                .pattern("GLG")
                .pattern("ISI")
                .define('G', Tags.Items.GLASS_PANES)
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STONE)
                .define('L', ItemTags.SWORDS)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.IRON_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PIGLIN_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("PSP")
                .define('#', Tags.Items.GLASS_PANES)
                .define('L', ItemTags.SWORDS)
                .define('P', Items.PIGLIN_HEAD)
                .define('S', Items.STONE)
                .unlockedBy("has_piglin_head", has(Items.PIGLIN_HEAD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.PIGLIN_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SPIDER_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("SEN")
                .define('#', Tags.Items.GLASS_PANES)
                .define('L', ItemTags.SWORDS)
                .define('S', Items.STRING)
                .define('E', Items.STONE)
                .define('N', Items.SPIDER_EYE)
                .unlockedBy("has_spider_eye", has(Items.SPIDER_EYE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.SPIDER_FARM.get().getDescriptionId()) + "_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZOMBIFIED_PIGLIN_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("gSG")
                .define('#', Tags.Items.GLASS_PANES)
                .define('L', ItemTags.SWORDS)
                .define('g', Items.GOLD_INGOT)
                .define('S', Items.STONE)
                .define('G', Items.GOLD_NUGGET)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ModBlocks.ZOMBIFIED_PIGLIN_FARM.get().getDescriptionId()) + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHICKEN_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("CSF")
                .define('#', Tags.Items.GLASS_PANES)
                .define('L', ItemTags.SWORDS)
                .define('C', Ingredient.of(Items.CHICKEN, Items.COOKED_CHICKEN))
                .define('S', Items.STONE)
                .define('F', Items.FEATHER)
                .unlockedBy("has_chicken", has(Items.CHICKEN))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "chicken_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COD_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("CSO")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('C', Items.COD)
                .define('O', Items.COOKED_COD)
                .unlockedBy("has_cod", has(Items.COD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "cod_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COW_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("BSX")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('B', Items.BEEF)
                .define('X', Items.LEATHER)
                .unlockedBy("has_beef", has(Items.BEEF))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "cow_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GLOW_SQUID_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("GSG")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('G', Items.GLOW_INK_SAC)
                .unlockedBy("has_glow_ink_sac", has(Items.GLOW_INK_SAC))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "glow_squid_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HORSE_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("YSY")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('Y', Items.LEATHER)
                .unlockedBy("has_leather", has(Items.LEATHER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "horse_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOOSHROOM_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("BSR")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('B', Items.BEEF)
                .define('R', Items.RED_MUSHROOM)
                .unlockedBy("has_red_mushroom", has(Items.RED_MUSHROOM))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "mooshroom_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PARROT_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("FSF")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('F', Items.FEATHER)
                .unlockedBy("has_feather", has(Items.FEATHER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "parrot_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PIG_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("PSC")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('P', Items.PORKCHOP)
                .define('C', Items.COOKED_PORKCHOP)
                .unlockedBy("has_porkchop", has(Items.PORKCHOP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "pig_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PUFFERFISH_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("PSP")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('P', Items.PUFFERFISH)
                .unlockedBy("has_pufferfish", has(Items.PUFFERFISH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "pufferfish_farm_recipe"));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RABBIT_FARM.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("RSK")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', ItemTags.SWORDS)
                .define('R', Items.RABBIT)
                .define('K', Ingredient.of(Items.RABBIT_FOOT, Items.RABBIT_HIDE))
                .unlockedBy("has_rabbit", has(Items.RABBIT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "rabbit_farm_recipe"));


// Salmon Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SALMON_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("SYB")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', Items.SALMON)
                .define('Y', Items.STONE)
                .define('B', Items.BONE_MEAL)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_salmon", has(Items.SALMON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "salmon_farm_recipe"));

// Sheep Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SHEEP_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("MSW")
                .define('#', Tags.Items.GLASS_PANES)
                .define('M', Items.MUTTON)
                .define('S', Items.STONE)
                .define('W', ItemTags.WOOL)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_mutton", has(Items.MUTTON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "sheep_farm_recipe"));

// Snow Golem Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SNOW_GOLEM_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("SZC")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', Items.SNOWBALL)
                .define('Z', Items.STONE)
                .define('C', Items.CARVED_PUMPKIN)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_snowball", has(Items.SNOWBALL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "snow_golem_farm_recipe"));

// Squid Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SQUID_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("ISI")
                .define('#', Tags.Items.GLASS_PANES)
                .define('I', Items.INK_SAC)
                .define('S', Items.STONE)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_ink_sac", has(Items.INK_SAC))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "squid_farm_recipe"));

// Strider Farm Recipe
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIDER_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("SOS")
                .define('#', Tags.Items.GLASS_PANES)
                .define('S', Items.STRING)
                .define('O', Items.STONE)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_string", has(Items.STRING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "strider_farm_recipe"));

// Tropical Fish Farm Recipe (Merged as same pattern)
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TROPICAL_FISH_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("TST")
                .define('#', Tags.Items.GLASS_PANES)
                .define('T', Items.TROPICAL_FISH)
                .define('S', Items.STONE)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_tropical_fish", has(Items.TROPICAL_FISH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "tropical_fish_farm_recipe"));

// Turtle Farm Recipe (Merged)
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TURTLE_FARM.get())
                .pattern("###")
                .pattern("#L#")
                .pattern("TSU")
                .define('#', Tags.Items.GLASS_PANES)
                .define('T', Items.TURTLE_SCUTE)
                .define('S', Items.STONE)
                .define('U', Items.SEAGRASS)
                .define('L', Ingredient.of(Items.DIAMOND_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.NETHERITE_SWORD, Items.STONE_SWORD))  // All swords
                .unlockedBy("has_turtle_scute", has(Items.TURTLE_SCUTE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "turtle_farm_recipe"));
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" S ")
                    .pattern("SFS")
                    .pattern(" S ")
                    .define('S', Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE))
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_stone", has(Items.COBBLESTONE))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_stone_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" I ")
                    .pattern("IFI")
                    .pattern(" I ")
                    .define('I', Items.IRON_INGOT)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_iron", has(Items.IRON_INGOT))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_iron_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" G ")
                    .pattern("GFG")
                    .pattern(" G ")
                    .define('G', Items.GOLD_INGOT)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_gold_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" D ")
                    .pattern("DFD")
                    .pattern(" D ")
                    .define('D', Items.DIAMOND)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_diamond", has(Items.DIAMOND))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_diamond_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" N ")
                    .pattern("NFN")
                    .pattern(" N ")
                    .define('N', Items.NETHERITE_INGOT)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_netherite", has(Items.NETHERITE_INGOT))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_netherite_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            EnchantmentAdditionRecipeBuilder.shapeless(RecipeCategory.MISC, farmBlock)
                    .requires(Items.ENCHANTED_BOOK)
                    .requires(farmBlock.asItem())
                    .unlockedBy("has_enchanted_book", has(ItemTags.SWORD_ENCHANTABLE))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_enchant_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            EnchantmentRemovalRecipeBuilder.shapeless(RecipeCategory.MISC, farmBlock)
                    .requires(farmBlock.asItem())
                    .unlockedBy("has_farm", has(farmBlock.asItem()))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId() + "_enchantment_removal_recipe")));
        });

    }

    private String convertToRegistryName(String block) {
        return block.toLowerCase().replace(' ', '_').replace("block.mob_farms.", "");
    }

}
