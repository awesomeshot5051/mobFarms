package com.awesomeshot5051.mobfarms.API;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.data.providers.recipe.recipe.UpgradeRecipe;
import com.awesomeshot5051.mobfarms.enums.SwordType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class farmAPI {
    public static void registerUpgradeMaterial(Ingredient material, Item sword, SwordType swordType, int rank) {
        // Check for null or empty parameters
        if (material == null || sword == null || swordType == null || rank <= 0) {
            throw new IllegalArgumentException("Invalid input: Material, sword, swordType, and rank must be non-null and rank > 0.");
        }

        // Add to material-to-sword and sword-to-material maps
        if (UpgradeRecipe.materialToSwordMap.containsKey(material)) {
            throw new IllegalStateException("Material " + material + " is already mapped to a sword.");
        }
        if (UpgradeRecipe.SwordToMaterialMap.containsKey(sword)) {
            throw new IllegalStateException("Sword " + sword + " is already mapped to a material.");
        }

        UpgradeRecipe.materialToSwordMap.put(material, sword);
        UpgradeRecipe.SwordToMaterialMap.put(sword, material);

        // Register the sword in the SwordType system
        SwordType.registerSword(sword, swordType, rank);

        // Optionally log the registration for debugging
        Main.LOGGER.info("Registered upgrade material: {} -> {}, type: {}, rank: {}", material, sword, swordType, rank);
    }

    public static void registerUpgradeMaterial(Ingredient material, Item sword, SwordType swordType, int rank, String modid) {
        // Check for null or empty parameters
        if (material == null || sword == null || swordType == null || rank <= 0) {
            throw new IllegalArgumentException("Invalid input: Material, sword, swordType, and rank must be non-null and rank > 0.");
        }

        // Add to material-to-sword and sword-to-material maps
        if (UpgradeRecipe.materialToSwordMap.containsKey(material)) {
            throw new IllegalStateException("Material " + material + " is already mapped to a sword.");
        }
        if (UpgradeRecipe.SwordToMaterialMap.containsKey(sword)) {
            throw new IllegalStateException("Sword " + sword + " is already mapped to a material.");
        }

        UpgradeRecipe.materialToSwordMap.put(material, sword);
        UpgradeRecipe.SwordToMaterialMap.put(sword, material);

        // Register the sword in the SwordType system
        SwordType.registerSword(sword, swordType, rank, convertToRegistryName(modid, sword.getDescriptionId()));

        // Optionally log the registration for debugging
        Main.LOGGER.info("Registered upgrade material: {} -> {}, type: {}, rank: {}, modid: {}", material, sword, swordType, rank, modid);
    }

    private static String convertToRegistryName(String resourceLocation, String block) {
        return block.toLowerCase().replace(' ', '_').replace("item." + resourceLocation + ".", "");
    }
}