/*   0 */ package com.awesomeshot5051.mobfarms;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.advancements.MobFarmsTriggerInstance;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
/*   0 */ import com.awesomeshot5051.mobfarms.events.BlockEvents;
/*   0 */ import com.awesomeshot5051.mobfarms.events.GuiEvents;
/*   0 */ import com.awesomeshot5051.mobfarms.events.ModSoundEvents;
/*   0 */ import com.awesomeshot5051.mobfarms.gui.Containers;
/*   0 */ import com.awesomeshot5051.mobfarms.integration.IMC;
/*   0 */ import com.awesomeshot5051.mobfarms.items.ModItems;
/*   0 */ import com.awesomeshot5051.mobfarms.loottable.ModLootTables;
/*   0 */ import de.maxhenkel.corelib.CommonRegistry;
/*   0 */ import net.minecraft.server.level.ServerPlayer;
/*   0 */ import net.neoforged.api.distmarker.Dist;
/*   0 */ import net.neoforged.api.distmarker.OnlyIn;
/*   0 */ import net.neoforged.bus.api.IEventBus;
/*   0 */ import net.neoforged.fml.common.Mod;
/*   0 */ import net.neoforged.fml.config.ModConfig;
/*   0 */ import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
/*   0 */ import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
/*   0 */ import net.neoforged.fml.loading.FMLEnvironment;
/*   0 */ import net.neoforged.neoforge.common.NeoForge;
/*   0 */ import org.apache.logging.log4j.LogManager;
/*   0 */ import org.apache.logging.log4j.Logger;
/*   0 */ 
/*   0 */ @Mod("mob_farms")
/*   0 */ public class Main {
/*   0 */   public static final String MODID = "mob_farms";
/*   0 */   
/*  34 */   public static final Logger LOGGER = LogManager.getLogger("mob_farms");
/*   0 */   
/*   0 */   public static ServerConfig SERVER_CONFIG;
/*   0 */   
/*   0 */   public static ClientConfig CLIENT_CONFIG;
/*   0 */   
/*   0 */   public Main(IEventBus eventBus) {
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
/*   0 */     } 
/*   0 */   }
/*   0 */   
/*   0 */   public void commonSetup(FMLCommonSetupEvent event) {
/*  66 */     NeoForge.EVENT_BUS.register(new BlockEvents());
/*   0 */   }
/*   0 */   
/*   0 */   public boolean matches(ServerPlayer player, WitherFarmBlock witherFarmBlock) {
/*  71 */     return true;
/*   0 */   }
/*   0 */   
/*   0 */   @OnlyIn(Dist.CLIENT)
/*   0 */   public void clientSetup(FMLClientSetupEvent event) {
/*  76 */     ModTileEntities.clientSetup();
/*  78 */     NeoForge.EVENT_BUS.register(new ModSoundEvents());
/*  79 */     NeoForge.EVENT_BUS.register(new GuiEvents());
/*   0 */   }
/*   0 */ }
