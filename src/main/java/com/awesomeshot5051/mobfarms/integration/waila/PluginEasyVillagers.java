package com.awesomeshot5051.mobfarms.integration.waila;

import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.CreeperFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.IronFarmBlock;
import snownee.jade.api.IComponentProvider;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class PluginEasyVillagers implements IWailaPlugin {
   public void registerClient(IWailaClientRegistration registration) {
/*  14 */     registration.registerBlockComponent((IComponentProvider)HUDHandlerVillager.INSTANCE, IronFarmBlock.class);
     registration.registerBlockComponent((IComponentProvider)HUDHandlerVillager.INSTANCE, CreeperFarmBlock.class);
     registration.registerBlockIcon((IComponentProvider)HUDHandlerVillager.INSTANCE, IronFarmBlock.class);
/*  18 */     registration.registerBlockIcon((IComponentProvider)HUDHandlerVillager.INSTANCE, CreeperFarmBlock.class);
   }
}
