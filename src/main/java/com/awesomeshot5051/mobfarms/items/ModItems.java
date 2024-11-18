package com.awesomeshot5051.mobfarms.items;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerBlockEntityData;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    private static final DeferredRegister.Items ITEM_REGISTER = DeferredRegister.createItems(Main.MODID);
    //    public static final DeferredHolder<Item, BlockItem> INCUBATOR = ITEM_REGISTER.registerSimpleBlockItem("incubator", () -> ModBlocks.INCUBATOR);
    public static final DeferredHolder<Item, BlockItem> INVENTORY_VIEWER = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.INVENTORY_VIEWER);
    //passive mobs
    public static final DeferredHolder<Item, BlockItem> CHICKEN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CHICKEN_FARM);
    public static final DeferredHolder<Item, BlockItem> COD_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.COD_FARM);
    public static final DeferredHolder<Item, BlockItem> COW_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.COW_FARM);
    public static final DeferredHolder<Item, BlockItem> GLOW_SQUID_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.GLOW_SQUID_FARM);
    public static final DeferredHolder<Item, BlockItem> HORSE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.HORSE_FARM);
    public static final DeferredHolder<Item, BlockItem> MOOSHROOM_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.MOOSHROOM_FARM);
    public static final DeferredHolder<Item, BlockItem> PARROT_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PARROT_FARM);
    public static final DeferredHolder<Item, BlockItem> PIG_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PIG_FARM);
    public static final DeferredHolder<Item, BlockItem> PUFFERFISH_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PUFFERFISH_FARM);
    public static final DeferredHolder<Item, BlockItem> RABBIT_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.RABBIT_FARM);
    public static final DeferredHolder<Item, BlockItem> SALMON_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SALMON_FARM);
    public static final DeferredHolder<Item, BlockItem> SHEEP_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SHEEP_FARM);
    public static final DeferredHolder<Item, BlockItem> SNOW_GOLEM_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SNOW_GOLEM_FARM);
    public static final DeferredHolder<Item, BlockItem> SQUID_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SQUID_FARM);
    public static final DeferredHolder<Item, BlockItem> STRIDER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.STRIDER_FARM);
    public static final DeferredHolder<Item, BlockItem> TROPICAL_FISH_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.TROPICAL_FISH_FARM);
    public static final DeferredHolder<Item, BlockItem> TURTLE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.TURTLE_FARM);
    //neutral mobs
    public static final DeferredHolder<Item, BlockItem> SPIDER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SPIDER_FARM);
    public static final DeferredHolder<Item, BlockItem> ENDERMAN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ENDERMAN_FARM);
    public static final DeferredHolder<Item, BlockItem> GOAT_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.GOAT_FARM);
    public static final DeferredHolder<Item, BlockItem> IRON_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.IRON_FARM);
    public static final DeferredHolder<Item, BlockItem> PIGLIN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PIGLIN_FARM);
    public static final DeferredHolder<Item, BlockItem> ZOMBIFIED_PIGLIN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ZOMBIFIED_PIGLIN_FARM);
    //aggressive mobs
    public static final DeferredHolder<Item, BlockItem> BLAZE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.BLAZE_FARM);
    public static final DeferredHolder<Item, BlockItem> CREAKING_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CREAKING_FARM);
    public static final DeferredHolder<Item, BlockItem> CREEPER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CREEPER_FARM);
    public static final DeferredHolder<Item, BlockItem> DROWNED_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.DROWNED_FARM);
    public static final DeferredHolder<Item, BlockItem> ELDER_GUARDIAN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ELDER_GUARDIAN_FARM);
    public static final DeferredHolder<Item, BlockItem> EVOKER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.EVOKER_FARM);
    public static final DeferredHolder<Item, BlockItem> GHAST_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.GHAST_FARM);
    public static final DeferredHolder<Item, BlockItem> GUARDIAN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.GUARDIAN_FARM);
    public static final DeferredHolder<Item, BlockItem> HOGLIN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.HOGLIN_FARM);
    public static final DeferredHolder<Item, BlockItem> ILLUSIONER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ILLUSIONER_FARM);
    public static final DeferredHolder<Item, BlockItem> MAGMA_CUBE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.MAGMA_CUBE_FARM);
    public static final DeferredHolder<Item, BlockItem> PHANTOM_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PHANTOM_FARM);
    public static final DeferredHolder<Item, BlockItem> PILLAGER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PILLAGER_FARM);
    public static final DeferredHolder<Item, BlockItem> RAVAGER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.RAVAGER_FARM);
    public static final DeferredHolder<Item, BlockItem> SHULKER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SHULKER_FARM);
    public static final DeferredHolder<Item, BlockItem> SKELETON_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SKELETON_FARM);
    public static final DeferredHolder<Item, BlockItem> SLIME_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SLIME_FARM);
    public static final DeferredHolder<Item, BlockItem> VINDICATOR_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.VINDICATOR_FARM);
    public static final DeferredHolder<Item, BlockItem> WARDEN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WARDEN_FARM);
    public static final DeferredHolder<Item, BlockItem> WITCH_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WITCH_FARM);
    public static final DeferredHolder<Item, BlockItem> WITHER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WITHER_FARM);
    public static final DeferredHolder<Item, BlockItem> WITHER_SKELETON_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WITHER_SKELETON_FARM);
    public static final DeferredHolder<Item, BlockItem> ZOGLIN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ZOGLIN_FARM);
    public static final DeferredHolder<Item, BlockItem> ZOMBIE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ZOMBIE_FARM);
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerData>> VILLAGER_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("villager", () -> DataComponentType.<VillagerData>builder().persistent(VillagerData.CODEC).networkSynchronized(VillagerData.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerBlockEntityData>> BLOCK_ENTITY_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("block_entity", () -> DataComponentType.<VillagerBlockEntityData>builder().networkSynchronized(VillagerBlockEntityData.STREAM_CODEC).build());

    public static void init(IEventBus eventBus) {
        ITEM_REGISTER.register(eventBus);
        DATA_COMPONENT_TYPE_REGISTER.register(eventBus);
    }

}
