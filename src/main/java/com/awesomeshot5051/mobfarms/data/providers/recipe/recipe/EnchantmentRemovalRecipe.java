package com.awesomeshot5051.mobfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.network.*;
import net.minecraft.network.codec.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.items.ModItems.*;


public class EnchantmentRemovalRecipe extends ShapelessRecipe {

    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;
    private final boolean isSimple;
    private ItemContainerContents swordContents;
    private ItemStack result2;

    public EnchantmentRemovalRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
    }

    public static final List<ItemStack> ALL_FARMS = List.of(
            // Passive Mobs
            CHICKEN_FARM.get().getDefaultInstance(),
            COD_FARM.get().getDefaultInstance(),
            COW_FARM.get().getDefaultInstance(),
            GLOW_SQUID_FARM.get().getDefaultInstance(),
            HORSE_FARM.get().getDefaultInstance(),
            MOOSHROOM_FARM.get().getDefaultInstance(),
            PARROT_FARM.get().getDefaultInstance(),
            PIG_FARM.get().getDefaultInstance(),
            PUFFERFISH_FARM.get().getDefaultInstance(),
            RABBIT_FARM.get().getDefaultInstance(),
            SALMON_FARM.get().getDefaultInstance(),
            SHEEP_FARM.get().getDefaultInstance(),
            SNOW_GOLEM_FARM.get().getDefaultInstance(),
            SQUID_FARM.get().getDefaultInstance(),
            STRIDER_FARM.get().getDefaultInstance(),
            TROPICAL_FISH_FARM.get().getDefaultInstance(),
            TURTLE_FARM.get().getDefaultInstance(),

            // Neutral Mobs
            ENDERMAN_FARM.get().getDefaultInstance(),
            GOAT_FARM.get().getDefaultInstance(),
            IRON_FARM.get().getDefaultInstance(),
            SPIDER_FARM.get().getDefaultInstance(),
            PIGLIN_FARM.get().getDefaultInstance(),
            ZOMBIFIED_PIGLIN_FARM.get().getDefaultInstance(),

            // Aggressive Mobs
            BLAZE_FARM.get().getDefaultInstance(),
            CREEPER_FARM.get().getDefaultInstance(),
            DROWNED_FARM.get().getDefaultInstance(),
            ELDER_GUARDIAN_FARM.get().getDefaultInstance(),
            EVOKER_FARM.get().getDefaultInstance(),
            GHAST_FARM.get().getDefaultInstance(),
            GUARDIAN_FARM.get().getDefaultInstance(),
            HOGLIN_FARM.get().getDefaultInstance(),
            ILLUSIONER_FARM.get().getDefaultInstance(),
            MAGMA_CUBE_FARM.get().getDefaultInstance(),
            PHANTOM_FARM.get().getDefaultInstance(),
            PILLAGER_FARM.get().getDefaultInstance(),
            RAVAGER_FARM.get().getDefaultInstance(),
            SHULKER_FARM.get().getDefaultInstance(),
            SKELETON_FARM.get().getDefaultInstance(),
            SLIME_FARM.get().getDefaultInstance(),
            VINDICATOR_FARM.get().getDefaultInstance(),
            WARDEN_FARM.get().getDefaultInstance(),
            WITCH_FARM.get().getDefaultInstance(),
            WITHER_SKELETON_FARM.get().getDefaultInstance(),
            WITHER_FARM.get().getDefaultInstance(),
            ZOGLIN_FARM.get().getDefaultInstance(),
            ZOMBIE_FARM.get().getDefaultInstance()
    );
    ItemStack farm;

    @Override
    public @NotNull RecipeSerializer<EnchantmentRemovalRecipe> getSerializer() {
        return ModRecipes.ENCHANTMENT_REMOVER_SERIALIZER.get();
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput input, HolderLookup.@NotNull Provider registries) {
        if (ALL_FARMS.contains(input.items().getFirst())) {
            farm = input.items().getFirst().getItem().getDefaultInstance();
            farm.remove(DataComponents.STORED_ENCHANTMENTS);
            ItemContainerContents swordContents = farm.getOrDefault(ModDataComponents.SWORD_TYPE, ItemContainerContents.EMPTY);
            swordContents.getStackInSlot(0).remove(DataComponents.ENCHANTMENTS);
            farm.set(ModDataComponents.SWORD_TYPE, swordContents);
        }
        return farm;
    }

    public static class Serializer implements RecipeSerializer<EnchantmentRemovalRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, EnchantmentRemovalRecipe> STREAM_CODEC = StreamCodec.of(EnchantmentRemovalRecipe.Serializer::toNetwork, EnchantmentRemovalRecipe.Serializer::fromNetwork);
        private static final MapCodec<EnchantmentRemovalRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340779_) -> p_340779_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_301127_) -> p_301127_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_301133_) -> p_301133_.category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_301142_) -> p_301142_.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((p_301021_) -> {
            Ingredient[] aingredient = p_301021_.toArray(Ingredient[]::new);
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter((p_300975_) -> p_300975_.ingredients)).apply(p_340779_, EnchantmentRemovalRecipe::new));

        public Serializer() {
        }

        private static EnchantmentRemovalRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            nonnulllist.replaceAll((p_319735_) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new EnchantmentRemovalRecipe(s, craftingbookcategory, itemstack, nonnulllist);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, EnchantmentRemovalRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());

            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

        public MapCodec<EnchantmentRemovalRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, EnchantmentRemovalRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }


}
