package com.awesomeshot5051.mobfarms.enums;

import com.awesomeshot5051.mobfarms.Main;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum SwordType implements StringRepresentable {
    WOODEN,
    STONE,
    IRON,
    GOLDEN,
    DIAMOND,
    NETHERITE,
    CUSTOM;  // Fallback for dynamically added sword types
    private static final Map<Item, SwordType> customSwordMap = new HashMap<>();
    private static final Map<Item, String> customSwordNames = new HashMap<>();
    private static final Map<Item, Integer> customSwordRanks = new HashMap<>();

    static {
        // Pre-register vanilla swords with their rank
        registerSword(Items.WOODEN_SWORD, WOODEN, 1);
        registerSword(Items.STONE_SWORD, STONE, 2);
        registerSword(Items.IRON_SWORD, IRON, 3);
        registerSword(Items.GOLDEN_SWORD, GOLDEN, 4);
        registerSword(Items.DIAMOND_SWORD, DIAMOND, 5);
        registerSword(Items.NETHERITE_SWORD, NETHERITE, 6);
        registerSword(Items.WOODEN_AXE, CUSTOM, 1, Main.MODID);
    }


    /**
     * Registers a custom sword with a specific SwordType.
     * Allows custom names and rankings for higher swords.
     *
     * @param item      The custom sword item.
     * @param swordType The base SwordType to associate with the sword.
     * @param rank      The rank of the sword, higher numbers mean better.
     */
    public static void registerSword(Item item, SwordType swordType, int rank) {
        customSwordMap.put(item, swordType);
        customSwordRanks.put(item, rank);

        if (swordType == CUSTOM) {
            customSwordNames.put(item, item.getDescriptionId()); // Custom name fallback
        }
    }

    public static void registerSword(Item item, SwordType swordType, int rank, String resourceLocation) {
        customSwordMap.put(item, swordType);
        customSwordRanks.put(item, rank);

        if (swordType == CUSTOM) {
            customSwordNames.put(item, convertToRegistryName(resourceLocation, item.getDescriptionId())); // Custom name fallback
        }
    }

    private static String convertToRegistryName(String resourceLocation, String block) {
        return block.toLowerCase().replace(' ', '_').replace("item." + resourceLocation + ".", "");
    }

    /**
     * Finds the SwordType for the given item.
     * Defaults to CUSTOM if the item is not registered.
     *
     * @param item The item to find the SwordType for.
     * @return The corresponding SwordType or CUSTOM if none is found.
     */
    public static SwordType fromItem(Item item) {
        return customSwordMap.getOrDefault(item, CUSTOM);
    }

    /**
     * Retrieves the rank of the sword for comparison.
     * Defaults to 0 for unregistered swords.
     *
     * @param item The sword item to check.
     * @return The rank of the sword.
     */
    public static int getSwordRank(Item item) {
        return customSwordRanks.getOrDefault(item, 0);
    }

    /**
     * Retrieves the name of a custom sword.
     *
     * @param item The custom sword item.
     * @return The name of the sword or a default if not custom.
     */
    public static String getCustomSwordName(Item item) {
        return customSwordNames.getOrDefault(item, "Unknown Sword");
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase(); // Returns the enum name in lowercase
    }
}