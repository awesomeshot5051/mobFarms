package com.awesomeshot5051.mobfarms.items;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerBlockEntityData;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(BuiltInRegistries.ITEM, Main.MODID);

//    public static final DeferredHolder<Item, Item> INCUBATOR = ITEM_REGISTER.register("incubator", () -> ModBlocks.INCUBATOR.get().toItem());
    public static final DeferredHolder<Item, Item> INVENTORY_VIEWER = ITEM_REGISTER.register("inventory_viewer", () -> ModBlocks.INVENTORY_VIEWER.get().toItem());


    //passive mobs
    public static final DeferredHolder<Item, Item> CHICKEN_FARM = ITEM_REGISTER.register("chicken_farm", () -> ModBlocks.CHICKEN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> COD_FARM = ITEM_REGISTER.register("cod_farm", () -> ModBlocks.COD_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> COW_FARM = ITEM_REGISTER.register("cow_farm", () -> ModBlocks.COW_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> GLOW_SQUID_FARM = ITEM_REGISTER.register("glow_squid_farm", () -> ModBlocks.GLOW_SQUID_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> HORSE_FARM = ITEM_REGISTER.register("horse_farm", () -> ModBlocks.HORSE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> MOOSHROOM_FARM = ITEM_REGISTER.register("mooshroom_farm", () -> ModBlocks.MOOSHROOM_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PARROT_FARM = ITEM_REGISTER.register("parrot_farm", () -> ModBlocks.PARROT_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PIG_FARM = ITEM_REGISTER.register("pig_farm", () -> ModBlocks.PIG_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PUFFERFISH_FARM = ITEM_REGISTER.register("pufferfish_farm", () -> ModBlocks.PUFFERFISH_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> RABBIT_FARM = ITEM_REGISTER.register("rabbit_farm", () -> ModBlocks.RABBIT_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SALMON_FARM = ITEM_REGISTER.register("salmon_farm", () -> ModBlocks.SALMON_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SHEEP_FARM = ITEM_REGISTER.register("sheep_farm", () -> ModBlocks.SHEEP_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SNOW_GOLEM_FARM = ITEM_REGISTER.register("snow_golem_farm", () -> ModBlocks.SNOW_GOLEM_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SQUID_FARM = ITEM_REGISTER.register("squid_farm", () -> ModBlocks.SQUID_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> STRIDER_FARM = ITEM_REGISTER.register("strider_farm", () -> ModBlocks.STRIDER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> TROPICAL_FISH_FARM = ITEM_REGISTER.register("tropical_fish_farm", () -> ModBlocks.TROPICAL_FISH_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> TURTLE_FARM = ITEM_REGISTER.register("turtle_farm", () -> ModBlocks.TURTLE_FARM.get().toItem());

    //neutral mobs
    public static final DeferredHolder<Item, Item> SPIDER_FARM = ITEM_REGISTER.register("spider_farm", () -> ModBlocks.SPIDER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ENDERMAN_FARM = ITEM_REGISTER.register("enderman_farm", () -> ModBlocks.ENDERMAN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> GOAT_FARM = ITEM_REGISTER.register("goat_farm", () -> ModBlocks.GOAT_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> IRON_FARM = ITEM_REGISTER.register("iron_farm", () -> ModBlocks.IRON_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PIGLIN_FARM = ITEM_REGISTER.register("piglin_farm", () -> ModBlocks.PIGLIN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ZOMBIFIED_PIGLIN_FARM = ITEM_REGISTER.register("zombified_piglin_farm", () -> ModBlocks.ZOMBIFIED_PIGLIN_FARM.get().toItem());


    //aggressive mobs
    public static final DeferredHolder<Item, Item> BLAZE_FARM = ITEM_REGISTER.register("blaze_farm", () -> ModBlocks.BLAZE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> CREEPER_FARM = ITEM_REGISTER.register("creeper_farm", () -> ModBlocks.CREEPER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> DROWNED_FARM = ITEM_REGISTER.register("drowned_farm", () -> ModBlocks.DROWNED_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ELDER_GUARDIAN_FARM = ITEM_REGISTER.register("elder_guardian_farm", () -> ModBlocks.ELDER_GUARDIAN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> EVOKER_FARM = ITEM_REGISTER.register("evoker_farm", () -> ModBlocks.EVOKER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> GHAST_FARM = ITEM_REGISTER.register("ghast_farm", () -> ModBlocks.GHAST_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> GUARDIAN_FARM = ITEM_REGISTER.register("guardian_farm", () -> ModBlocks.GUARDIAN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> HOGLIN_FARM = ITEM_REGISTER.register("hoglin_farm", () -> ModBlocks.HOGLIN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ILLUSIONER_FARM = ITEM_REGISTER.register("illusioner_farm", () -> ModBlocks.ILLUSIONER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> MAGMA_CUBE_FARM = ITEM_REGISTER.register("magma_cube_farm", () -> ModBlocks.MAGMA_CUBE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PHANTOM_FARM = ITEM_REGISTER.register("phantom_farm", () -> ModBlocks.PHANTOM_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PILLAGER_FARM = ITEM_REGISTER.register("pillager_farm", () -> ModBlocks.PILLAGER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> RAVAGER_FARM = ITEM_REGISTER.register("ravager_farm", () -> ModBlocks.RAVAGER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SHULKER_FARM = ITEM_REGISTER.register("shulker_farm", () -> ModBlocks.SHULKER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SKELETON_FARM = ITEM_REGISTER.register("skeleton_farm", () -> ModBlocks.SKELETON_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SLIME_FARM = ITEM_REGISTER.register("slime_farm", () -> ModBlocks.SLIME_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> VINDICATOR_FARM = ITEM_REGISTER.register("vindicator_farm", () -> ModBlocks.VINDICATOR_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> WARDEN_FARM = ITEM_REGISTER.register("warden_farm", () -> ModBlocks.WARDEN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> WITCH_FARM = ITEM_REGISTER.register("witch_farm", () -> ModBlocks.WITCH_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> WITHER_FARM = ITEM_REGISTER.register("wither_farm", () -> ModBlocks.WITHER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> WITHER_SKELETON_FARM = ITEM_REGISTER.register("wither_skeleton_farm", () -> ModBlocks.WITHER_SKELETON_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ZOGLIN_FARM = ITEM_REGISTER.register("zoglin_farm", () -> ModBlocks.ZOGLIN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ZOMBIE_FARM = ITEM_REGISTER.register("zombie_farm", () -> ModBlocks.ZOMBIE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ICON_ITEM = ITEM_REGISTER.register("icon_item",
            () -> new IconItem(new Item.Properties()));
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerData>> VILLAGER_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("villager", () -> DataComponentType.<VillagerData>builder().persistent(VillagerData.CODEC).networkSynchronized(VillagerData.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerBlockEntityData>> BLOCK_ENTITY_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("block_entity", () -> DataComponentType.<VillagerBlockEntityData>builder().networkSynchronized(VillagerBlockEntityData.STREAM_CODEC).build());

    public static void init(IEventBus eventBus) {
        ITEM_REGISTER.register(eventBus);
        DATA_COMPONENT_TYPE_REGISTER.register(eventBus);
    }

}
