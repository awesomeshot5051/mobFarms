package com.awesomeshot5051.mobfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.mobfarms.*;
import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.network.*;
import net.minecraft.network.codec.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class CustomShapedRecipe extends ShapedRecipe {
    public static final DataComponentType<ItemContainerContents> swordTypeComponent = ModDataComponents.SWORD_TYPE.get();

    public final ShapedRecipePattern pattern;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;
    final ItemStack result;
    private ItemContainerContents swordContents;
    private ItemStack result2;

    public CustomShapedRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification) {
        super(group, category, pattern, result, showNotification);
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.result2 = result;
        this.showNotification = showNotification;
    }

    public CustomShapedRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result) {
        this(group, category, pattern, result, true);
    }

    @Override
    public RecipeSerializer<CustomShapedRecipe> getSerializer() {
        return ModRecipes.SHAPED_SERIALIZER.get();
    }

    public boolean matches(CraftingInput input, Level level) {
        return this.pattern.matches(input);
    }

    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, result.getDescriptionId());
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider registries) {
        ItemStack swordStack = craftingInput.getItem(4);
        ItemEnchantments enchantments = swordStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
//        ItemStack oreStack = craftingInput.getItem(7);
        List<ItemStack> itemStacks = new ArrayList<>();
        itemStacks.add(getResultItem(registries));
        // Set the pick type in the result item's data
        swordContents = ItemContainerContents.fromItems(Collections.singletonList(swordStack));
//            BlockRendererBase.setPickaxeType(Block.byItem(result.getItem().getDefaultInstance().getItem()), swordStack);
        result2 = getResultItem(registries).copy(); // Copy the result item to avoid modifying the original
        if (craftingInput.getItem(4).isEnchanted()) {
            Main.LOGGER.info("The sword has an enchantment of {}", craftingInput.getItem(4).getTagEnchantments());
        }
        //            NonNullList<ItemStack> p_00115 = NonNullList.withSize(1, swordStack);
//            ContainerHelper.saveAllItems(new CompoundTag(), p_00115, registries);
//            PickTypeData.getOrCreate(result);
        result2.set(swordTypeComponent, swordContents);
        result2.set(DataComponents.STORED_ENCHANTMENTS,enchantments);
//        result.set(ModDataComponents.SWORD_TYPE, swordContents);

//        Main.LOGGER.debug("The pick type is...: {}", Objects.requireNonNull(result.get(ModDataComponents.SWORD_TYPE)).getStackInSlot(0));
        super.assemble(craftingInput, registries);
        return result2;
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


    public static class Serializer implements RecipeSerializer<CustomShapedRecipe> {
        public static final MapCodec<CustomShapedRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340778_) -> p_340778_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_311729_) -> p_311729_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_311732_) -> p_311732_.category), ShapedRecipePattern.MAP_CODEC.forGetter((p_311733_) -> p_311733_.pattern), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_311730_) -> p_311730_.result), Codec.BOOL.optionalFieldOf("show_notification", true).forGetter((p_311731_) -> p_311731_.showNotification)).apply(p_340778_, CustomShapedRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, CustomShapedRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        public Serializer() {
        }

        private static CustomShapedRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            ShapedRecipePattern customBlockRecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            boolean flag = buffer.readBoolean();
            return new CustomShapedRecipe(s, craftingbookcategory, customBlockRecipepattern, itemstack, flag);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, CustomShapedRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            buffer.writeBoolean(recipe.showNotification);
        }

        public MapCodec<CustomShapedRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, CustomShapedRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }


}