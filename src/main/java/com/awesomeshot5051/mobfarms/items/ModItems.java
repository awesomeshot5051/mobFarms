package com.awesomeshot5051.mobfarms.items;

import com.awesomeshot5051.mobfarms.blocks.InventoryViewerBlock;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.BlazeFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.CreeperFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.DrownedFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ElderGuardianFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.EvokerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GhastFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GuardianFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.HoglinFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.IllusionerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.MagmaCubeFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PhantomFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PillagerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.RavagerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ShulkerFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SkeletonFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SlimeFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.VindicatorFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WardenFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitchFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherSkeletonFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZoglinFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZombieFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.EndermanFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.GoatFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.IronFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.PiglinFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.SpiderFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.ZombifiedPiglinFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.ChickenFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CodFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CowFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.GlowSquidFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.HorseFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.MooshroomFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.ParrotFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PigFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PufferfishFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.RabbitFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SalmonFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SnowGolemFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SquidFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.StriderFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TropicalFishFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TurtleFarmBlock;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerBlockEntityData;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
/*  16 */   private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create((Registry)BuiltInRegistries.ITEM, "mob_farms");
   
/*  19 */   public static final DeferredHolder<Item, Item> INVENTORY_VIEWER = ITEM_REGISTER.register("inventory_viewer", () -> ((InventoryViewerBlock)ModBlocks.INVENTORY_VIEWER.get()).toItem());
   
/*  23 */   public static final DeferredHolder<Item, Item> CHICKEN_FARM = ITEM_REGISTER.register("chicken_farm", () -> ((ChickenFarmBlock)ModBlocks.CHICKEN_FARM.get()).toItem());
   
/*  24 */   public static final DeferredHolder<Item, Item> COD_FARM = ITEM_REGISTER.register("cod_farm", () -> ((CodFarmBlock)ModBlocks.COD_FARM.get()).toItem());
   
/*  25 */   public static final DeferredHolder<Item, Item> COW_FARM = ITEM_REGISTER.register("cow_farm", () -> ((CowFarmBlock)ModBlocks.COW_FARM.get()).toItem());
   
/*  26 */   public static final DeferredHolder<Item, Item> GLOW_SQUID_FARM = ITEM_REGISTER.register("glow_squid_farm", () -> ((GlowSquidFarmBlock)ModBlocks.GLOW_SQUID_FARM.get()).toItem());
   
/*  27 */   public static final DeferredHolder<Item, Item> HORSE_FARM = ITEM_REGISTER.register("horse_farm", () -> ((HorseFarmBlock)ModBlocks.HORSE_FARM.get()).toItem());
   
/*  28 */   public static final DeferredHolder<Item, Item> MOOSHROOM_FARM = ITEM_REGISTER.register("mooshroom_farm", () -> ((MooshroomFarmBlock)ModBlocks.MOOSHROOM_FARM.get()).toItem());
   
/*  29 */   public static final DeferredHolder<Item, Item> PARROT_FARM = ITEM_REGISTER.register("parrot_farm", () -> ((ParrotFarmBlock)ModBlocks.PARROT_FARM.get()).toItem());
   
/*  30 */   public static final DeferredHolder<Item, Item> PIG_FARM = ITEM_REGISTER.register("pig_farm", () -> ((PigFarmBlock)ModBlocks.PIG_FARM.get()).toItem());
   
/*  31 */   public static final DeferredHolder<Item, Item> PUFFERFISH_FARM = ITEM_REGISTER.register("pufferfish_farm", () -> ((PufferfishFarmBlock)ModBlocks.PUFFERFISH_FARM.get()).toItem());
   
/*  32 */   public static final DeferredHolder<Item, Item> RABBIT_FARM = ITEM_REGISTER.register("rabbit_farm", () -> ((RabbitFarmBlock)ModBlocks.RABBIT_FARM.get()).toItem());
   
/*  33 */   public static final DeferredHolder<Item, Item> SALMON_FARM = ITEM_REGISTER.register("salmon_farm", () -> ((SalmonFarmBlock)ModBlocks.SALMON_FARM.get()).toItem());
   
/*  34 */   public static final DeferredHolder<Item, Item> SHEEP_FARM = ITEM_REGISTER.register("sheep_farm", () -> ((SheepFarmBlock)ModBlocks.SHEEP_FARM.get()).toItem());
   
/*  35 */   public static final DeferredHolder<Item, Item> SNOW_GOLEM_FARM = ITEM_REGISTER.register("snow_golem_farm", () -> ((SnowGolemFarmBlock)ModBlocks.SNOW_GOLEM_FARM.get()).toItem());
   
