package com.awesomeshot5051.mobfarms.enums;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public enum SwordType implements StringRepresentable {
    WOODEN,
    STONE,
    IRON,
    GOLDEN,
    DIAMOND,
    NETHERITE;
    final List<Item> swordTypes = List.of(Items.NETHERITE_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD, Items.IRON_SWORD, Items.STONE_SWORD, Items.WOODEN_SWORD);

    public static SwordType fromItem(Item item) {
        if (item == Items.WOODEN_SWORD) return WOODEN;
        if (item == Items.STONE_SWORD) return STONE;
        if (item == Items.IRON_SWORD) return IRON;
        if (item == Items.GOLDEN_SWORD) return GOLDEN;
        if (item == Items.DIAMOND_SWORD) return DIAMOND;
        if (item == Items.NETHERITE_SWORD) return NETHERITE;
        return WOODEN;  // Default
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase();  // Returns the enum name in lowercase (e.g., "wooden", "stone", etc.)
    }
}