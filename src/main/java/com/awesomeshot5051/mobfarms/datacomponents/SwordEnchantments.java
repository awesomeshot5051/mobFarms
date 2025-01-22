package com.awesomeshot5051.mobfarms.datacomponents;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.HashMap;
import java.util.Map;

public class SwordEnchantments {
    // Initialize the enchantments map with default values


    // Method to initialize the enchantments map
    public static Map<ResourceKey<Enchantment>, Boolean> initializeSwordEnchantments() {
        Map<ResourceKey<Enchantment>, Boolean> enchantmentsMap = new HashMap<>();
        enchantmentsMap.put(Enchantments.BANE_OF_ARTHROPODS, false);
        enchantmentsMap.put(Enchantments.FIRE_ASPECT, false);
        enchantmentsMap.put(Enchantments.KNOCKBACK, false);
        enchantmentsMap.put(Enchantments.LOOTING, false);
        enchantmentsMap.put(Enchantments.SHARPNESS, false);
        enchantmentsMap.put(Enchantments.SMITE, false);
        enchantmentsMap.put(Enchantments.SWEEPING_EDGE, false);
        enchantmentsMap.put(Enchantments.UNBREAKING, false);
        return enchantmentsMap;
    }

    // Helper method to set the value for a single enchantment
    private static void setEnchantment(Map<ResourceKey<Enchantment>, Boolean> swordEnchantments, ResourceKey<Enchantment> enchantment, boolean value) {
        if (swordEnchantments.containsKey(enchantment)) {
            swordEnchantments.put(enchantment, value);
        } else {
            throw new IllegalArgumentException("Invalid enchantment: " + enchantment);
        }
    }

    public static boolean getEnchantmentStatus(Map<ResourceKey<Enchantment>, Boolean> swordEnchantments, ResourceKey<Enchantment> enchantment) {
        if (swordEnchantments.containsKey(enchantment)) {
            return swordEnchantments.get(enchantment);
        } else {
            throw new IllegalArgumentException("Invalid enchantment: " + enchantment);
        }
    }

    // Method to toggle a single enchantment
    public static void toggleEnchantment(Map<ResourceKey<Enchantment>, Boolean> swordEnchantments, ResourceKey<Enchantment> enchantment, boolean value) {
        setEnchantment(swordEnchantments, enchantment, value);
    }

    // Method to toggle multiple enchantments
    public static void toggleEnchantments(Map<ResourceKey<Enchantment>, Boolean> swordEnchantments, Map<ResourceKey<Enchantment>, Boolean> enchantmentsToToggle) {
        for (Map.Entry<ResourceKey<Enchantment>, Boolean> entry : enchantmentsToToggle.entrySet()) {
            setEnchantment(swordEnchantments, entry.getKey(), entry.getValue());
        }
    }
}
