package com.awesomeshot5051.mobfarms.blocks;

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
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
   private static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create((Registry)BuiltInRegistries.BLOCK, "mob_farms");
   
/*  18 */   public static final DeferredHolder<Block, ChickenFarmBlock> CHICKEN_FARM = BLOCK_REGISTER.register("chicken_farm", ChickenFarmBlock::new);
   
/*  19 */   public static final DeferredHolder<Block, CodFarmBlock> COD_FARM = BLOCK_REGISTER.register("cod_farm", CodFarmBlock::new);
   
/*  20 */   public static final DeferredHolder<Block, CowFarmBlock> COW_FARM = BLOCK_REGISTER.register("cow_farm", CowFarmBlock::new);
   
/*  21 */   public static final DeferredHolder<Block, GlowSquidFarmBlock> GLOW_SQUID_FARM = BLOCK_REGISTER.register("glow_squid_farm", GlowSquidFarmBlock::new);
   
/*  22 */   public static final DeferredHolder<Block, HorseFarmBlock> HORSE_FARM = BLOCK_REGISTER.register("horse_farm", HorseFarmBlock::new);
   
/*  23 */   public static final DeferredHolder<Block, MooshroomFarmBlock> MOOSHROOM_FARM = BLOCK_REGISTER.register("mooshroom_farm", MooshroomFarmBlock::new);
   
/*  24 */   public static final DeferredHolder<Block, ParrotFarmBlock> PARROT_FARM = BLOCK_REGISTER.register("parrot_farm", ParrotFarmBlock::new);
   
/*  25 */   public static final DeferredHolder<Block, PigFarmBlock> PIG_FARM = BLOCK_REGISTER.register("pig_farm", PigFarmBlock::new);
   
/*  26 */   public static final DeferredHolder<Block, PufferfishFarmBlock> PUFFERFISH_FARM = BLOCK_REGISTER.register("pufferfish_farm", PufferfishFarmBlock::new);
   
/*  27 */   public static final DeferredHolder<Block, RabbitFarmBlock> RABBIT_FARM = BLOCK_REGISTER.register("rabbit_farm", RabbitFarmBlock::new);
   
/*  28 */   public static final DeferredHolder<Block, SalmonFarmBlock> SALMON_FARM = BLOCK_REGISTER.register("salmon_farm", SalmonFarmBlock::new);
   
/*  29 */   public static final DeferredHolder<Block, SheepFarmBlock> SHEEP_FARM = BLOCK_REGISTER.register("sheep_farm", SheepFarmBlock::new);
   
/*  30 */   public static final DeferredHolder<Block, SnowGolemFarmBlock> SNOW_GOLEM_FARM = BLOCK_REGISTER.register("snow_golem_farm", SnowGolemFarmBlock::new);
   
/*  31 */   public static final DeferredHolder<Block, SquidFarmBlock> SQUID_FARM = BLOCK_REGISTER.register("squid_farm", SquidFarmBlock::new);
   
/*  32 */   public static final DeferredHolder<Block, StriderFarmBlock> STRIDER_FARM = BLOCK_REGISTER.register("strider_farm", StriderFarmBlock::new);
   
/*  33 */   public static final DeferredHolder<Block, TropicalFishFarmBlock> TROPICAL_FISH_FARM = BLOCK_REGISTER.register("tropical_fish_farm", TropicalFishFarmBlock::new);
   
/*  34 */   public static final DeferredHolder<Block, TurtleFarmBlock> TURTLE_FARM = BLOCK_REGISTER.register("turtle_farm", TurtleFarmBlock::new);
   
/*  38 */   public static final DeferredHolder<Block, EndermanFarmBlock> ENDERMAN_FARM = BLOCK_REGISTER.register("enderman_farm", EndermanFarmBlock::new);
   
/*  39 */   public static final DeferredHolder<Block, GoatFarmBlock> GOAT_FARM = BLOCK_REGISTER.register("goat_farm", GoatFarmBlock::new);
   
/*  40 */   public static final DeferredHolder<Block, IronFarmBlock> IRON_FARM = BLOCK_REGISTER.register("iron_farm", IronFarmBlock::new);
   
/*  41 */   public static final DeferredHolder<Block, SpiderFarmBlock> SPIDER_FARM = BLOCK_REGISTER.register("spider_farm", SpiderFarmBlock::new);
   
/*  42 */   public static final DeferredHolder<Block, PiglinFarmBlock> PIGLIN_FARM = BLOCK_REGISTER.register("piglin_farm", PiglinFarmBlock::new);
   
/*  43 */   public static final DeferredHolder<Block, ZombifiedPiglinFarmBlock> ZOMBIFIED_PIGLIN_FARM = BLOCK_REGISTER.register("zombified_piglin_farm", ZombifiedPiglinFarmBlock::new);
   
/*  47 */   public static final DeferredHolder<Block, BlazeFarmBlock> BLAZE_FARM = BLOCK_REGISTER.register("blaze_farm", BlazeFarmBlock::new);
   
