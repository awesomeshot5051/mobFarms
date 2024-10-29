/*   0 */ package com.awesomeshot5051.mobfarms.integration;
/*   0 */ 
/*   0 */ import java.util.function.Supplier;
/*   0 */ import net.neoforged.bus.api.SubscribeEvent;
/*   0 */ import net.neoforged.fml.InterModComms;
/*   0 */ import net.neoforged.fml.ModList;
/*   0 */ import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
/*   0 */ 
/*   0 */ public class IMC {
/*   0 */   @SubscribeEvent
/*   0 */   public static void enqueueIMC(InterModEnqueueEvent event) {
/*  13 */     if (ModList.get().isLoaded("theoneprobe"))
/*  14 */       InterModComms.sendTo("theoneprobe", "getTheOneProbe", com.awesomeshot5051.mobfarms.integration.theoneprobe.TheOneProbeModule::new); 
/*   0 */   }
/*   0 */ }
