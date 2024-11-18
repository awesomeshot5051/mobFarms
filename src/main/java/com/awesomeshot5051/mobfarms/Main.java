package com.awesomeshot5051.mobfarms;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.mobfarms.events.BlockEvents;
import com.awesomeshot5051.mobfarms.events.GuiEvents;
import com.awesomeshot5051.mobfarms.events.ModSoundEvents;
import com.awesomeshot5051.mobfarms.gui.Containers;
import com.awesomeshot5051.mobfarms.integration.IMC;
import com.awesomeshot5051.mobfarms.items.ModItems;
import com.awesomeshot5051.mobfarms.items.render.InventoryViewerItemRenderer;
import com.awesomeshot5051.mobfarms.items.render.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.items.render.neutralMobs.*;
import com.awesomeshot5051.mobfarms.items.render.passiveMobs.*;
import com.awesomeshot5051.mobfarms.loottable.ModLootTables;
import de.maxhenkel.corelib.CommonRegistry;
import de.maxhenkel.corelib.client.CustomRenderItemExtension;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main {


    public static final String MODID = "mob_farms";

    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ServerConfig SERVER_CONFIG;
    public static ClientConfig CLIENT_CONFIG;
//    public static KeyMapping PICKUP_KEY;
//    public static KeyMapping CYCLE_TRADES_KEY;

    public Main(IEventBus eventBus) {
        eventBus.addListener(this::commonSetup);
//        eventBus.addListener(this::onRegisterPayloadHandler);
        eventBus.addListener(IMC::enqueueIMC);
        eventBus.addListener(ModTileEntities::onRegisterCapabilities);

        ModBlocks.init(eventBus);
        ModItems.init(eventBus);
        ModTileEntities.init(eventBus);
        Containers.init(eventBus);
        ModCreativeTabs.init(eventBus);
        ModLootTables.init(eventBus);

        SERVER_CONFIG = CommonRegistry.registerConfig(MODID, ModConfig.Type.SERVER, ServerConfig.class);
        CLIENT_CONFIG = CommonRegistry.registerConfig(MODID, ModConfig.Type.CLIENT, ClientConfig.class);

        if (FMLEnvironment.dist.isClient()) {
            eventBus.addListener(Main.this::clientSetup);
            eventBus.addListener(Main.this::onRegisterClientExtensions);
            Containers.initClient(eventBus);
        }
    }

    public void commonSetup(FMLCommonSetupEvent event) {
//        NeoForge.EVENT_BUS.register(new ModEvents());
        NeoForge.EVENT_BUS.register(new BlockEvents());
        // Register your custom dispenser behavior for dye items
    }

    public boolean matches(ServerPlayer player, WitherFarmBlock witherFarmBlock) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void clientSetup(FMLClientSetupEvent event) {
        ModTileEntities.clientSetup();

        NeoForge.EVENT_BUS.register(new ModSoundEvents());
        NeoForge.EVENT_BUS.register(new GuiEvents());

    }

//    public void onRegisterPayloadHandler(RegisterPayloadHandlersEvent event) {
//        PayloadRegistrar registrar = event.registrar(MODID).versioned("0");
//        CommonRegistry.registerMessage(registrar, MessageVillagerParticles.class);
//        CommonRegistry.registerMessage(registrar, MessagePickUpVillager.class);
//        CommonRegistry.registerMessage(registrar, MessageSelectTrade.class);
//        CommonRegistry.registerMessage(registrar, MessageCycleTrades.class);
//    }

//    @OnlyIn(Dist.CLIENT)
//    public void onRegisterKeyBinds(RegisterKeyMappingsEvent event) {
//        PICKUP_KEY = new KeyMapping("key.mob_farms.pick_up", GLFW.GLFW_KEY_V, "category.mob_farms");
//        CYCLE_TRADES_KEY = new KeyMapping("key.mob_farms.cycle_trades", GLFW.GLFW_KEY_C, "category.mob_farms");
//        event.register(PICKUP_KEY);
//        event.register(CYCLE_TRADES_KEY);
//    }
@OnlyIn(Dist.CLIENT)
public void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
    event.registerItem(new CustomRenderItemExtension(new InventoryViewerItemRenderer()), ModItems.INVENTORY_VIEWER);
    event.registerItem(new CustomRenderItemExtension(new ChickenFarmItemRenderer()), ModItems.CHICKEN_FARM);
    event.registerItem(new CustomRenderItemExtension(new CodFarmItemRenderer()), ModItems.COD_FARM);
    event.registerItem(new CustomRenderItemExtension(new CowFarmItemRenderer()), ModItems.COW_FARM);
    event.registerItem(new CustomRenderItemExtension(new GlowSquidFarmItemRenderer()), ModItems.GLOW_SQUID_FARM);
    event.registerItem(new CustomRenderItemExtension(new HorseFarmItemRenderer()), ModItems.HORSE_FARM);
    event.registerItem(new CustomRenderItemExtension(new MooshroomFarmItemRenderer()), ModItems.MOOSHROOM_FARM);
    event.registerItem(new CustomRenderItemExtension(new ParrotFarmItemRenderer()), ModItems.PARROT_FARM);
    event.registerItem(new CustomRenderItemExtension(new PigFarmItemRenderer()), ModItems.PIG_FARM);
    event.registerItem(new CustomRenderItemExtension(new PufferfishFarmItemRenderer()), ModItems.PUFFERFISH_FARM);
    event.registerItem(new CustomRenderItemExtension(new RabbitFarmItemRenderer()), ModItems.RABBIT_FARM);
    event.registerItem(new CustomRenderItemExtension(new SalmonFarmItemRenderer()), ModItems.SALMON_FARM);
    event.registerItem(new CustomRenderItemExtension(new SheepFarmItemRenderer()), ModItems.SHEEP_FARM);
    event.registerItem(new CustomRenderItemExtension(new SnowGolemFarmItemRenderer()), ModItems.SNOW_GOLEM_FARM);
    event.registerItem(new CustomRenderItemExtension(new SquidFarmItemRenderer()), ModItems.SQUID_FARM);
    event.registerItem(new CustomRenderItemExtension(new StriderFarmItemRenderer()), ModItems.STRIDER_FARM);
    event.registerItem(new CustomRenderItemExtension(new TropicalFishFarmItemRenderer()), ModItems.TROPICAL_FISH_FARM);
    event.registerItem(new CustomRenderItemExtension(new TurtleFarmItemRenderer()), ModItems.TURTLE_FARM);

// Neutral mobs
    event.registerItem(new CustomRenderItemExtension(new SpiderFarmItemRenderer()), ModItems.SPIDER_FARM);
    event.registerItem(new CustomRenderItemExtension(new EndermanFarmItemRenderer()), ModItems.ENDERMAN_FARM);
    event.registerItem(new CustomRenderItemExtension(new GoatFarmItemRenderer()), ModItems.GOAT_FARM);
    event.registerItem(new CustomRenderItemExtension(new IronFarmItemRenderer()), ModItems.IRON_FARM);
    event.registerItem(new CustomRenderItemExtension(new PiglinFarmItemRenderer()), ModItems.PIGLIN_FARM);
    event.registerItem(new CustomRenderItemExtension(new ZombifiedPiglinFarmItemRenderer()), ModItems.ZOMBIFIED_PIGLIN_FARM);

// Aggressive mobs
    event.registerItem(new CustomRenderItemExtension(new BlazeFarmItemRenderer()), ModItems.BLAZE_FARM);
    event.registerItem(new CustomRenderItemExtension(new CreakingFarmItemRenderer()), ModItems.CREAKING_FARM);
    event.registerItem(new CustomRenderItemExtension(new CreeperFarmItemRenderer()), ModItems.CREEPER_FARM);
    event.registerItem(new CustomRenderItemExtension(new DrownedFarmItemRenderer()), ModItems.DROWNED_FARM);
    event.registerItem(new CustomRenderItemExtension(new ElderGuardianFarmItemRenderer()), ModItems.ELDER_GUARDIAN_FARM);
    event.registerItem(new CustomRenderItemExtension(new EvokerFarmItemRenderer()), ModItems.EVOKER_FARM);
    event.registerItem(new CustomRenderItemExtension(new GhastFarmItemRenderer()), ModItems.GHAST_FARM);
    event.registerItem(new CustomRenderItemExtension(new GuardianFarmItemRenderer()), ModItems.GUARDIAN_FARM);
    event.registerItem(new CustomRenderItemExtension(new HoglinFarmItemRenderer()), ModItems.HOGLIN_FARM);
    event.registerItem(new CustomRenderItemExtension(new IllusionerFarmItemRenderer()), ModItems.ILLUSIONER_FARM);
    event.registerItem(new CustomRenderItemExtension(new MagmaCubeFarmItemRenderer()), ModItems.MAGMA_CUBE_FARM);
    event.registerItem(new CustomRenderItemExtension(new PhantomFarmItemRenderer()), ModItems.PHANTOM_FARM);
    event.registerItem(new CustomRenderItemExtension(new PillagerFarmItemRenderer()), ModItems.PILLAGER_FARM);
    event.registerItem(new CustomRenderItemExtension(new RavagerFarmItemRenderer()), ModItems.RAVAGER_FARM);
    event.registerItem(new CustomRenderItemExtension(new ShulkerFarmItemRenderer()), ModItems.SHULKER_FARM);
    event.registerItem(new CustomRenderItemExtension(new SkeletonFarmItemRenderer()), ModItems.SKELETON_FARM);
    event.registerItem(new CustomRenderItemExtension(new SlimeFarmItemRenderer()), ModItems.SLIME_FARM);
    event.registerItem(new CustomRenderItemExtension(new VindicatorFarmItemRenderer()), ModItems.VINDICATOR_FARM);
    event.registerItem(new CustomRenderItemExtension(new WardenFarmItemRenderer()), ModItems.WARDEN_FARM);
    event.registerItem(new CustomRenderItemExtension(new WitchFarmItemRenderer()), ModItems.WITCH_FARM);
    event.registerItem(new CustomRenderItemExtension(new WitherFarmItemRenderer()), ModItems.WITHER_FARM);
    event.registerItem(new CustomRenderItemExtension(new WitherSkeletonFarmItemRenderer()), ModItems.WITHER_SKELETON_FARM);
    event.registerItem(new CustomRenderItemExtension(new ZoglinFarmItemRenderer()), ModItems.ZOGLIN_FARM);
    event.registerItem(new CustomRenderItemExtension(new ZombieFarmItemRenderer()), ModItems.ZOMBIE_FARM);

}
}