/*  36 */   public static final DeferredHolder<Item, Item> SQUID_FARM = ITEM_REGISTER.register("squid_farm", () -> ((SquidFarmBlock)ModBlocks.SQUID_FARM.get()).toItem());
   
/*  37 */   public static final DeferredHolder<Item, Item> STRIDER_FARM = ITEM_REGISTER.register("strider_farm", () -> ((StriderFarmBlock)ModBlocks.STRIDER_FARM.get()).toItem());
   
/*  38 */   public static final DeferredHolder<Item, Item> TROPICAL_FISH_FARM = ITEM_REGISTER.register("tropical_fish_farm", () -> ((TropicalFishFarmBlock)ModBlocks.TROPICAL_FISH_FARM.get()).toItem());
   
/*  39 */   public static final DeferredHolder<Item, Item> TURTLE_FARM = ITEM_REGISTER.register("turtle_farm", () -> ((TurtleFarmBlock)ModBlocks.TURTLE_FARM.get()).toItem());
   
/*  42 */   public static final DeferredHolder<Item, Item> SPIDER_FARM = ITEM_REGISTER.register("spider_farm", () -> ((SpiderFarmBlock)ModBlocks.SPIDER_FARM.get()).toItem());
   
/*  43 */   public static final DeferredHolder<Item, Item> ENDERMAN_FARM = ITEM_REGISTER.register("enderman_farm", () -> ((EndermanFarmBlock)ModBlocks.ENDERMAN_FARM.get()).toItem());
   
/*  44 */   public static final DeferredHolder<Item, Item> GOAT_FARM = ITEM_REGISTER.register("goat_farm", () -> ((GoatFarmBlock)ModBlocks.GOAT_FARM.get()).toItem());
   
/*  45 */   public static final DeferredHolder<Item, Item> IRON_FARM = ITEM_REGISTER.register("iron_farm", () -> ((IronFarmBlock)ModBlocks.IRON_FARM.get()).toItem());
   
/*  46 */   public static final DeferredHolder<Item, Item> PIGLIN_FARM = ITEM_REGISTER.register("piglin_farm", () -> ((PiglinFarmBlock)ModBlocks.PIGLIN_FARM.get()).toItem());
   
/*  47 */   public static final DeferredHolder<Item, Item> ZOMBIFIED_PIGLIN_FARM = ITEM_REGISTER.register("zombified_piglin_farm", () -> ((ZombifiedPiglinFarmBlock)ModBlocks.ZOMBIFIED_PIGLIN_FARM.get()).toItem());
   
/*  51 */   public static final DeferredHolder<Item, Item> BLAZE_FARM = ITEM_REGISTER.register("blaze_farm", () -> ((BlazeFarmBlock)ModBlocks.BLAZE_FARM.get()).toItem());
   
/*  52 */   public static final DeferredHolder<Item, Item> CREEPER_FARM = ITEM_REGISTER.register("creeper_farm", () -> ((CreeperFarmBlock)ModBlocks.CREEPER_FARM.get()).toItem());
   
/*  53 */   public static final DeferredHolder<Item, Item> DROWNED_FARM = ITEM_REGISTER.register("drowned_farm", () -> ((DrownedFarmBlock)ModBlocks.DROWNED_FARM.get()).toItem());
   
/*  54 */   public static final DeferredHolder<Item, Item> ELDER_GUARDIAN_FARM = ITEM_REGISTER.register("elder_guardian_farm", () -> ((ElderGuardianFarmBlock)ModBlocks.ELDER_GUARDIAN_FARM.get()).toItem());
   
/*  55 */   public static final DeferredHolder<Item, Item> EVOKER_FARM = ITEM_REGISTER.register("evoker_farm", () -> ((EvokerFarmBlock)ModBlocks.EVOKER_FARM.get()).toItem());
   
/*  56 */   public static final DeferredHolder<Item, Item> GHAST_FARM = ITEM_REGISTER.register("ghast_farm", () -> ((GhastFarmBlock)ModBlocks.GHAST_FARM.get()).toItem());
   
/*  57 */   public static final DeferredHolder<Item, Item> GUARDIAN_FARM = ITEM_REGISTER.register("guardian_farm", () -> ((GuardianFarmBlock)ModBlocks.GUARDIAN_FARM.get()).toItem());
   
/*  58 */   public static final DeferredHolder<Item, Item> HOGLIN_FARM = ITEM_REGISTER.register("hoglin_farm", () -> ((HoglinFarmBlock)ModBlocks.HOGLIN_FARM.get()).toItem());
   
