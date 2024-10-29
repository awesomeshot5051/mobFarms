/*   0 */ package com.awesomeshot5051.mobfarms.integration.waila;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.CreeperFarmBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.IronFarmBlock;
/*   0 */ import snownee.jade.api.IComponentProvider;
/*   0 */ import snownee.jade.api.IWailaClientRegistration;
/*   0 */ import snownee.jade.api.IWailaPlugin;
/*   0 */ import snownee.jade.api.WailaPlugin;
/*   0 */ 
/*   0 */ @WailaPlugin
/*   0 */ public class PluginEasyVillagers implements IWailaPlugin {
/*   0 */   public void registerClient(IWailaClientRegistration registration) {
/*  14 */     registration.registerBlockComponent((IComponentProvider)HUDHandlerVillager.INSTANCE, IronFarmBlock.class);
/*  15 */     registration.registerBlockComponent((IComponentProvider)HUDHandlerVillager.INSTANCE, CreeperFarmBlock.class);
/*  17 */     registration.registerBlockIcon((IComponentProvider)HUDHandlerVillager.INSTANCE, IronFarmBlock.class);
/*  18 */     registration.registerBlockIcon((IComponentProvider)HUDHandlerVillager.INSTANCE, CreeperFarmBlock.class);
/*   0 */   }
/*   0 */ }
