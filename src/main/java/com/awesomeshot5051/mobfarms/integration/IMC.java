package com.awesomeshot5051.mobfarms.integration;

import java.util.function.Supplier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.InterModComms;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;

public class IMC {
   @SubscribeEvent
   public static void enqueueIMC(InterModEnqueueEvent event) {
/*  13 */     if (ModList.get().isLoaded("theoneprobe"))
/*  14 */       InterModComms.sendTo("theoneprobe", "getTheOneProbe", com.awesomeshot5051.mobfarms.integration.theoneprobe.TheOneProbeModule::new); 
   }
}
