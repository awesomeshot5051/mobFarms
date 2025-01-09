package com.awesomeshot5051.mobfarms.data.providers.recipe.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class EnchantmentAdditionRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final int count;
    private final ItemStack resultStack;
    private final NonNullList<Ingredient> ingredients;
    private final Map<String, Criterion<?>> criteria;

    @Nullable
    private String group;

    public EnchantmentAdditionRecipeBuilder(RecipeCategory category, ItemLike result, int count) {
        this(category, new ItemStack(result, count));
    }

    public EnchantmentAdditionRecipeBuilder(RecipeCategory p_250837_, ItemStack result) {
//        super(p_250837_, result);
        this.ingredients = NonNullList.create();
        this.criteria = new LinkedHashMap<>();
        this.category = p_250837_;
        this.result = result.getItem();
        this.count = result.getCount();
        this.resultStack = result;
    }

    public static EnchantmentAdditionRecipeBuilder shapeless(RecipeCategory category, ItemLike result) {
        return shapeless(category, result, 1);
    }

    public static EnchantmentAdditionRecipeBuilder shapeless(RecipeCategory category, ItemLike result, int count) {
        return new EnchantmentAdditionRecipeBuilder(category, result, count);
    }

    public static EnchantmentAdditionRecipeBuilder shapeless(RecipeCategory p_252339_, ItemStack result) {
        return new EnchantmentAdditionRecipeBuilder(p_252339_, result);
    }


    public EnchantmentAdditionRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }


    public EnchantmentAdditionRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    public EnchantmentAdditionRecipeBuilder requires(ItemLike item, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.requires(Ingredient.of(item));
        }

        return this;
    }

//    public EnchantmentAdditionRecipeBuilder contains(Ingredient ingredient) {
//
//    }

    public EnchantmentAdditionRecipeBuilder requires(Ingredient ingredient) {
        return this.requires(ingredient, 1);
    }

    public EnchantmentAdditionRecipeBuilder requires(Ingredient ingredient, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredient);
        }

        return this;
    }

    @Override
    public EnchantmentAdditionRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public EnchantmentAdditionRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        this.ensureValid(id);
        Advancement.Builder advancement$builder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(advancement$builder);
        this.criteria.forEach(advancement$builder::addCriterion);
        EnchantmentAdditionRecipe shapelessrecipe = new EnchantmentAdditionRecipe(Objects.requireNonNullElse(this.group, ""), RecipeBuilder.determineBookCategory(this.category), this.resultStack, this.ingredients);
        recipeOutput.accept(id, shapelessrecipe, advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));

    }

    private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }
}
