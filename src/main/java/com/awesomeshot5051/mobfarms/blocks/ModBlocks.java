/*   0 */ package com.awesomeshot5051.mobfarms.blocks;
/*   0 */ 
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
/*   0 */ import java.util.function.Supplier;
/*   0 */ import net.minecraft.core.Registry;
/*   0 */ import net.minecraft.core.registries.BuiltInRegistries;
/*   0 */ import net.minecraft.world.level.block.Block;
/*   0 */ import net.neoforged.bus.api.IEventBus;
/*   0 */ import net.neoforged.neoforge.registries.DeferredHolder;
/*   0 */ import net.neoforged.neoforge.registries.DeferredRegister;
/*   0 */ 
/*   0 */ public class ModBlocks {
/*  15 */   private static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create((Registry)BuiltInRegistries.BLOCK, "mob_farms");
/*   0 */   
/*  18 */   public static final DeferredHolder<Block, ChickenFarmBlock> CHICKEN_FARM = BLOCK_REGISTER.register("chicken_farm", ChickenFarmBlock::new);
/*   0 */   
/*  19 */   public static final DeferredHolder<Block, CodFarmBlock> COD_FARM = BLOCK_REGISTER.register("cod_farm", CodFarmBlock::new);
/*   0 */   
/*  20 */   public static final DeferredHolder<Block, CowFarmBlock> COW_FARM = BLOCK_REGISTER.register("cow_farm", CowFarmBlock::new);
/*   0 */   
/*  21 */   public static final DeferredHolder<Block, GlowSquidFarmBlock> GLOW_SQUID_FARM = BLOCK_REGISTER.register("glow_squid_farm", GlowSquidFarmBlock::new);
/*   0 */   
/*  22 */   public static final DeferredHolder<Block, HorseFarmBlock> HORSE_FARM = BLOCK_REGISTER.register("horse_farm", HorseFarmBlock::new);
/*   0 */   
/*  23 */   public static final DeferredHolder<Block, MooshroomFarmBlock> MOOSHROOM_FARM = BLOCK_REGISTER.register("mooshroom_farm", MooshroomFarmBlock::new);
/*   0 */   
/*  24 */   public static final DeferredHolder<Block, ParrotFarmBlock> PARROT_FARM = BLOCK_REGISTER.register("parrot_farm", ParrotFarmBlock::new);
/*   0 */   
/*  25 */   public static final DeferredHolder<Block, PigFarmBlock> PIG_FARM = BLOCK_REGISTER.register("pig_farm", PigFarmBlock::new);
/*   0 */   
/*  26 */   public static final DeferredHolder<Block, PufferfishFarmBlock> PUFFERFISH_FARM = BLOCK_REGISTER.register("pufferfish_farm", PufferfishFarmBlock::new);
/*   0 */   
/*  27 */   public static final DeferredHolder<Block, RabbitFarmBlock> RABBIT_FARM = BLOCK_REGISTER.register("rabbit_farm", RabbitFarmBlock::new);
/*   0 */   
/*  28 */   public static final DeferredHolder<Block, SalmonFarmBlock> SALMON_FARM = BLOCK_REGISTER.register("salmon_farm", SalmonFarmBlock::new);
/*   0 */   
/*  29 */   public static final DeferredHolder<Block, SheepFarmBlock> SHEEP_FARM = BLOCK_REGISTER.register("sheep_farm", SheepFarmBlock::new);
/*   0 */   
/*  30 */   public static final DeferredHolder<Block, SnowGolemFarmBlock> SNOW_GOLEM_FARM = BLOCK_REGISTER.register("snow_golem_farm", SnowGolemFarmBlock::new);
/*   0 */   
/*  31 */   public static final DeferredHolder<Block, SquidFarmBlock> SQUID_FARM = BLOCK_REGISTER.register("squid_farm", SquidFarmBlock::new);
/*   0 */   
/*  32 */   public static final DeferredHolder<Block, StriderFarmBlock> STRIDER_FARM = BLOCK_REGISTER.register("strider_farm", StriderFarmBlock::new);
/*   0 */   
/*  33 */   public static final DeferredHolder<Block, TropicalFishFarmBlock> TROPICAL_FISH_FARM = BLOCK_REGISTER.register("tropical_fish_farm", TropicalFishFarmBlock::new);
/*   0 */   
/*  34 */   public static final DeferredHolder<Block, TurtleFarmBlock> TURTLE_FARM = BLOCK_REGISTER.register("turtle_farm", TurtleFarmBlock::new);
/*   0 */   
/*  38 */   public static final DeferredHolder<Block, EndermanFarmBlock> ENDERMAN_FARM = BLOCK_REGISTER.register("enderman_farm", EndermanFarmBlock::new);
/*   0 */   
/*  39 */   public static final DeferredHolder<Block, GoatFarmBlock> GOAT_FARM = BLOCK_REGISTER.register("goat_farm", GoatFarmBlock::new);
/*   0 */   
/*  40 */   public static final DeferredHolder<Block, IronFarmBlock> IRON_FARM = BLOCK_REGISTER.register("iron_farm", IronFarmBlock::new);
/*   0 */   
/*  41 */   public static final DeferredHolder<Block, SpiderFarmBlock> SPIDER_FARM = BLOCK_REGISTER.register("spider_farm", SpiderFarmBlock::new);
/*   0 */   
/*  42 */   public static final DeferredHolder<Block, PiglinFarmBlock> PIGLIN_FARM = BLOCK_REGISTER.register("piglin_farm", PiglinFarmBlock::new);
/*   0 */   
/*  43 */   public static final DeferredHolder<Block, ZombifiedPiglinFarmBlock> ZOMBIFIED_PIGLIN_FARM = BLOCK_REGISTER.register("zombified_piglin_farm", ZombifiedPiglinFarmBlock::new);
/*   0 */   
/*  47 */   public static final DeferredHolder<Block, BlazeFarmBlock> BLAZE_FARM = BLOCK_REGISTER.register("blaze_farm", BlazeFarmBlock::new);
/*   0 */   
/*  48 */   public static final DeferredHolder<Block, CreeperFarmBlock> CREEPER_FARM = BLOCK_REGISTER.register("creeper_farm", CreeperFarmBlock::new);
/*   0 */   
/*  49 */   public static final DeferredHolder<Block, DrownedFarmBlock> DROWNED_FARM = BLOCK_REGISTER.register("drowned_farm", DrownedFarmBlock::new);
/*   0 */   
/*  50 */   public static final DeferredHolder<Block, ElderGuardianFarmBlock> ELDER_GUARDIAN_FARM = BLOCK_REGISTER.register("elder_guardian_farm", ElderGuardianFarmBlock::new);
/*   0 */   
/*  51 */   public static final DeferredHolder<Block, EvokerFarmBlock> EVOKER_FARM = BLOCK_REGISTER.register("evoker_farm", EvokerFarmBlock::new);
/*   0 */   
/*  52 */   public static final DeferredHolder<Block, GhastFarmBlock> GHAST_FARM = BLOCK_REGISTER.register("ghast_farm", GhastFarmBlock::new);
/*   0 */   
/*  53 */   public static final DeferredHolder<Block, GuardianFarmBlock> GUARDIAN_FARM = BLOCK_REGISTER.register("guardian_farm", GuardianFarmBlock::new);
/*   0 */   
/*  54 */   public static final DeferredHolder<Block, HoglinFarmBlock> HOGLIN_FARM = BLOCK_REGISTER.register("hoglin_farm", HoglinFarmBlock::new);
/*   0 */   
/*  55 */   public static final DeferredHolder<Block, IllusionerFarmBlock> ILLUSIONER_FARM = BLOCK_REGISTER.register("illusioner_farm", IllusionerFarmBlock::new);
/*   0 */   
/*  56 */   public static final DeferredHolder<Block, MagmaCubeFarmBlock> MAGMA_CUBE_FARM = BLOCK_REGISTER.register("magma_cube_farm", MagmaCubeFarmBlock::new);
/*   0 */   
/*  57 */   public static final DeferredHolder<Block, PhantomFarmBlock> PHANTOM_FARM = BLOCK_REGISTER.register("phantom_farm", PhantomFarmBlock::new);
/*   0 */   
/*  58 */   public static final DeferredHolder<Block, PillagerFarmBlock> PILLAGER_FARM = BLOCK_REGISTER.register("pillager_farm", PillagerFarmBlock::new);
/*   0 */   
/*  59 */   public static final DeferredHolder<Block, RavagerFarmBlock> RAVAGER_FARM = BLOCK_REGISTER.register("ravager_farm", RavagerFarmBlock::new);
/*   0 */   
/*  60 */   public static final DeferredHolder<Block, ShulkerFarmBlock> SHULKER_FARM = BLOCK_REGISTER.register("shulker_farm", ShulkerFarmBlock::new);
/*   0 */   
/*  61 */   public static final DeferredHolder<Block, SkeletonFarmBlock> SKELETON_FARM = BLOCK_REGISTER.register("skeleton_farm", SkeletonFarmBlock::new);
/*   0 */   
/*  62 */   public static final DeferredHolder<Block, SlimeFarmBlock> SLIME_FARM = BLOCK_REGISTER.register("slime_farm", SlimeFarmBlock::new);
/*   0 */   
/*  63 */   public static final DeferredHolder<Block, VindicatorFarmBlock> VINDICATOR_FARM = BLOCK_REGISTER.register("vindicator_farm", VindicatorFarmBlock::new);
/*   0 */   
/*  64 */   public static final DeferredHolder<Block, WardenFarmBlock> WARDEN_FARM = BLOCK_REGISTER.register("warden_farm", WardenFarmBlock::new);
/*   0 */   
/*  65 */   public static final DeferredHolder<Block, WitchFarmBlock> WITCH_FARM = BLOCK_REGISTER.register("witch_farm", WitchFarmBlock::new);
/*   0 */   
/*  66 */   public static final DeferredHolder<Block, WitherSkeletonFarmBlock> WITHER_SKELETON_FARM = BLOCK_REGISTER.register("wither_skeleton_farm", WitherSkeletonFarmBlock::new);
/*   0 */   
/*  67 */   public static final DeferredHolder<Block, WitherFarmBlock> WITHER_FARM = BLOCK_REGISTER.register("wither_farm", WitherFarmBlock::new);
/*   0 */   
/*  68 */   public static final DeferredHolder<Block, ZoglinFarmBlock> ZOGLIN_FARM = BLOCK_REGISTER.register("zoglin_farm", ZoglinFarmBlock::new);
/*   0 */   
/*  69 */   public static final DeferredHolder<Block, ZombieFarmBlock> ZOMBIE_FARM = BLOCK_REGISTER.register("zombie_farm", ZombieFarmBlock::new);
/*   0 */   
/*  72 */   public static final DeferredHolder<Block, InventoryViewerBlock> INVENTORY_VIEWER = BLOCK_REGISTER.register("inventory_viewer", InventoryViewerBlock::new);
/*   0 */   
/*   0 */   public static void init(IEventBus eventBus) {
/*  74 */     BLOCK_REGISTER.register(eventBus);
/*   0 */   }
/*   0 */ }