/*  59 */   public static final DeferredHolder<Item, Item> ILLUSIONER_FARM = ITEM_REGISTER.register("illusioner_farm", () -> ((IllusionerFarmBlock)ModBlocks.ILLUSIONER_FARM.get()).toItem());
   
/*  60 */   public static final DeferredHolder<Item, Item> MAGMA_CUBE_FARM = ITEM_REGISTER.register("magma_cube_farm", () -> ((MagmaCubeFarmBlock)ModBlocks.MAGMA_CUBE_FARM.get()).toItem());
   
/*  61 */   public static final DeferredHolder<Item, Item> PHANTOM_FARM = ITEM_REGISTER.register("phantom_farm", () -> ((PhantomFarmBlock)ModBlocks.PHANTOM_FARM.get()).toItem());
   
/*  62 */   public static final DeferredHolder<Item, Item> PILLAGER_FARM = ITEM_REGISTER.register("pillager_farm", () -> ((PillagerFarmBlock)ModBlocks.PILLAGER_FARM.get()).toItem());
   
/*  63 */   public static final DeferredHolder<Item, Item> RAVAGER_FARM = ITEM_REGISTER.register("ravager_farm", () -> ((RavagerFarmBlock)ModBlocks.RAVAGER_FARM.get()).toItem());
   
/*  64 */   public static final DeferredHolder<Item, Item> SHULKER_FARM = ITEM_REGISTER.register("shulker_farm", () -> ((ShulkerFarmBlock)ModBlocks.SHULKER_FARM.get()).toItem());
   
/*  65 */   public static final DeferredHolder<Item, Item> SKELETON_FARM = ITEM_REGISTER.register("skeleton_farm", () -> ((SkeletonFarmBlock)ModBlocks.SKELETON_FARM.get()).toItem());
   
/*  66 */   public static final DeferredHolder<Item, Item> SLIME_FARM = ITEM_REGISTER.register("slime_farm", () -> ((SlimeFarmBlock)ModBlocks.SLIME_FARM.get()).toItem());
   
/*  67 */   public static final DeferredHolder<Item, Item> VINDICATOR_FARM = ITEM_REGISTER.register("vindicator_farm", () -> ((VindicatorFarmBlock)ModBlocks.VINDICATOR_FARM.get()).toItem());
   
/*  68 */   public static final DeferredHolder<Item, Item> WARDEN_FARM = ITEM_REGISTER.register("warden_farm", () -> ((WardenFarmBlock)ModBlocks.WARDEN_FARM.get()).toItem());
   
/*  69 */   public static final DeferredHolder<Item, Item> WITCH_FARM = ITEM_REGISTER.register("witch_farm", () -> ((WitchFarmBlock)ModBlocks.WITCH_FARM.get()).toItem());
   
/*  70 */   public static final DeferredHolder<Item, Item> WITHER_FARM = ITEM_REGISTER.register("wither_farm", () -> ((WitherFarmBlock)ModBlocks.WITHER_FARM.get()).toItem());
   
/*  71 */   public static final DeferredHolder<Item, Item> WITHER_SKELETON_FARM = ITEM_REGISTER.register("wither_skeleton_farm", () -> ((WitherSkeletonFarmBlock)ModBlocks.WITHER_SKELETON_FARM.get()).toItem());
   
/*  72 */   public static final DeferredHolder<Item, Item> ZOGLIN_FARM = ITEM_REGISTER.register("zoglin_farm", () -> ((ZoglinFarmBlock)ModBlocks.ZOGLIN_FARM.get()).toItem());
   
/*  73 */   public static final DeferredHolder<Item, Item> ZOMBIE_FARM = ITEM_REGISTER.register("zombie_farm", () -> ((ZombieFarmBlock)ModBlocks.ZOMBIE_FARM.get()).toItem());
   
/*  74 */   public static final DeferredHolder<Item, Item> ICON_ITEM = ITEM_REGISTER.register("icon_item", () -> new IconItem(new Item.Properties()));
   
/*  76 */   private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, "mob_farms");
   
/*  77 */   public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerData>> VILLAGER_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("villager", () -> DataComponentType.builder().persistent(VillagerData.CODEC).networkSynchronized(VillagerData.STREAM_CODEC).build());
   
/*  78 */   public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerBlockEntityData>> BLOCK_ENTITY_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("block_entity", () -> DataComponentType.builder().networkSynchronized(VillagerBlockEntityData.STREAM_CODEC).build());
   
   public static void init(IEventBus eventBus) {
/*  81 */     ITEM_REGISTER.register(eventBus);
/*  82 */     DATA_COMPONENT_TYPE_REGISTER.register(eventBus);
   }
}
