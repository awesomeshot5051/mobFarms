package com.awesomeshot5051.mobfarms.data.providers.advancements;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.items.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        // Add an instance of our generator to the list parameter. This can be done as many times as you want.
        // Having multiple generators is purely for organization, all functionality can be achieved with a single generator.
        super(output, lookupProvider, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
            Advancement.Builder builder = Advancement.Builder.advancement();

// Sets the parent of the advancement. You can use another advancement you have already generated,
// or create a placeholder advancement using the static AdvancementSubProvider#createPlaceholder method.
            builder.parent(AdvancementSubProvider.createPlaceholder("minecraft:story/root"));
            builder.display(
                    // The advancement icon. Can be an ItemStack or an ItemLike.
                    new ItemStack(ModItems.IRON_FARM),
                    // The advancement title and description. Don't forget to add translations for these!
                    Component.translatable("advancements.mob_farms.unlimitedpower.title"),
                    Component.translatable("advancements.mob_farms.unlimitedpower.description"),
                    // The background texture. Use null if you don't want a background texture (for non-root advancements).
                    null,
                    // The frame type. Valid values are AdvancementType.TASK, CHALLENGE, or GOAL.
                    AdvancementType.CHALLENGE,
                    // Whether to show the advancement toast or not.
                    true,
                    // Whether to announce the advancement into chat or not.
                    true,
                    // Whether the advancement should be hidden or not.
                    true
            );

// An advancement reward builder. Can be created with any of the four reward types, and further rewards
// can be added using the methods prefixed with add. This can also be built beforehand,
// and the resulting AdvancementRewards can then be reused across multiple advancement builders.
            builder.rewards(
                    // Alternatively, use addExperience() to add to an existing builder.
                    AdvancementRewards.Builder.experience(100000)
            );

// Adds a criterion with the given name to the advancement. Use the corresponding trigger instance's static method.
            builder.addCriterion("craft_wither_farm", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WITHER_FARM.get()));

// Adds a requirements handler. Minecraft natively provides allOf() and anyOf(), more complex requirements
// must be implemented manually. Only has an effect with two or more criteria.
            builder.requirements(AdvancementRequirements.allOf(List.of("craft_wither_farm")));

// Save the advancement to disk, using the given resource location. This returns an AdvancementHolder,
// which may be stored in a variable and used as a parent by other advancement builders.
            builder.save(saver, ResourceLocation.fromNamespaceAndPath(Main.MODID, "unlimitedpower"), existingFileHelper);
        }
    }
}