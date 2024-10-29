/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import net.minecraft.client.gui.screens.MenuScreens;
/*   0 */ import net.minecraft.core.registries.BuiltInRegistries;
/*   0 */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*   0 */ import net.minecraft.world.entity.player.Inventory;
/*   0 */ import net.minecraft.world.inventory.MenuType;
/*   0 */ import net.neoforged.api.distmarker.Dist;
/*   0 */ import net.neoforged.api.distmarker.OnlyIn;
/*   0 */ import net.neoforged.bus.api.IEventBus;
/*   0 */ import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
/*   0 */ import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
/*   0 */ import net.neoforged.neoforge.registries.DeferredHolder;
/*   0 */ import net.neoforged.neoforge.registries.DeferredRegister;
/*   0 */ 
/*   0 */ public class Containers {
/*  16 */   private static final DeferredRegister<MenuType<?>> MENU_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.MENU, "mob_farms");
/*   0 */   
/*  18 */   public static final DeferredHolder<MenuType<?>, MenuType<OutputContainer>> OUTPUT_CONTAINER = MENU_TYPE_REGISTER.register("output", () -> IMenuTypeExtension.create(()));
/*   0 */   
/*  21 */   public static final DeferredHolder<MenuType<?>, MenuType<InventoryViewerContainer>> INVENTORY_VIEWER_CONTAINER = MENU_TYPE_REGISTER.register("inventory_viewer", () -> IMenuTypeExtension.create(()));
/*   0 */   
/*   0 */   public static void init(IEventBus eventBus) {
/*  26 */     MENU_TYPE_REGISTER.register(eventBus);
/*   0 */   }
/*   0 */   
/*   0 */   public static void initClient(IEventBus eventBus) {
/*  30 */     eventBus.addListener(Containers::onRegisterScreens);
/*   0 */   }
/*   0 */   
/*   0 */   @OnlyIn(Dist.CLIENT)
/*   0 */   public static void onRegisterScreens(RegisterMenuScreensEvent containers) {
/*  35 */     containers.register((MenuType)OUTPUT_CONTAINER.get(), OutputScreen::new);
/*  36 */     containers.register((MenuType)INVENTORY_VIEWER_CONTAINER.get(), InventoryViewerScreen::new);
/*   0 */   }
/*   0 */ }
