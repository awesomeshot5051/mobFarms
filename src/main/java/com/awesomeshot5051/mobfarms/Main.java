package com.awesomeshot5051.mobfarms;

import com.awesomeshot5051.mobfarms.advancements.MobFarmsTriggerInstance;
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

@Mod("mob_farms")
public class Main {
   public static final String MODID = "mob_farms";
   
/*  34 */   public static final Logger LOGGER = LogManager.getLogger("mob_farms");
   
   public static ServerConfig SERVER_CONFIG;
   
   public static ClientConfig CLIENT_CONFIG;
   
   public Main(IEventBus eventBus) {
/*  41 */     eventBus.addListener(this::commonSetup);
/*  43 */     eventBus.addListener(IMC::enqueueIMC);
/*  44 */     eventBus.addListener(ModTileEntities::onRegisterCapabilities);
/*  45 */     MobFarmsTriggerInstance.MobFarmsTrigger.TRIGGER_TYPES.register(eventBus);
/*  47 */     ModBlocks.init(eventBus);
/*  48 */     ModItems.init(eventBus);
/*  49 */     ModTileEntities.init(eventBus);
/*  50 */     Containers.init(eventBus);
/*  51 */     ModCreativeTabs.init(eventBus);
/*  52 */     ModLootTables.init(eventBus);
/*  54 */     SERVER_CONFIG = (ServerConfig)CommonRegistry.registerConfig("mob_farms", ModConfig.Type.SERVER, ServerConfig.class);
/*  55 */     CLIENT_CONFIG = (ClientConfig)CommonRegistry.registerConfig("mob_farms", ModConfig.Type.CLIENT, ClientConfig.class);
/*  57 */     if (FMLEnvironment.dist.isClient()) {
/*  58 */       eventBus.addListener(this::clientSetup);
/*  60 */       Containers.initClient(eventBus);
     } 
   }
   
   public void commonSetup(FMLCommonSetupEvent event) {
/*  66 */     NeoForge.EVENT_BUS.register(new BlockEvents());
   }
   
   public boolean matches(ServerPlayer player, WitherFarmBlock witherFarmBlock) {
/*  71 */     return true;
   }
   
   @OnlyIn(Dist.CLIENT)
   public void clientSetup(FMLClientSetupEvent event) {
/*  76 */     ModTileEntities.clientSetup();
/*  78 */     NeoForge.EVENT_BUS.register(new ModSoundEvents());
/*  79 */     NeoForge.EVENT_BUS.register(new GuiEvents());
   }
}
