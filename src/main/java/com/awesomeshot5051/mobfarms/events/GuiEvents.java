/*   0 */ package com.awesomeshot5051.mobfarms.events;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.ClientConfig;
/*   0 */ import com.awesomeshot5051.mobfarms.Main;
/*   0 */ import net.minecraft.client.Minecraft;
/*   0 */ import net.minecraft.client.gui.screens.Screen;
/*   0 */ import net.minecraft.client.gui.screens.inventory.MerchantScreen;
/*   0 */ import net.minecraft.client.resources.sounds.SimpleSoundInstance;
/*   0 */ import net.minecraft.client.resources.sounds.SoundInstance;
/*   0 */ import net.minecraft.core.Holder;
/*   0 */ import net.minecraft.sounds.SoundEvents;
/*   0 */ import net.neoforged.api.distmarker.Dist;
/*   0 */ import net.neoforged.api.distmarker.OnlyIn;
/*   0 */ import net.neoforged.bus.api.SubscribeEvent;
/*   0 */ import net.neoforged.neoforge.client.event.InputEvent;
/*   0 */ import net.neoforged.neoforge.client.event.ScreenEvent;
/*   0 */ 
/*   0 */ public class GuiEvents {
/*   0 */   @OnlyIn(Dist.CLIENT)
/*   0 */   @SubscribeEvent
/*   0 */   public void onOpenScreen(ScreenEvent.Init.Post event) {
/*   0 */     MerchantScreen merchantScreen;
/*  21 */     Screen screen = event.getScreen();
/*  21 */     if (screen instanceof MerchantScreen) {
/*  21 */       merchantScreen = (MerchantScreen)screen;
/*   0 */     } else {
/*   0 */       return;
/*   0 */     } 
/*  24 */     if ((Minecraft.getInstance()).player == null)
/*   0 */       return; 
/*  31 */     ClientConfig.CycleTradesButtonLocation loc = (ClientConfig.CycleTradesButtonLocation)Main.CLIENT_CONFIG.cycleTradesButtonLocation.get();
/*  33 */     if (loc.equals(ClientConfig.CycleTradesButtonLocation.NONE))
/*   0 */       return; 
/*  39 */     switch (loc) {
/*   0 */       default:
/*  42 */         posX = merchantScreen.getGuiLeft() + 107;
/*   0 */         return;
/*   0 */       case TOP_RIGHT:
/*   0 */         break;
/*   0 */     } 
/*  45 */     int posX = merchantScreen.getGuiLeft() + 250;
/*   0 */   }
/*   0 */   
/*   0 */   @OnlyIn(Dist.CLIENT)
/*   0 */   @SubscribeEvent
/*   0 */   public void onKeyInput(InputEvent.Key event) {
/*  54 */     Minecraft mc = Minecraft.getInstance();
/*  55 */     if (mc.player == null)
/*   0 */       return; 
/*  63 */     Screen currentScreen = mc.screen;
/*  65 */     if (currentScreen instanceof MerchantScreen) {
/*  65 */       MerchantScreen screen = (MerchantScreen)currentScreen;
/*   0 */     } else {
/*   0 */       return;
/*   0 */     } 
/*  69 */     mc.getSoundManager().play((SoundInstance)SimpleSoundInstance.forUI((Holder)SoundEvents.UI_BUTTON_CLICK, 1.0F));
/*   0 */   }
/*   0 */ }
