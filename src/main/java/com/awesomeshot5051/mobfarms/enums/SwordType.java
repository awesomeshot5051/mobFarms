package com.awesomeshot5051.mobfarms.enums;

import net.minecraft.util.*;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.*;

import java.util.*;

public enum SwordType implements StringRepresentable {
    WOODEN,
    STONE,
    IRON,
    GOLDEN,
    DIAMOND,
    NETHERITE;
    List<Item> swordTypes = List.of(Items.NETHERITE_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD, Items.IRON_SWORD, Items.STONE_SWORD, Items.WOODEN_SWORD);

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