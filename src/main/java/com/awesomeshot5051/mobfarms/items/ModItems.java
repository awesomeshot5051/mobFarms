/*   0 */ package com.awesomeshot5051.mobfarms.items;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.InventoryViewerBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.BlazeFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.CreeperFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.DrownedFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ElderGuardianFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.EvokerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GhastFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.GuardianFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.HoglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.IllusionerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.MagmaCubeFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PhantomFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PillagerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.RavagerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ShulkerFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SkeletonFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.SlimeFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.VindicatorFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WardenFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitchFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherSkeletonFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZoglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ZombieFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.EndermanFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.GoatFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.IronFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.PiglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.SpiderFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.ZombifiedPiglinFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.ChickenFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CodFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CowFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.GlowSquidFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.HorseFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.MooshroomFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.ParrotFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PigFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.PufferfishFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.RabbitFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SalmonFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SnowGolemFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SquidFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.StriderFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TropicalFishFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.TurtleFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.datacomponents.VillagerBlockEntityData;
/*   0 */ import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;
/*   0 */ import net.minecraft.core.Registry;
/*   0 */ import net.minecraft.core.component.DataComponentType;
/*   0 */ import net.minecraft.core.registries.BuiltInRegistries;
/*   0 */ import net.minecraft.world.item.Item;
/*   0 */ import net.neoforged.bus.api.IEventBus;
/*   0 */ import net.neoforged.neoforge.registries.DeferredHolder;
/*   0 */ import net.neoforged.neoforge.registries.DeferredRegister;
/*   0 */ 
/*   0 */ public class ModItems {
/*  16 */   private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create((Registry)BuiltInRegistries.ITEM, "mob_farms");
/*   0 */   
/*  19 */   public static final DeferredHolder<Item, Item> INVENTORY_VIEWER = ITEM_REGISTER.register("inventory_viewer", () -> ((InventoryViewerBlock)ModBlocks.INVENTORY_VIEWER.get()).toItem());
/*   0 */   
/*  23 */   public static final DeferredHolder<Item, Item> CHICKEN_FARM = ITEM_REGISTER.register("chicken_farm", () -> ((ChickenFarmBlock)ModBlocks.CHICKEN_FARM.get()).toItem());
/*   0 */   
/*  24 */   public static final DeferredHolder<Item, Item> COD_FARM = ITEM_REGISTER.register("cod_farm", () -> ((CodFarmBlock)ModBlocks.COD_FARM.get()).toItem());
/*   0 */   
/*  25 */   public static final DeferredHolder<Item, Item> COW_FARM = ITEM_REGISTER.register("cow_farm", () -> ((CowFarmBlock)ModBlocks.COW_FARM.get()).toItem());
/*   0 */   
/*  26 */   public static final DeferredHolder<Item, Item> GLOW_SQUID_FARM = ITEM_REGISTER.register("glow_squid_farm", () -> ((GlowSquidFarmBlock)ModBlocks.GLOW_SQUID_FARM.get()).toItem());
/*   0 */   
/*  27 */   public static final DeferredHolder<Item, Item> HORSE_FARM = ITEM_REGISTER.register("horse_farm", () -> ((HorseFarmBlock)ModBlocks.HORSE_FARM.get()).toItem());
/*   0 */   
/*  28 */   public static final DeferredHolder<Item, Item> MOOSHROOM_FARM = ITEM_REGISTER.register("mooshroom_farm", () -> ((MooshroomFarmBlock)ModBlocks.MOOSHROOM_FARM.get()).toItem());
/*   0 */   
/*  29 */   public static final DeferredHolder<Item, Item> PARROT_FARM = ITEM_REGISTER.register("parrot_farm", () -> ((ParrotFarmBlock)ModBlocks.PARROT_FARM.get()).toItem());
/*   0 */   
/*  30 */   public static final DeferredHolder<Item, Item> PIG_FARM = ITEM_REGISTER.register("pig_farm", () -> ((PigFarmBlock)ModBlocks.PIG_FARM.get()).toItem());
/*   0 */   
/*  31 */   public static final DeferredHolder<Item, Item> PUFFERFISH_FARM = ITEM_REGISTER.register("pufferfish_farm", () -> ((PufferfishFarmBlock)ModBlocks.PUFFERFISH_FARM.get()).toItem());
/*   0 */   
/*  32 */   public static final DeferredHolder<Item, Item> RABBIT_FARM = ITEM_REGISTER.register("rabbit_farm", () -> ((RabbitFarmBlock)ModBlocks.RABBIT_FARM.get()).toItem());
/*   0 */   
/*  33 */   public static final DeferredHolder<Item, Item> SALMON_FARM = ITEM_REGISTER.register("salmon_farm", () -> ((SalmonFarmBlock)ModBlocks.SALMON_FARM.get()).toItem());
/*   0 */   
/*  34 */   public static final DeferredHolder<Item, Item> SHEEP_FARM = ITEM_REGISTER.register("sheep_farm", () -> ((SheepFarmBlock)ModBlocks.SHEEP_FARM.get()).toItem());
/*   0 */   
/*  35 */   public static final DeferredHolder<Item, Item> SNOW_GOLEM_FARM = ITEM_REGISTER.register("snow_golem_farm", () -> ((SnowGolemFarmBlock)ModBlocks.SNOW_GOLEM_FARM.get()).toItem());
/*   0 */   
/*  36 */   public static final DeferredHolder<Item, Item> SQUID_FARM = ITEM_REGISTER.register("squid_farm", () -> ((SquidFarmBlock)ModBlocks.SQUID_FARM.get()).toItem());
/*   0 */   
/*  37 */   public static final DeferredHolder<Item, Item> STRIDER_FARM = ITEM_REGISTER.register("strider_farm", () -> ((StriderFarmBlock)ModBlocks.STRIDER_FARM.get()).toItem());
/*   0 */   
/*  38 */   public static final DeferredHolder<Item, Item> TROPICAL_FISH_FARM = ITEM_REGISTER.register("tropical_fish_farm", () -> ((TropicalFishFarmBlock)ModBlocks.TROPICAL_FISH_FARM.get()).toItem());
/*   0 */   
/*  39 */   public static final DeferredHolder<Item, Item> TURTLE_FARM = ITEM_REGISTER.register("turtle_farm", () -> ((TurtleFarmBlock)ModBlocks.TURTLE_FARM.get()).toItem());
/*   0 */   
/*  42 */   public static final DeferredHolder<Item, Item> SPIDER_FARM = ITEM_REGISTER.register("spider_farm", () -> ((SpiderFarmBlock)ModBlocks.SPIDER_FARM.get()).toItem());
/*   0 */   
/*  43 */   public static final DeferredHolder<Item, Item> ENDERMAN_FARM = ITEM_REGISTER.register("enderman_farm", () -> ((EndermanFarmBlock)ModBlocks.ENDERMAN_FARM.get()).toItem());
/*   0 */   
/*  44 */   public static final DeferredHolder<Item, Item> GOAT_FARM = ITEM_REGISTER.register("goat_farm", () -> ((GoatFarmBlock)ModBlocks.GOAT_FARM.get()).toItem());
/*   0 */   
/*  45 */   public static final DeferredHolder<Item, Item> IRON_FARM = ITEM_REGISTER.register("iron_farm", () -> ((IronFarmBlock)ModBlocks.IRON_FARM.get()).toItem());
/*   0 */   
/*  46 */   public static final DeferredHolder<Item, Item> PIGLIN_FARM = ITEM_REGISTER.register("piglin_farm", () -> ((PiglinFarmBlock)ModBlocks.PIGLIN_FARM.get()).toItem());
/*   0 */   
/*  47 */   public static final DeferredHolder<Item, Item> ZOMBIFIED_PIGLIN_FARM = ITEM_REGISTER.register("zombified_piglin_farm", () -> ((ZombifiedPiglinFarmBlock)ModBlocks.ZOMBIFIED_PIGLIN_FARM.get()).toItem());
/*   0 */   
/*  51 */   public static final DeferredHolder<Item, Item> BLAZE_FARM = ITEM_REGISTER.register("blaze_farm", () -> ((BlazeFarmBlock)ModBlocks.BLAZE_FARM.get()).toItem());
/*   0 */   
/*  52 */   public static final DeferredHolder<Item, Item> CREEPER_FARM = ITEM_REGISTER.register("creeper_farm", () -> ((CreeperFarmBlock)ModBlocks.CREEPER_FARM.get()).toItem());
/*   0 */   
/*  53 */   public static final DeferredHolder<Item, Item> DROWNED_FARM = ITEM_REGISTER.register("drowned_farm", () -> ((DrownedFarmBlock)ModBlocks.DROWNED_FARM.get()).toItem());
/*   0 */   
/*  54 */   public static final DeferredHolder<Item, Item> ELDER_GUARDIAN_FARM = ITEM_REGISTER.register("elder_guardian_farm", () -> ((ElderGuardianFarmBlock)ModBlocks.ELDER_GUARDIAN_FARM.get()).toItem());
/*   0 */   
/*  55 */   public static final DeferredHolder<Item, Item> EVOKER_FARM = ITEM_REGISTER.register("evoker_farm", () -> ((EvokerFarmBlock)ModBlocks.EVOKER_FARM.get()).toItem());
/*   0 */   
/*  56 */   public static final DeferredHolder<Item, Item> GHAST_FARM = ITEM_REGISTER.register("ghast_farm", () -> ((GhastFarmBlock)ModBlocks.GHAST_FARM.get()).toItem());
/*   0 */   
/*  57 */   public static final DeferredHolder<Item, Item> GUARDIAN_FARM = ITEM_REGISTER.register("guardian_farm", () -> ((GuardianFarmBlock)ModBlocks.GUARDIAN_FARM.get()).toItem());
/*   0 */   
/*  58 */   public static final DeferredHolder<Item, Item> HOGLIN_FARM = ITEM_REGISTER.register("hoglin_farm", () -> ((HoglinFarmBlock)ModBlocks.HOGLIN_FARM.get()).toItem());
/*   0 */   
/*  59 */   public static final DeferredHolder<Item, Item> ILLUSIONER_FARM = ITEM_REGISTER.register("illusioner_farm", () -> ((IllusionerFarmBlock)ModBlocks.ILLUSIONER_FARM.get()).toItem());
/*   0 */   
/*  60 */   public static final DeferredHolder<Item, Item> MAGMA_CUBE_FARM = ITEM_REGISTER.register("magma_cube_farm", () -> ((MagmaCubeFarmBlock)ModBlocks.MAGMA_CUBE_FARM.get()).toItem());
/*   0 */   
/*  61 */   public static final DeferredHolder<Item, Item> PHANTOM_FARM = ITEM_REGISTER.register("phantom_farm", () -> ((PhantomFarmBlock)ModBlocks.PHANTOM_FARM.get()).toItem());
/*   0 */   
/*  62 */   public static final DeferredHolder<Item, Item> PILLAGER_FARM = ITEM_REGISTER.register("pillager_farm", () -> ((PillagerFarmBlock)ModBlocks.PILLAGER_FARM.get()).toItem());
/*   0 */   
/*  63 */   public static final DeferredHolder<Item, Item> RAVAGER_FARM = ITEM_REGISTER.register("ravager_farm", () -> ((RavagerFarmBlock)ModBlocks.RAVAGER_FARM.get()).toItem());
/*   0 */   
/*  64 */   public static final DeferredHolder<Item, Item> SHULKER_FARM = ITEM_REGISTER.register("shulker_farm", () -> ((ShulkerFarmBlock)ModBlocks.SHULKER_FARM.get()).toItem());
/*   0 */   
/*  65 */   public static final DeferredHolder<Item, Item> SKELETON_FARM = ITEM_REGISTER.register("skeleton_farm", () -> ((SkeletonFarmBlock)ModBlocks.SKELETON_FARM.get()).toItem());
/*   0 */   
/*  66 */   public static final DeferredHolder<Item, Item> SLIME_FARM = ITEM_REGISTER.register("slime_farm", () -> ((SlimeFarmBlock)ModBlocks.SLIME_FARM.get()).toItem());
/*   0 */   
/*  67 */   public static final DeferredHolder<Item, Item> VINDICATOR_FARM = ITEM_REGISTER.register("vindicator_farm", () -> ((VindicatorFarmBlock)ModBlocks.VINDICATOR_FARM.get()).toItem());
/*   0 */   
/*  68 */   public static final DeferredHolder<Item, Item> WARDEN_FARM = ITEM_REGISTER.register("warden_farm", () -> ((WardenFarmBlock)ModBlocks.WARDEN_FARM.get()).toItem());
/*   0 */   
/*  69 */   public static final DeferredHolder<Item, Item> WITCH_FARM = ITEM_REGISTER.register("witch_farm", () -> ((WitchFarmBlock)ModBlocks.WITCH_FARM.get()).toItem());
/*   0 */   
/*  70 */   public static final DeferredHolder<Item, Item> WITHER_FARM = ITEM_REGISTER.register("wither_farm", () -> ((WitherFarmBlock)ModBlocks.WITHER_FARM.get()).toItem());
/*   0 */   
/*  71 */   public static final DeferredHolder<Item, Item> WITHER_SKELETON_FARM = ITEM_REGISTER.register("wither_skeleton_farm", () -> ((WitherSkeletonFarmBlock)ModBlocks.WITHER_SKELETON_FARM.get()).toItem());
/*   0 */   
/*  72 */   public static final DeferredHolder<Item, Item> ZOGLIN_FARM = ITEM_REGISTER.register("zoglin_farm", () -> ((ZoglinFarmBlock)ModBlocks.ZOGLIN_FARM.get()).toItem());
/*   0 */   
/*  73 */   public static final DeferredHolder<Item, Item> ZOMBIE_FARM = ITEM_REGISTER.register("zombie_farm", () -> ((ZombieFarmBlock)ModBlocks.ZOMBIE_FARM.get()).toItem());
/*   0 */   
/*  74 */   public static final DeferredHolder<Item, Item> ICON_ITEM = ITEM_REGISTER.register("icon_item", () -> new IconItem(new Item.Properties()));
/*   0 */   
/*  76 */   private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, "mob_farms");
/*   0 */   
/*  77 */   public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerData>> VILLAGER_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("villager", () -> DataComponentType.builder().persistent(VillagerData.CODEC).networkSynchronized(VillagerData.STREAM_CODEC).build());
/*   0 */   
/*  78 */   public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerBlockEntityData>> BLOCK_ENTITY_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("block_entity", () -> DataComponentType.builder().networkSynchronized(VillagerBlockEntityData.STREAM_CODEC).build());
/*   0 */   
/*   0 */   public static void init(IEventBus eventBus) {
/*  81 */     ITEM_REGISTER.register(eventBus);
/*  82 */     DATA_COMPONENT_TYPE_REGISTER.register(eventBus);
/*   0 */   }
/*   0 */ }
