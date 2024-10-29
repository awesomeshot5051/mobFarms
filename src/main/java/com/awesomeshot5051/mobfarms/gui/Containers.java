package com.awesomeshot5051.mobfarms.gui;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Containers {
/*  16 */   private static final DeferredRegister<MenuType<?>> MENU_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.MENU, "mob_farms");
   
/*  18 */   public static final DeferredHolder<MenuType<?>, MenuType<OutputContainer>> OUTPUT_CONTAINER = MENU_TYPE_REGISTER.register("output", () -> IMenuTypeExtension.create(()));
   
/*  21 */   public static final DeferredHolder<MenuType<?>, MenuType<InventoryViewerContainer>> INVENTORY_VIEWER_CONTAINER = MENU_TYPE_REGISTER.register("inventory_viewer", () -> IMenuTypeExtension.create(()));
   
   public static void init(IEventBus eventBus) {
/*  26 */     MENU_TYPE_REGISTER.register(eventBus);
   }
   
   public static void initClient(IEventBus eventBus) {
/*  30 */     eventBus.addListener(Containers::onRegisterScreens);
   }
   
   @OnlyIn(Dist.CLIENT)
   public static void onRegisterScreens(RegisterMenuScreensEvent containers) {
/*  35 */     containers.register((MenuType)OUTPUT_CONTAINER.get(), OutputScreen::new);
/*  36 */     containers.register((MenuType)INVENTORY_VIEWER_CONTAINER.get(), InventoryViewerScreen::new);
   }
}
