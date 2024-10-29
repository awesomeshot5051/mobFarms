package com.awesomeshot5051.mobfarms.events;

import com.awesomeshot5051.mobfarms.ClientConfig;
import com.awesomeshot5051.mobfarms.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

public class GuiEvents {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public void onOpenScreen(ScreenEvent.Init.Post event) {
     MerchantScreen merchantScreen;
/*  21 */     Screen screen = event.getScreen();
/*  21 */     if (screen instanceof MerchantScreen) {
/*  21 */       merchantScreen = (MerchantScreen)screen;
     } else {
       return;
     } 
/*  24 */     if ((Minecraft.getInstance()).player == null)
       return; 
/*  31 */     ClientConfig.CycleTradesButtonLocation loc = (ClientConfig.CycleTradesButtonLocation)Main.CLIENT_CONFIG.cycleTradesButtonLocation.get();
/*  33 */     if (loc.equals(ClientConfig.CycleTradesButtonLocation.NONE))
       return; 
/*  39 */     switch (loc) {
       default:
/*  42 */         posX = merchantScreen.getGuiLeft() + 107;
         return;
       case TOP_RIGHT:
         break;
     } 
/*  45 */     int posX = merchantScreen.getGuiLeft() + 250;
   }
   
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public void onKeyInput(InputEvent.Key event) {
/*  54 */     Minecraft mc = Minecraft.getInstance();
/*  55 */     if (mc.player == null)
       return; 
/*  63 */     Screen currentScreen = mc.screen;
/*  65 */     if (currentScreen instanceof MerchantScreen) {
/*  65 */       MerchantScreen screen = (MerchantScreen)currentScreen;
     } else {
       return;
     } 
/*  69 */     mc.getSoundManager().play((SoundInstance)SimpleSoundInstance.forUI((Holder)SoundEvents.UI_BUTTON_CLICK, 1.0F));
   }
}
