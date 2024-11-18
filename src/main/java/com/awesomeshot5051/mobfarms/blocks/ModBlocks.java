package com.awesomeshot5051.mobfarms.blocks;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.*;
import com.awesomeshot5051.mobfarms.blocks.passiveMobs.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlocks {

    private static final DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(Main.MODID);

    // Passive Mobs
    public static final DeferredHolder<Block, ChickenFarmBlock> CHICKEN_FARM = BLOCK_REGISTER.registerBlock("chicken_farm", ChickenFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, CodFarmBlock> COD_FARM = BLOCK_REGISTER.registerBlock("cod_farm", CodFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, CowFarmBlock> COW_FARM = BLOCK_REGISTER.registerBlock("cow_farm", CowFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, GlowSquidFarmBlock> GLOW_SQUID_FARM = BLOCK_REGISTER.registerBlock("glow_squid_farm", GlowSquidFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, HorseFarmBlock> HORSE_FARM = BLOCK_REGISTER.registerBlock("horse_farm", HorseFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, MooshroomFarmBlock> MOOSHROOM_FARM = BLOCK_REGISTER.registerBlock("mooshroom_farm", MooshroomFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, ParrotFarmBlock> PARROT_FARM = BLOCK_REGISTER.registerBlock("parrot_farm", ParrotFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, PigFarmBlock> PIG_FARM = BLOCK_REGISTER.registerBlock("pig_farm", PigFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, PufferfishFarmBlock> PUFFERFISH_FARM = BLOCK_REGISTER.registerBlock("pufferfish_farm", PufferfishFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, RabbitFarmBlock> RABBIT_FARM = BLOCK_REGISTER.registerBlock("rabbit_farm", RabbitFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SalmonFarmBlock> SALMON_FARM = BLOCK_REGISTER.registerBlock("salmon_farm", SalmonFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SheepFarmBlock> SHEEP_FARM = BLOCK_REGISTER.registerBlock("sheep_farm", SheepFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SnowGolemFarmBlock> SNOW_GOLEM_FARM = BLOCK_REGISTER.registerBlock("snow_golem_farm", SnowGolemFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SquidFarmBlock> SQUID_FARM = BLOCK_REGISTER.registerBlock("squid_farm", SquidFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, StriderFarmBlock> STRIDER_FARM = BLOCK_REGISTER.registerBlock("strider_farm", StriderFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, TropicalFishFarmBlock> TROPICAL_FISH_FARM = BLOCK_REGISTER.registerBlock("tropical_fish_farm", TropicalFishFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, TurtleFarmBlock> TURTLE_FARM = BLOCK_REGISTER.registerBlock("turtle_farm", TurtleFarmBlock::new, BlockBehaviour.Properties.of());


    // Neutral Mobs
    public static final DeferredHolder<Block, EndermanFarmBlock> ENDERMAN_FARM = BLOCK_REGISTER.registerBlock("enderman_farm", EndermanFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, GoatFarmBlock> GOAT_FARM = BLOCK_REGISTER.registerBlock("goat_farm", GoatFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, IronFarmBlock> IRON_FARM = BLOCK_REGISTER.registerBlock("iron_farm", IronFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SpiderFarmBlock> SPIDER_FARM = BLOCK_REGISTER.registerBlock("spider_farm", SpiderFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, PiglinFarmBlock> PIGLIN_FARM = BLOCK_REGISTER.registerBlock("piglin_farm", PiglinFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, ZombifiedPiglinFarmBlock> ZOMBIFIED_PIGLIN_FARM = BLOCK_REGISTER.registerBlock("zombified_piglin_farm", ZombifiedPiglinFarmBlock::new, BlockBehaviour.Properties.of());


    // Aggressive Mobs
    public static final DeferredHolder<Block, BlazeFarmBlock> BLAZE_FARM = BLOCK_REGISTER.registerBlock("blaze_farm", BlazeFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, CreakingFarmBlock> CREAKING_FARM = BLOCK_REGISTER.registerBlock("creaking_farm", CreakingFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, CreeperFarmBlock> CREEPER_FARM = BLOCK_REGISTER.registerBlock("creeper_farm", CreeperFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, DrownedFarmBlock> DROWNED_FARM = BLOCK_REGISTER.registerBlock("drowned_farm", DrownedFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, ElderGuardianFarmBlock> ELDER_GUARDIAN_FARM = BLOCK_REGISTER.registerBlock("elder_guardian_farm", ElderGuardianFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, EvokerFarmBlock> EVOKER_FARM = BLOCK_REGISTER.registerBlock("evoker_farm", EvokerFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, GhastFarmBlock> GHAST_FARM = BLOCK_REGISTER.registerBlock("ghast_farm", GhastFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, GuardianFarmBlock> GUARDIAN_FARM = BLOCK_REGISTER.registerBlock("guardian_farm", GuardianFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, HoglinFarmBlock> HOGLIN_FARM = BLOCK_REGISTER.registerBlock("hoglin_farm", HoglinFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, IllusionerFarmBlock> ILLUSIONER_FARM = BLOCK_REGISTER.registerBlock("illusioner_farm", IllusionerFarmBlock::new, BlockBehaviour.Properties.of());




    public static final DeferredHolder<Block, MagmaCubeFarmBlock> MAGMA_CUBE_FARM = BLOCK_REGISTER.registerBlock("magma_cube_farm", MagmaCubeFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, PhantomFarmBlock> PHANTOM_FARM = BLOCK_REGISTER.registerBlock("phantom_farm", PhantomFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, PillagerFarmBlock> PILLAGER_FARM = BLOCK_REGISTER.registerBlock("pillager_farm", PillagerFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, RavagerFarmBlock> RAVAGER_FARM = BLOCK_REGISTER.registerBlock("ravager_farm", RavagerFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, ShulkerFarmBlock> SHULKER_FARM = BLOCK_REGISTER.registerBlock("shulker_farm", ShulkerFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SkeletonFarmBlock> SKELETON_FARM = BLOCK_REGISTER.registerBlock("skeleton_farm", SkeletonFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SlimeFarmBlock> SLIME_FARM = BLOCK_REGISTER.registerBlock("slime_farm", SlimeFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, VindicatorFarmBlock> VINDICATOR_FARM = BLOCK_REGISTER.registerBlock("vindicator_farm", VindicatorFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, WardenFarmBlock> WARDEN_FARM = BLOCK_REGISTER.registerBlock("warden_farm", WardenFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, WitchFarmBlock> WITCH_FARM = BLOCK_REGISTER.registerBlock("witch_farm", WitchFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, WitherSkeletonFarmBlock> WITHER_SKELETON_FARM = BLOCK_REGISTER.registerBlock("wither_skeleton_farm", WitherSkeletonFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, WitherFarmBlock> WITHER_FARM = BLOCK_REGISTER.registerBlock("wither_farm", WitherFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, ZoglinFarmBlock> ZOGLIN_FARM = BLOCK_REGISTER.registerBlock("zoglin_farm", ZoglinFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, ZombieFarmBlock> ZOMBIE_FARM = BLOCK_REGISTER.registerBlock("zombie_farm", ZombieFarmBlock::new, BlockBehaviour.Properties.of());


    public static final DeferredHolder<Block, InventoryViewerBlock> INVENTORY_VIEWER = BLOCK_REGISTER.registerBlock("inventory_viewer", InventoryViewerBlock::new, BlockBehaviour.Properties.of());
    public static void init(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }

}
