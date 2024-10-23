package com.awesomeshot5051.mobfarms.advancements;

import com.awesomeshot5051.mobfarms.Main;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;
import java.util.function.Supplier;

public record MobFarmsTriggerInstance(Optional<ContextAwarePredicate> player, ItemPredicate predicate)
        implements SimpleCriterionTrigger.SimpleInstance {
    public static final Codec<MobFarmsTriggerInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(MobFarmsTriggerInstance::player),
            ItemPredicate.CODEC.fieldOf("item").forGetter(MobFarmsTriggerInstance::predicate)
    ).apply(instance, MobFarmsTriggerInstance::new));

    public boolean matches(ItemStack stack) {
        // Since ItemPredicate matches a stack, we use a stack as the input here.
        return this.predicate.test(stack);
    }

    // In this example, WITHER_FARM_CRAFTED is a DeferredHolder<CriterionTrigger<?>, MobFarmsTrigger>.
// See below for how to register triggers.
    public class MobFarmsTrigger extends SimpleCriterionTrigger<MobFarmsTriggerInstance> {

        public static final DeferredRegister<CriterionTrigger<?>> TRIGGER_TYPES =
                DeferredRegister.create(Registries.TRIGGER_TYPE, Main.MODID);

        public static final Supplier<WitherFarmCriterionTrigger> WITHER_FARM_TRIGGER =
                TRIGGER_TYPES.register("wither_farm_trigger", WitherFarmCriterionTrigger::new);

        public static Criterion<MobFarmsTriggerInstance> instance(ContextAwarePredicate player, ItemPredicate item) {
            return WITHER_FARM_TRIGGER.get().createCriterion(new MobFarmsTriggerInstance(Optional.of(player), item));
        }

        @Override
        public Codec<MobFarmsTriggerInstance> codec() {
            return MobFarmsTriggerInstance.CODEC;
        }
    }
}