/*  48 */   public static final DeferredHolder<Block, CreeperFarmBlock> CREEPER_FARM = BLOCK_REGISTER.register("creeper_farm", CreeperFarmBlock::new);
   
/*  49 */   public static final DeferredHolder<Block, DrownedFarmBlock> DROWNED_FARM = BLOCK_REGISTER.register("drowned_farm", DrownedFarmBlock::new);
   
/*  50 */   public static final DeferredHolder<Block, ElderGuardianFarmBlock> ELDER_GUARDIAN_FARM = BLOCK_REGISTER.register("elder_guardian_farm", ElderGuardianFarmBlock::new);
   
/*  51 */   public static final DeferredHolder<Block, EvokerFarmBlock> EVOKER_FARM = BLOCK_REGISTER.register("evoker_farm", EvokerFarmBlock::new);
   
/*  52 */   public static final DeferredHolder<Block, GhastFarmBlock> GHAST_FARM = BLOCK_REGISTER.register("ghast_farm", GhastFarmBlock::new);
   
/*  53 */   public static final DeferredHolder<Block, GuardianFarmBlock> GUARDIAN_FARM = BLOCK_REGISTER.register("guardian_farm", GuardianFarmBlock::new);
   
/*  54 */   public static final DeferredHolder<Block, HoglinFarmBlock> HOGLIN_FARM = BLOCK_REGISTER.register("hoglin_farm", HoglinFarmBlock::new);
   
/*  55 */   public static final DeferredHolder<Block, IllusionerFarmBlock> ILLUSIONER_FARM = BLOCK_REGISTER.register("illusioner_farm", IllusionerFarmBlock::new);
   
/*  56 */   public static final DeferredHolder<Block, MagmaCubeFarmBlock> MAGMA_CUBE_FARM = BLOCK_REGISTER.register("magma_cube_farm", MagmaCubeFarmBlock::new);
   
/*  57 */   public static final DeferredHolder<Block, PhantomFarmBlock> PHANTOM_FARM = BLOCK_REGISTER.register("phantom_farm", PhantomFarmBlock::new);
   
/*  58 */   public static final DeferredHolder<Block, PillagerFarmBlock> PILLAGER_FARM = BLOCK_REGISTER.register("pillager_farm", PillagerFarmBlock::new);
   
/*  59 */   public static final DeferredHolder<Block, RavagerFarmBlock> RAVAGER_FARM = BLOCK_REGISTER.register("ravager_farm", RavagerFarmBlock::new);
   
/*  60 */   public static final DeferredHolder<Block, ShulkerFarmBlock> SHULKER_FARM = BLOCK_REGISTER.register("shulker_farm", ShulkerFarmBlock::new);
   
/*  61 */   public static final DeferredHolder<Block, SkeletonFarmBlock> SKELETON_FARM = BLOCK_REGISTER.register("skeleton_farm", SkeletonFarmBlock::new);
   
/*  62 */   public static final DeferredHolder<Block, SlimeFarmBlock> SLIME_FARM = BLOCK_REGISTER.register("slime_farm", SlimeFarmBlock::new);
   
/*  63 */   public static final DeferredHolder<Block, VindicatorFarmBlock> VINDICATOR_FARM = BLOCK_REGISTER.register("vindicator_farm", VindicatorFarmBlock::new);
   
/*  64 */   public static final DeferredHolder<Block, WardenFarmBlock> WARDEN_FARM = BLOCK_REGISTER.register("warden_farm", WardenFarmBlock::new);
   
/*  65 */   public static final DeferredHolder<Block, WitchFarmBlock> WITCH_FARM = BLOCK_REGISTER.register("witch_farm", WitchFarmBlock::new);
   
/*  66 */   public static final DeferredHolder<Block, WitherSkeletonFarmBlock> WITHER_SKELETON_FARM = BLOCK_REGISTER.register("wither_skeleton_farm", WitherSkeletonFarmBlock::new);
   
/*  67 */   public static final DeferredHolder<Block, WitherFarmBlock> WITHER_FARM = BLOCK_REGISTER.register("wither_farm", WitherFarmBlock::new);
   
/*  68 */   public static final DeferredHolder<Block, ZoglinFarmBlock> ZOGLIN_FARM = BLOCK_REGISTER.register("zoglin_farm", ZoglinFarmBlock::new);
   
/*  69 */   public static final DeferredHolder<Block, ZombieFarmBlock> ZOMBIE_FARM = BLOCK_REGISTER.register("zombie_farm", ZombieFarmBlock::new);
   
/*  72 */   public static final DeferredHolder<Block, InventoryViewerBlock> INVENTORY_VIEWER = BLOCK_REGISTER.register("inventory_viewer", InventoryViewerBlock::new);
   
   public static void init(IEventBus eventBus) {
/*  74 */     BLOCK_REGISTER.register(eventBus);
   }
}
