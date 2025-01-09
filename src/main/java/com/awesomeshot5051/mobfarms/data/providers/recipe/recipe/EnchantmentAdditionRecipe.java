package com.awesomeshot5051.mobfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.awesomeshot5051.mobfarms.items.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.core.registries.*;
import net.minecraft.network.*;
import net.minecraft.network.codec.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.data.providers.recipe.recipe.CustomShapedRecipe.*;

public class EnchantmentAdditionRecipe extends ShapelessRecipe {
    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;
    private final boolean isSimple;
    private ItemContainerContents swordContents;
    private ItemStack result2;

    public EnchantmentAdditionRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
    }

    @Override
    public RecipeSerializer<EnchantmentAdditionRecipe> getSerializer() {
        return ModRecipes.ENCHANTING_SERIALIZER.get();
    }


    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public boolean matches(CraftingInput input, Level level) {
        return super.matches(input, level);
    }


    public ItemStack assemble(CraftingInput input, HolderLookup.@NotNull Provider registries) {
        List<ItemStack> ingredients = input.items(); // Ingredients from the crafting input
        ItemStack resultItem = ItemStack.EMPTY;      // Default result
        List<Item> farmBlocks = new ArrayList<>();
        ItemEnchantments enchantments = ItemEnchantments.EMPTY;
        ItemEnchantments.Mutable storedEnchantments = new ItemEnchantments.Mutable(enchantments);
        for (var sidedBlock : ModItems.ITEM_REGISTER.getEntries()) {
            farmBlocks.add(sidedBlock.get());
        }

        ItemContainerContents swordContents = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_SWORD)));   // Placeholder for pick contents
        // Check the first and last ingredients for the SWORD_TYPE component
        for (ItemStack ingredient : ingredients) {
            if (farmBlocks.contains(ingredient.getItem())) {
                swordContents = ItemContainerContents.fromItems(Collections.singletonList(Objects.requireNonNull(ingredient.getOrDefault(ModDataComponents.SWORD_TYPE, swordContents)).copyOne()));
            } else if (ingredient.getItem().getDefaultInstance().has(DataComponents.STORED_ENCHANTMENTS)) {
                storedEnchantments = new ItemEnchantments.Mutable(ingredient.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY));
            }
            if (ingredient.getItem().getDefaultInstance().getTags().toList().contains(ItemTags.SWORD_ENCHANTABLE)) {
                storedEnchantments = new ItemEnchantments.Mutable(ingredient.getOrDefault(DataComponents.STORED_ENCHANTMENTS, ItemEnchantments.EMPTY));
            }

        }

        HolderLookup<Item> itemLookup = registries.lookup(Registries.ITEM).orElseThrow();
        HolderSet.Named<Item> swordEnchantables = itemLookup.get(ItemTags.SWORD_ENCHANTABLE).orElseThrow();

        // Retrieve the ItemStack (e.g., from swordContents)
        ItemStack swordStack = swordContents.getStackInSlot(0);
        ItemEnchantments enchantments2 = swordStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        Holder<Enchantment> holder = storedEnchantments.keySet().stream().toList().getFirst();
        boolean isCompatible = checkEnchantmentCompatibility(storedEnchantments.toImmutable(), swordEnchantables, swordStack) && isCompatible(storedEnchantments, swordStack);

        if (!isCompatible) {
            return new ItemStack(Items.AIR);
        }
        swordStack.enchant(holder, storedEnchantments.getLevel(holder));
        enchantments2 = swordStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
//        Holder<Enchantment> holder = enchantments2.keySet().stream().toList().getFirst();
//        storedEnchantments.keySet().add(holder);
        resultItem = getResultItem(registries).copy();
        swordStack.set(DataComponents.ENCHANTMENTS, enchantments2);
        swordContents = ItemContainerContents.fromItems(Collections.singletonList(swordStack));
        resultItem.set(DataComponents.STORED_ENCHANTMENTS, enchantments2);
        resultItem.set(swordTypeComponent, swordContents);
        return resultItem;
    }

    private boolean isCompatible(ItemEnchantments.Mutable storedEnchantments, ItemStack swordStack) {
        if (storedEnchantments.keySet().stream().toList().getFirst().getDelegate().value().definition().supportedItems().unwrapKey().stream().findFirst().isPresent()) {
            return storedEnchantments.keySet().stream().toList().getFirst().getDelegate().value().definition().supportedItems().unwrapKey().stream().findFirst().get().equals(ItemTags.SWORD_ENCHANTABLE) || storedEnchantments.keySet().stream().toList().getFirst().getDelegate().is(EnchantmentTags.DAMAGE_EXCLUSIVE) || storedEnchantments.keySet().stream().toList().getFirst().getDelegate().value().definition().supportedItems().stream().toList().contains(swordStack.getItemHolder());
        }
        return false;
    }

    /**
     * Checks if the enchantments in the enchanted book are compatible with swords.
     */
    private boolean checkEnchantmentCompatibility(ItemEnchantments enchantments, HolderSet.Named<Item> swordEnchantables, ItemStack sword) {
        for (var enchantmentEntry : enchantments.entrySet()) {
            Holder<Enchantment> enchantmentHolder = enchantmentEntry.getKey();

            // Check if the enchantment is valid for the SWORD_ENCHANTABLES tag
            boolean isValid = swordEnchantables.stream().anyMatch(itemHolder -> {
                // Get the item and check if the enchantment is applicable
                return enchantmentHolder.unwrap().map(enchantment -> EnchantmentHelper.canStoreEnchantments(sword), holder -> false);
            });

            if (!isValid) {
                return false; // Incompatible enchantment found
            }
        }

        return true; // All enchantments are compatible
    }


    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }

    @Override
    public RecipeType<?> getType() {
        return super.getType();
    }

    @Override
    public CraftingBookCategory category() {
        return category;
    }

    public static class Serializer implements RecipeSerializer<EnchantmentAdditionRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, EnchantmentAdditionRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        private static final MapCodec<EnchantmentAdditionRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340779_) -> p_340779_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_301127_) -> p_301127_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_301133_) -> p_301133_.category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_301142_) -> p_301142_.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((p_301021_) -> {
            Ingredient[] aingredient = p_301021_.toArray(Ingredient[]::new);
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter((p_300975_) -> p_300975_.ingredients)).apply(p_340779_, EnchantmentAdditionRecipe::new));

        public Serializer() {
        }

        private static EnchantmentAdditionRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            nonnulllist.replaceAll((p_319735_) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new EnchantmentAdditionRecipe(s, craftingbookcategory, itemstack, nonnulllist);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, EnchantmentAdditionRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());

            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

        public MapCodec<EnchantmentAdditionRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, EnchantmentAdditionRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
