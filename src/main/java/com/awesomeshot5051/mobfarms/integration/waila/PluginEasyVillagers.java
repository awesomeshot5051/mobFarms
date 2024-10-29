package com.awesomeshot5051.mobfarms.integration.waila;

import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.CreeperFarmBlock;
import com.awesomeshot5051.mobfarms.blocks.neutralMobs.IronFarmBlock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class PluginEasyVillagers implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(HUDHandlerVillager.INSTANCE, IronFarmBlock.class);
        registration.registerBlockComponent(HUDHandlerVillager.INSTANCE, CreeperFarmBlock.class);

        registration.registerBlockIcon(HUDHandlerVillager.INSTANCE, IronFarmBlock.class);
        registration.registerBlockIcon(HUDHandlerVillager.INSTANCE, CreeperFarmBlock.class);
    }

}
