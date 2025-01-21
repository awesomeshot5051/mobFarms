package com.awesomeshot5051.mobfarms;

import com.awesomeshot5051.mobfarms.API.farmAPI;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import static com.awesomeshot5051.mobfarms.enums.SwordType.CUSTOM;
import static com.awesomeshot5051.mobfarms.enums.SwordType.NETHERITE;

public class MobFarmsAPI {
    public MobFarmsAPI() {
        farmAPI.registerUpgradeMaterial(Ingredient.of(Items.QUARTZ), Items.STICK, NETHERITE, 5);
        farmAPI.registerUpgradeMaterial(Ingredient.of(Items.CUT_COPPER_SLAB), Items.STICK, CUSTOM, 7, Main.MODID);
    }
}
