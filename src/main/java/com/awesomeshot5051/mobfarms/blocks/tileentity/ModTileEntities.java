package com.awesomeshot5051.mobfarms.blocks.tileentity;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTileEntities {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.MODID);


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InventoryViewerTileentity>> INVENTORY_VIEWER = BLOCK_ENTITY_REGISTER.register("inventory_viewer", () ->
            BlockEntityType.Builder.of(InventoryViewerTileentity::new, ModBlocks.INVENTORY_VIEWER.get()).build(null)
    );
    // Passive Mobs
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChickenFarmTileentity>> CHICKEN_FARM = BLOCK_ENTITY_REGISTER.register("chicken_farm", () ->
            BlockEntityType.Builder.of(ChickenFarmTileentity::new, ModBlocks.CHICKEN_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CodFarmTileentity>> COD_FARM = BLOCK_ENTITY_REGISTER.register("cod_farm", () ->
            BlockEntityType.Builder.of(CodFarmTileentity::new, ModBlocks.COD_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CowFarmTileentity>> COW_FARM = BLOCK_ENTITY_REGISTER.register("cow_farm", () ->
            BlockEntityType.Builder.of(CowFarmTileentity::new, ModBlocks.COW_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GlowSquidFarmTileentity>> GLOW_SQUID_FARM = BLOCK_ENTITY_REGISTER.register("glow_squid_farm", () ->
            BlockEntityType.Builder.of(GlowSquidFarmTileentity::new, ModBlocks.GLOW_SQUID_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HorseFarmTileentity>> HORSE_FARM = BLOCK_ENTITY_REGISTER.register("horse_farm", () ->
            BlockEntityType.Builder.of(HorseFarmTileentity::new, ModBlocks.HORSE_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MooshroomFarmTileentity>> MOOSHROOM_FARM = BLOCK_ENTITY_REGISTER.register("mooshroom_farm", () ->
            BlockEntityType.Builder.of(MooshroomFarmTileentity::new, ModBlocks.MOOSHROOM_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ParrotFarmTileentity>> PARROT_FARM = BLOCK_ENTITY_REGISTER.register("parrot_farm", () ->
            BlockEntityType.Builder.of(ParrotFarmTileentity::new, ModBlocks.PARROT_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PigFarmTileentity>> PIG_FARM = BLOCK_ENTITY_REGISTER.register("pig_farm", () ->
            BlockEntityType.Builder.of(PigFarmTileentity::new, ModBlocks.PIG_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PufferfishFarmTileentity>> PUFFERFISH_FARM = BLOCK_ENTITY_REGISTER.register("pufferfish_farm", () ->
            BlockEntityType.Builder.of(PufferfishFarmTileentity::new, ModBlocks.PUFFERFISH_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RabbitFarmTileentity>> RABBIT_FARM = BLOCK_ENTITY_REGISTER.register("rabbit_farm", () ->
            BlockEntityType.Builder.of(RabbitFarmTileentity::new, ModBlocks.RABBIT_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SalmonFarmTileentity>> SALMON_FARM = BLOCK_ENTITY_REGISTER.register("salmon_farm", () ->
            BlockEntityType.Builder.of(SalmonFarmTileentity::new, ModBlocks.SALMON_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SheepFarmTileentity>> SHEEP_FARM = BLOCK_ENTITY_REGISTER.register("sheep_farm", () ->
            BlockEntityType.Builder.of(SheepFarmTileentity::new, ModBlocks.SHEEP_FARM.get()).build(null)
    );


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SnowGolemFarmTileentity>> SNOW_GOLEM_FARM = BLOCK_ENTITY_REGISTER.register("snow_golem_farm", () ->
            BlockEntityType.Builder.of(SnowGolemFarmTileentity::new, ModBlocks.SNOW_GOLEM_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SquidFarmTileentity>> SQUID_FARM = BLOCK_ENTITY_REGISTER.register("squid_farm", () ->
            BlockEntityType.Builder.of(SquidFarmTileentity::new, ModBlocks.SQUID_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StriderFarmTileentity>> STRIDER_FARM = BLOCK_ENTITY_REGISTER.register("strider_farm", () ->
            BlockEntityType.Builder.of(StriderFarmTileentity::new, ModBlocks.STRIDER_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TropicalFishFarmTileentity>> TROPICAL_FISH_FARM = BLOCK_ENTITY_REGISTER.register("tropical_fish_farm", () ->
            BlockEntityType.Builder.of(TropicalFishFarmTileentity::new, ModBlocks.TROPICAL_FISH_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TurtleFarmTileentity>> TURTLE_FARM = BLOCK_ENTITY_REGISTER.register("turtle_farm", () ->
            BlockEntityType.Builder.of(TurtleFarmTileentity::new, ModBlocks.TURTLE_FARM.get()).build(null)
    );


    // Neutral Mobs
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SpiderFarmTileentity>> SPIDER_FARM = BLOCK_ENTITY_REGISTER.register("spider_farm", () ->
            BlockEntityType.Builder.of(SpiderFarmTileentity::new, ModBlocks.SPIDER_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EndermanFarmTileentity>> ENDERMAN_FARM = BLOCK_ENTITY_REGISTER.register("enderman_farm", () ->
            BlockEntityType.Builder.of(EndermanFarmTileentity::new, ModBlocks.ENDERMAN_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoatFarmTileentity>> GOAT_FARM = BLOCK_ENTITY_REGISTER.register("goat_farm", () ->
            BlockEntityType.Builder.of(GoatFarmTileentity::new, ModBlocks.GOAT_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronFarmTileentity>> IRON_FARM = BLOCK_ENTITY_REGISTER.register("iron_farm", () ->
            BlockEntityType.Builder.of(IronFarmTileentity::new, ModBlocks.IRON_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PiglinFarmTileentity>> PIGLIN_FARM = BLOCK_ENTITY_REGISTER.register("piglin_farm", () ->
            BlockEntityType.Builder.of(PiglinFarmTileentity::new, ModBlocks.PIGLIN_FARM.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZombifiedPiglinFarmTileentity>> ZOMBIFIED_PIGLIN_FARM = BLOCK_ENTITY_REGISTER.register("zombified_piglin_farm", () ->
            BlockEntityType.Builder.of(ZombifiedPiglinFarmTileentity::new, ModBlocks.ZOMBIFIED_PIGLIN_FARM.get()).build(null)
    );


    //
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DrownedFarmTileentity>> DROWNED_FARM = BLOCK_ENTITY_REGISTER.register("drowned_farm", () ->
            BlockEntityType.Builder.of(DrownedFarmTileentity::new, ModBlocks.DROWNED_FARM.get()).build(null)
    );//    // Aggressive Mobs
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElderGuardianFarmTileentity>> ELDER_GUARDIAN_FARM = BLOCK_ENTITY_REGISTER.register("elder_guardian_farm", () ->
            BlockEntityType.Builder.of(ElderGuardianFarmTileentity::new, ModBlocks.ELDER_GUARDIAN_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvokerFarmTileentity>> EVOKER_FARM = BLOCK_ENTITY_REGISTER.register("evoker_farm", () ->
            BlockEntityType.Builder.of(EvokerFarmTileentity::new, ModBlocks.EVOKER_FARM.get()).build(null)
    );
    @OnlyIn(Dist.CLIENT)
    public static void clientSetup() {
        if (!Main.CLIENT_CONFIG.renderBlockContents.get()) {
            return;
        }
        //passive mobs
        BlockEntityRenderers.register(ModTileEntities.CHICKEN_FARM.get(), ChickenFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.COD_FARM.get(), CodFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.COW_FARM.get(), CowFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.GLOW_SQUID_FARM.get(), GlowSquidFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.HORSE_FARM.get(), HorseFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.MOOSHROOM_FARM.get(), MooshroomFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PARROT_FARM.get(), ParrotFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PIG_FARM.get(), PigFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PUFFERFISH_FARM.get(), PufferfishFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.RABBIT_FARM.get(), RabbitFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SALMON_FARM.get(), SalmonFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SHEEP_FARM.get(), SheepFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SNOW_GOLEM_FARM.get(), SnowGolemFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SQUID_FARM.get(), SquidFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.STRIDER_FARM.get(), StriderFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.TROPICAL_FISH_FARM.get(), TropicalFishFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.TURTLE_FARM.get(), TurtleFarmRenderer::new);
//
//        //neutral mobs
        BlockEntityRenderers.register(ModTileEntities.SPIDER_FARM.get(), SpiderFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ENDERMAN_FARM.get(), EndermanFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.GOAT_FARM.get(), GoatFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.IRON_FARM.get(), IronFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PIGLIN_FARM.get(), PiglinFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ZOMBIFIED_PIGLIN_FARM.get(), ZombifiedPiglinFarmRenderer::new);
//
//        //aggressive mobs
        BlockEntityRenderers.register(ModTileEntities.BLAZE_FARM.get(), BlazeFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.CREEPER_FARM.get(), CreeperFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.DROWNED_FARM.get(), DrownedFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ELDER_GUARDIAN_FARM.get(), ElderGuardianFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.EVOKER_FARM.get(), EvokerFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.GHAST_FARM.get(), GhastFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.GUARDIAN_FARM.get(), GuardianFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.HOGLIN_FARM.get(), HoglinFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ILLUSIONER_FARM.get(), IllusionerFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.MAGMA_CUBE_FARM.get(), MagmaCubeFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PHANTOM_FARM.get(), PhantomFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PILLAGER_FARM.get(), PillagerFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.RAVAGER_FARM.get(), RavagerFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SHULKER_FARM.get(), ShulkerFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SKELETON_FARM.get(), SkeletonFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SLIME_FARM.get(), SlimeFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.WITHER_FARM.get(), WitherFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.VINDICATOR_FARM.get(), VindicatorFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.WARDEN_FARM.get(), WardenFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.WITCH_FARM.get(), WitchFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.WITHER_SKELETON_FARM.get(), WitherSkeletonFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ZOMBIE_FARM.get(), ZombieFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ZOGLIN_FARM.get(), ZoglinFarmRenderer::new);


    }

    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        //passive mobs
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHICKEN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COD_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COW_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GLOW_SQUID_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HORSE_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MOOSHROOM_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PARROT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PIG_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PUFFERFISH_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RABBIT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SALMON_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SHEEP_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SNOW_GOLEM_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SQUID_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STRIDER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TROPICAL_FISH_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TURTLE_FARM.get(), (object, context) -> object.getItemHandler());
//
//        //neutral mobs
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPIDER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ENDERMAN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOAT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, IRON_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PIGLIN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ZOMBIFIED_PIGLIN_FARM.get(), (object, context) -> object.getItemHandler());
//
//        //aggressive mobs
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BLAZE_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CREEPER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DROWNED_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ELDER_GUARDIAN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EVOKER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GHAST_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GUARDIAN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HOGLIN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ILLUSIONER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MAGMA_CUBE_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PHANTOM_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PILLAGER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RAVAGER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SHULKER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SKELETON_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SLIME_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WITHER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, VINDICATOR_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WARDEN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WITCH_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WITHER_SKELETON_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ZOGLIN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ZOMBIE_FARM.get(), (object, context) -> object.getItemHandler());

    }    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GhastFarmTileentity>> GHAST_FARM = BLOCK_ENTITY_REGISTER.register("ghast_farm", () ->
            BlockEntityType.Builder.of(GhastFarmTileentity::new, ModBlocks.GHAST_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeFarmTileentity>> BLAZE_FARM = BLOCK_ENTITY_REGISTER.register("blaze_farm", () ->
            BlockEntityType.Builder.of(BlazeFarmTileentity::new, ModBlocks.BLAZE_FARM.get()).build(null)
    );
    //
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreeperFarmTileentity>> CREEPER_FARM = BLOCK_ENTITY_REGISTER.register("creeper_farm", () ->
            BlockEntityType.Builder.of(CreeperFarmTileentity::new, ModBlocks.CREEPER_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GuardianFarmTileentity>> GUARDIAN_FARM = BLOCK_ENTITY_REGISTER.register("guardian_farm", () ->
            BlockEntityType.Builder.of(GuardianFarmTileentity::new, ModBlocks.GUARDIAN_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HoglinFarmTileentity>> HOGLIN_FARM = BLOCK_ENTITY_REGISTER.register("hoglin_farm", () ->
            BlockEntityType.Builder.of(HoglinFarmTileentity::new, ModBlocks.HOGLIN_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IllusionerFarmTileentity>> ILLUSIONER_FARM = BLOCK_ENTITY_REGISTER.register("illusioner_farm", () ->
            BlockEntityType.Builder.of(IllusionerFarmTileentity::new, ModBlocks.ILLUSIONER_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MagmaCubeFarmTileentity>> MAGMA_CUBE_FARM = BLOCK_ENTITY_REGISTER.register("magma_cube_farm", () ->
            BlockEntityType.Builder.of(MagmaCubeFarmTileentity::new, ModBlocks.MAGMA_CUBE_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PhantomFarmTileentity>> PHANTOM_FARM = BLOCK_ENTITY_REGISTER.register("phantom_farm", () ->
            BlockEntityType.Builder.of(PhantomFarmTileentity::new, ModBlocks.PHANTOM_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PillagerFarmTileentity>> PILLAGER_FARM = BLOCK_ENTITY_REGISTER.register("pillager_farm", () ->
            BlockEntityType.Builder.of(PillagerFarmTileentity::new, ModBlocks.PILLAGER_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RavagerFarmTileentity>> RAVAGER_FARM = BLOCK_ENTITY_REGISTER.register("ravager_farm", () ->
            BlockEntityType.Builder.of(RavagerFarmTileentity::new, ModBlocks.RAVAGER_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ShulkerFarmTileentity>> SHULKER_FARM = BLOCK_ENTITY_REGISTER.register("shulker_farm", () ->
            BlockEntityType.Builder.of(ShulkerFarmTileentity::new, ModBlocks.SHULKER_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SkeletonFarmTileentity>> SKELETON_FARM = BLOCK_ENTITY_REGISTER.register("skeleton_farm", () ->
            BlockEntityType.Builder.of(SkeletonFarmTileentity::new, ModBlocks.SKELETON_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SlimeFarmTileentity>> SLIME_FARM = BLOCK_ENTITY_REGISTER.register("slime_farm", () ->
            BlockEntityType.Builder.of(SlimeFarmTileentity::new, ModBlocks.SLIME_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VindicatorFarmTileentity>> VINDICATOR_FARM = BLOCK_ENTITY_REGISTER.register("vindicator_farm", () ->
            BlockEntityType.Builder.of(VindicatorFarmTileentity::new, ModBlocks.VINDICATOR_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WardenFarmTileentity>> WARDEN_FARM = BLOCK_ENTITY_REGISTER.register("warden_farm", () ->
            BlockEntityType.Builder.of(WardenFarmTileentity::new, ModBlocks.WARDEN_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitchFarmTileentity>> WITCH_FARM = BLOCK_ENTITY_REGISTER.register("witch_farm", () ->
            BlockEntityType.Builder.of(WitchFarmTileentity::new, ModBlocks.WITCH_FARM.get()).build(null)
    );


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitherFarmTileentity>> WITHER_FARM = BLOCK_ENTITY_REGISTER.register("wither_farm", () ->
            BlockEntityType.Builder.of(WitherFarmTileentity::new, ModBlocks.WITHER_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitherSkeletonFarmTileentity>> WITHER_SKELETON_FARM = BLOCK_ENTITY_REGISTER.register("wither_skeleton_farm", () ->
            BlockEntityType.Builder.of(WitherSkeletonFarmTileentity::new, ModBlocks.WITHER_SKELETON_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZoglinFarmTileentity>> ZOGLIN_FARM = BLOCK_ENTITY_REGISTER.register("zoglin_farm", () ->
            BlockEntityType.Builder.of(ZoglinFarmTileentity::new, ModBlocks.ZOGLIN_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZombieFarmTileentity>> ZOMBIE_FARM = BLOCK_ENTITY_REGISTER.register("zombie_farm", () ->
            BlockEntityType.Builder.of(ZombieFarmTileentity::new, ModBlocks.ZOMBIE_FARM.get()).build(null)
    );




    public static void init(IEventBus eventBus) {
        BLOCK_ENTITY_REGISTER.register(eventBus);
    }


}
