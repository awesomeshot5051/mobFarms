package com.awesomeshot5051.mobfarms.blocks;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.*;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK, Main.MODID);

    // Passive Mobs
    public static final DeferredHolder<Block, ChickenFarmBlock> CHICKEN_FARM = BLOCK_REGISTER.register("chicken_farm", ChickenFarmBlock::new);
    public static final DeferredHolder<Block, CodFarmBlock> COD_FARM = BLOCK_REGISTER.register("cod_farm", CodFarmBlock::new);
    public static final DeferredHolder<Block, CowFarmBlock> COW_FARM = BLOCK_REGISTER.register("cow_farm", CowFarmBlock::new);
    public static final DeferredHolder<Block, GlowSquidFarmBlock> GLOW_SQUID_FARM = BLOCK_REGISTER.register("glow_squid_farm", GlowSquidFarmBlock::new);
    public static final DeferredHolder<Block, HorseFarmBlock> HORSE_FARM = BLOCK_REGISTER.register("horse_farm", HorseFarmBlock::new);
    public static final DeferredHolder<Block, MooshroomFarmBlock> MOOSHROOM_FARM = BLOCK_REGISTER.register("mooshroom_farm", MooshroomFarmBlock::new);
    public static final DeferredHolder<Block, ParrotFarmBlock> PARROT_FARM = BLOCK_REGISTER.register("parrot_farm", ParrotFarmBlock::new);
    public static final DeferredHolder<Block, PigFarmBlock> PIG_FARM = BLOCK_REGISTER.register("pig_farm", PigFarmBlock::new);
    public static final DeferredHolder<Block, PufferfishFarmBlock> PUFFERFISH_FARM = BLOCK_REGISTER.register("pufferfish_farm", PufferfishFarmBlock::new);
    public static final DeferredHolder<Block, RabbitFarmBlock> RABBIT_FARM = BLOCK_REGISTER.register("rabbit_farm", RabbitFarmBlock::new);
    public static final DeferredHolder<Block, SalmonFarmBlock> SALMON_FARM = BLOCK_REGISTER.register("salmon_farm", SalmonFarmBlock::new);
    public static final DeferredHolder<Block, SheepFarmBlock> SHEEP_FARM = BLOCK_REGISTER.register("sheep_farm", SheepFarmBlock::new);
    public static final DeferredHolder<Block, SnowGolemFarmBlock> SNOW_GOLEM_FARM = BLOCK_REGISTER.register("snow_golem_farm", SnowGolemFarmBlock::new);
    public static final DeferredHolder<Block, SquidFarmBlock> SQUID_FARM = BLOCK_REGISTER.register("squid_farm", SquidFarmBlock::new);
    public static final DeferredHolder<Block, StriderFarmBlock> STRIDER_FARM = BLOCK_REGISTER.register("strider_farm", StriderFarmBlock::new);
    public static final DeferredHolder<Block, TropicalFishFarmBlock> TROPICAL_FISH_FARM = BLOCK_REGISTER.register("tropical_fish_farm", TropicalFishFarmBlock::new);
    public static final DeferredHolder<Block, TurtleFarmBlock> TURTLE_FARM = BLOCK_REGISTER.register("turtle_farm", TurtleFarmBlock::new);


    // Neutral Mobs
    public static final DeferredHolder<Block, EndermanFarmBlock> ENDERMAN_FARM = BLOCK_REGISTER.register("enderman_farm", EndermanFarmBlock::new);
    public static final DeferredHolder<Block, GoatFarmBlock> GOAT_FARM = BLOCK_REGISTER.register("goat_farm", GoatFarmBlock::new);
    public static final DeferredHolder<Block, IronFarmBlock> IRON_FARM = BLOCK_REGISTER.register("iron_farm", IronFarmBlock::new);
    public static final DeferredHolder<Block, SpiderFarmBlock> SPIDER_FARM = BLOCK_REGISTER.register("spider_farm", SpiderFarmBlock::new);
    public static final DeferredHolder<Block, PiglinFarmBlock> PIGLIN_FARM = BLOCK_REGISTER.register("piglin_farm", PiglinFarmBlock::new);
    public static final DeferredHolder<Block, ZombifiedPiglinFarmBlock> ZOMBIFIED_PIGLIN_FARM = BLOCK_REGISTER.register("zombified_piglin_farm", ZombifiedPiglinFarmBlock::new);


    // Aggressive Mobs
    public static final DeferredHolder<Block, BlazeFarmBlock> BLAZE_FARM = BLOCK_REGISTER.register("blaze_farm", BlazeFarmBlock::new);
    public static final DeferredHolder<Block, CreeperFarmBlock> CREEPER_FARM = BLOCK_REGISTER.register("creeper_farm", CreeperFarmBlock::new);
    public static final DeferredHolder<Block, DrownedFarmBlock> DROWNED_FARM = BLOCK_REGISTER.register("drowned_farm", DrownedFarmBlock::new);
    public static final DeferredHolder<Block, ElderGuardianFarmBlock> ELDER_GUARDIAN_FARM = BLOCK_REGISTER.register("elder_guardian_farm", ElderGuardianFarmBlock::new);
    public static final DeferredHolder<Block, EvokerFarmBlock> EVOKER_FARM = BLOCK_REGISTER.register("evoker_farm", EvokerFarmBlock::new);
    public static final DeferredHolder<Block, GhastFarmBlock> GHAST_FARM = BLOCK_REGISTER.register("ghast_farm", GhastFarmBlock::new);
    public static final DeferredHolder<Block, GuardianFarmBlock> GUARDIAN_FARM = BLOCK_REGISTER.register("guardian_farm", GuardianFarmBlock::new);
    public static final DeferredHolder<Block, HoglinFarmBlock> HOGLIN_FARM = BLOCK_REGISTER.register("hoglin_farm", HoglinFarmBlock::new);
    public static final DeferredHolder<Block, IllusionerFarmBlock> ILLUSIONER_FARM = BLOCK_REGISTER.register("illusioner_farm", IllusionerFarmBlock::new);
    public static final DeferredHolder<Block, MagmaCubeFarmBlock> MAGMA_CUBE_FARM = BLOCK_REGISTER.register("magma_cube_farm", MagmaCubeFarmBlock::new);
    public static final DeferredHolder<Block, PhantomFarmBlock> PHANTOM_FARM = BLOCK_REGISTER.register("phantom_farm", PhantomFarmBlock::new);
    public static final DeferredHolder<Block, PillagerFarmBlock> PILLAGER_FARM = BLOCK_REGISTER.register("pillager_farm", PillagerFarmBlock::new);
    public static final DeferredHolder<Block, RavagerFarmBlock> RAVAGER_FARM = BLOCK_REGISTER.register("ravager_farm", RavagerFarmBlock::new);
    public static final DeferredHolder<Block, ShulkerFarmBlock> SHULKER_FARM = BLOCK_REGISTER.register("shulker_farm", ShulkerFarmBlock::new);
    public static final DeferredHolder<Block, SkeletonFarmBlock> SKELETON_FARM = BLOCK_REGISTER.register("skeleton_farm", SkeletonFarmBlock::new);
    public static final DeferredHolder<Block, SlimeFarmBlock> SLIME_FARM = BLOCK_REGISTER.register("slime_farm", SlimeFarmBlock::new);
    public static final DeferredHolder<Block, VindicatorFarmBlock> VINDICATOR_FARM = BLOCK_REGISTER.register("vindicator_farm", VindicatorFarmBlock::new);
    public static final DeferredHolder<Block, WardenFarmBlock> WARDEN_FARM = BLOCK_REGISTER.register("warden_farm", WardenFarmBlock::new);
    public static final DeferredHolder<Block, WitchFarmBlock> WITCH_FARM = BLOCK_REGISTER.register("witch_farm", WitchFarmBlock::new);
    public static final DeferredHolder<Block, WitherSkeletonFarmBlock> WITHER_SKELETON_FARM = BLOCK_REGISTER.register("wither_skeleton_farm", WitherSkeletonFarmBlock::new);
    public static final DeferredHolder<Block, WitherFarmBlock> WITHER_FARM = BLOCK_REGISTER.register("wither_farm", WitherFarmBlock::new);
    public static final DeferredHolder<Block, ZoglinFarmBlock> ZOGLIN_FARM = BLOCK_REGISTER.register("zoglin_farm", ZoglinFarmBlock::new);
    public static final DeferredHolder<Block, ZombieFarmBlock> ZOMBIE_FARM = BLOCK_REGISTER.register("zombie_farm", ZombieFarmBlock::new);


    public static final DeferredHolder<Block, InventoryViewerBlock> INVENTORY_VIEWER = BLOCK_REGISTER.register("inventory_viewer", InventoryViewerBlock::new);
    public static void init(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }

}
