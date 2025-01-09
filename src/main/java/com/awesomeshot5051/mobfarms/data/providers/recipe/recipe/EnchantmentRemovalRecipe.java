package com.awesomeshot5051.mobfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.awesomeshot5051.mobfarms.items.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.network.*;
import net.minecraft.network.codec.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static com.awesomeshot5051.mobfarms.blocks.ModBlocks.*;


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

    public static final List<DeferredHolder<Block, ?>> ALL_FARMS = List.of(
            // Passive Mobs
            CHICKEN_FARM,
            COD_FARM,
            COW_FARM,
            GLOW_SQUID_FARM,
            HORSE_FARM,
            MOOSHROOM_FARM,
            PARROT_FARM,
            PIG_FARM,
            PUFFERFISH_FARM,
            RABBIT_FARM,
            SALMON_FARM,
            SHEEP_FARM,
            SNOW_GOLEM_FARM,
            SQUID_FARM,
            STRIDER_FARM,
            TROPICAL_FISH_FARM,
            TURTLE_FARM,

            // Neutral Mobs
            ENDERMAN_FARM,
            GOAT_FARM,
            IRON_FARM,
            SPIDER_FARM,
            PIGLIN_FARM,
            ZOMBIFIED_PIGLIN_FARM,

            // Aggressive Mobs
            BLAZE_FARM,
            CREEPER_FARM,
            DROWNED_FARM,
            ELDER_GUARDIAN_FARM,
            EVOKER_FARM,
            GHAST_FARM,
            GUARDIAN_FARM,
            HOGLIN_FARM,
            ILLUSIONER_FARM,
            MAGMA_CUBE_FARM,
            PHANTOM_FARM,
            PILLAGER_FARM,
            RAVAGER_FARM,
            SHULKER_FARM,
            SKELETON_FARM,
            SLIME_FARM,
            VINDICATOR_FARM,
            WARDEN_FARM,
            WITCH_FARM,
            WITHER_SKELETON_FARM,
            WITHER_FARM,
            ZOGLIN_FARM,
            ZOMBIE_FARM
    );
    ItemStack farm;

    @Override
    public @NotNull RecipeSerializer<EnchantmentRemovalRecipe> getSerializer() {
        return ModRecipes.ENCHANTMENT_REMOVER_SERIALIZER.get();
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput input, HolderLookup.@NotNull Provider registries) {

        List<Item> farmBlocks = new ArrayList<>();
        ItemEnchantments enchantments = ItemEnchantments.EMPTY;
        ItemEnchantments.Mutable storedEnchantments = new ItemEnchantments.Mutable(enchantments);
        for (var sidedBlock : ModItems.ITEM_REGISTER.getEntries()) {
            farmBlocks.add(sidedBlock.get());
        }
        List<ItemStack> ingredient = input.items();
        ItemContainerContents swordContents = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_SWORD)));   // Placeholder for pick contents
        // Check the first and last ingredients for the SWORD_TYPE component
        ItemStack farm = new ItemStack(Items.AIR);
        for (ItemStack ingrnt : ingredient) {
            if (farmBlocks.contains(ingrnt.getItem())) {
                swordContents = ItemContainerContents.fromItems(Collections.singletonList(Objects.requireNonNull(ingrnt.getOrDefault(ModDataComponents.SWORD_TYPE, swordContents)).copyOne()));
                farm = ingrnt.getItem().getDefaultInstance();
                farm.remove(DataComponents.STORED_ENCHANTMENTS);
                ItemStack sword = swordContents.getStackInSlot(0);
                sword.remove(DataComponents.ENCHANTMENTS);
                swordContents = ItemContainerContents.fromItems(Collections.singletonList(sword));
                farm.set(ModDataComponents.SWORD_TYPE, swordContents);
            }

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
