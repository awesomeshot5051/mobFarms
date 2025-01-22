package com.awesomeshot5051.mobfarms.integration.waila;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class PluginEasyVillagers implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        for (var sidedBlock : ModBlocks.BLOCK_REGISTER.getEntries()) {
            registration.registerBlockComponent(HUDHandlerVillager.INSTANCE, sidedBlock.get().getClass());
        }
        for (var sidedBlock : ModBlocks.BLOCK_REGISTER.getEntries()) {
            registration.registerBlockIcon(HUDHandlerVillager.INSTANCE, sidedBlock.get().getClass());
        }
    }

}
