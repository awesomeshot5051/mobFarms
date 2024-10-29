package com.awesomeshot5051.mobfarms;

//import com.awesomeshot5051.mobfarms.advancements.MobFarmsTriggerInstance;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.mobfarms.events.BlockEvents;
import com.awesomeshot5051.mobfarms.events.GuiEvents;
import com.awesomeshot5051.mobfarms.events.ModSoundEvents;
import com.awesomeshot5051.mobfarms.gui.Containers;
import com.awesomeshot5051.mobfarms.integration.IMC;
import com.awesomeshot5051.mobfarms.items.ModItems;
import com.awesomeshot5051.mobfarms.loottable.ModLootTables;
import de.maxhenkel.corelib.CommonRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
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
//        MobFarmsTriggerInstance.MobFarmsTrigger.TRIGGER_TYPES.register(eventBus);

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
//            eventBus.addListener(Main.this::onRegisterKeyBinds);
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

}
