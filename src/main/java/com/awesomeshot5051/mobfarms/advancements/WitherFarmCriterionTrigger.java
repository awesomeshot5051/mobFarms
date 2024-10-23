package com.awesomeshot5051.mobfarms.advancements;

import com.mojang.serialization.Codec;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;


public class WitherFarmCriterionTrigger extends SimpleCriterionTrigger<MobFarmsTriggerInstance> {
    // This method is unique for each trigger and is as such not a method to override
    public void trigger(ServerPlayer player, ItemStack stack) {
        this.trigger(player,
                // The condition checker method within the SimpleCriterionTrigger.SimpleInstance subclass
                triggerInstance -> triggerInstance.matches(stack)
        );

    }

    @Override
    public Codec<MobFarmsTriggerInstance> codec() {
        return MobFarmsTriggerInstance.CODEC;
    }
}