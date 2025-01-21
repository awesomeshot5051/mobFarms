package com.awesomeshot5051.mobfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.datacomponents.ModDataComponents;
import com.awesomeshot5051.mobfarms.enums.SwordType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class UpgradeRecipe extends ShapedRecipe {
    public static final DataComponentType<ItemContainerContents> swordTypeComponent = ModDataComponents.SWORD_TYPE.get();

    public final ShapedRecipePattern pattern;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;
    final ItemStack result;
    List<Item> shovelFarms = new ArrayList<>(List.of(

    ));

    private ItemContainerContents swordContents;
    private ItemStack result2;

    public UpgradeRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification) {
        super(group, category, pattern, result, showNotification);
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.result2 = result;
        this.showNotification = showNotification;
    }

    public UpgradeRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result) {
        this(group, category, pattern, result, true);
    }

    public static List<Item> getPlanks() {

        // Retrieve all items in the "planks" tag
        return BuiltInRegistries.ITEM.getTag(ItemTags.PLANKS)
                .stream()
                .flatMap(holderSet -> holderSet.stream().map(Holder::value))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeSerializer<UpgradeRecipe> getSerializer() {
        return ModRecipes.UPGRADE_SERIALIZER.get();
    }

    public boolean matches(CraftingInput input, Level level) {
        return this.pattern.matches(input);
    }

    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, result.getDescriptionId());
    }

    private boolean areAllModifiersEqual(List<ItemStack> modifier) {
        return modifier.size() == 4
                && modifier.get(0).toString().equals(modifier.get(1).toString())
                && modifier.get(0).toString().equals(modifier.get(2).toString())
                && modifier.get(0).toString().equals(modifier.get(3).toString());
    }

    public static Map<Ingredient, Item> materialToSwordMap = Map.of(
            Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS), Items.WOODEN_SWORD,
            Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE), Items.STONE_SWORD,
            Ingredient.of(Items.IRON_INGOT), Items.IRON_SWORD,
            Ingredient.of(Items.GOLD_INGOT), Items.GOLDEN_SWORD,
            Ingredient.of(Items.DIAMOND), Items.DIAMOND_SWORD,
            Ingredient.of(Items.NETHERITE_INGOT), Items.NETHERITE_SWORD
    );

    @Override
    public @NotNull ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider registries) {
        ItemEnchantments itemenchantments = ItemEnchantments.EMPTY;
        List<ItemStack> modifer = new ArrayList<>(List.of(craftingInput.getItem(1), craftingInput.getItem(3), craftingInput.getItem(5), craftingInput.getItem(7)));
        if (areAllModifiersEqual(modifer)) {
            List<ItemStack> itemStacks = new ArrayList<>();
            ItemStack swordStack;

            if (craftingInput.getItem(4).get(ModDataComponents.SWORD_TYPE) != null) {
                swordStack = Objects.requireNonNull(craftingInput.getItem(4).get(ModDataComponents.SWORD_TYPE)).copyOne();
            } else {
                swordStack = new ItemStack(Items.STONE_SWORD);
            }
            if (isHigherSwordType(swordStack, modifer.getFirst())) {
                itemStacks.add(getResultItem(registries));
                for (Map.Entry<Ingredient, Item> entry : materialToSwordMap.entrySet()) {
                    if (entry.getKey().test(modifer.getFirst())) {
                        // Convert the modifier into its corresponding SWORD
                        itemenchantments = swordStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
                        swordStack = new ItemStack(entry.getValue());
                        swordStack.set(DataComponents.ENCHANTMENTS, itemenchantments);
                        break; // Break since we found the corresponding SWORD
                    }
                }
                // Set the pick type in the result item's data
                swordContents = ItemContainerContents.fromItems(Collections.singletonList(swordStack));
                result2 = getResultItem(registries).copy();
                result2.set(swordTypeComponent, swordContents);
                result2.set(DataComponents.STORED_ENCHANTMENTS, itemenchantments);// Copy the result item to avoid modifying the original
            } else {
                return new ItemStack(Items.AIR);
            }
        }

        super.assemble(craftingInput, registries);
        return result2;
    }

    public static Map<Item, Ingredient> SwordToMaterialMap = Map.of(
            Items.WOODEN_SWORD, Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
                    Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS,
                    Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS),
            Items.GOLDEN_SWORD, Ingredient.of(Items.GOLD_INGOT),
            Items.STONE_SWORD, Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE),
            Items.IRON_SWORD, Ingredient.of(Items.IRON_INGOT),
            Items.DIAMOND_SWORD, Ingredient.of(Items.DIAMOND),
            Items.NETHERITE_SWORD, Ingredient.of(Items.NETHERITE_INGOT)
    );

    private boolean isHigherSwordType(ItemStack baseSwordType, ItemStack modifierSwordType) {

//
//        // Convert baseSwordType and modifierSwordType to their corresponding materials
//        Item baseSwordItem = baseSwordType.getItem();
//
//        Item baseMaterialType = null;
        Item modifierMaterialType = null;
//
//        // Find the materials corresponding to the SWORD items
        for (Map.Entry<Item, Ingredient> entry : SwordToMaterialMap.entrySet()) {
//            if (entry.getKey().equals(baseSwordType.getItem())) {
//                baseMaterialType = entry.getKey();
//            }
            if (entry.getValue().test(modifierSwordType)) {
                modifierMaterialType = entry.getKey();
            }
        }
//
//        // Ensure both types were mapped to a valid SWORD
        if (/*baseMaterialType == null*/modifierMaterialType == null) {
            return false; // Invalid types, cannot compare
        }
        modifierSwordType = modifierMaterialType.getDefaultInstance();
//        // Compare indices in the hierarchy
//        int baseIndex = swordTypeHierarchy.indexOf(baseMaterialType);
//        int modifierIndex = swordTypeHierarchy.indexOf(modifierMaterialType);
//
//        // Return true if the modifier type is higher in the hierarchy
//        return modifierIndex > baseIndex;
        return SwordType.getSwordRank(modifierSwordType.getItem()) > SwordType.getSwordRank(baseSwordType.getItem());
    }


    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= this.pattern.width() && height >= this.pattern.height();
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider provider) {
        return this.result;
    }


    public ItemStack getResult() {
        return result;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return super.getType();
    }

    @Override
    public CraftingBookCategory category() {
        return category;
    }

//    @Override
//    public boolean isSpecial() {
//        return true;
//    }


    public static class Serializer implements RecipeSerializer<UpgradeRecipe> {
        public static final MapCodec<UpgradeRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340778_) -> p_340778_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_311729_) -> p_311729_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_311732_) -> p_311732_.category), ShapedRecipePattern.MAP_CODEC.forGetter((p_311733_) -> p_311733_.pattern), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_311730_) -> p_311730_.result), Codec.BOOL.optionalFieldOf("show_notification", true).forGetter((p_311731_) -> p_311731_.showNotification)).apply(p_340778_, UpgradeRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, UpgradeRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        public Serializer() {
        }

        private static UpgradeRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            ShapedRecipePattern UpgradeRecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            boolean flag = buffer.readBoolean();
            return new UpgradeRecipe(s, craftingbookcategory, UpgradeRecipepattern, itemstack, flag);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, UpgradeRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            buffer.writeBoolean(recipe.showNotification);
        }

        public MapCodec<UpgradeRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, UpgradeRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }


}