/*   0 */ package com.awesomeshot5051.mobfarms;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.items.ModItems;
/*   0 */ import net.minecraft.core.registries.Registries;
/*   0 */ import net.minecraft.network.chat.Component;
/*   0 */ import net.minecraft.world.item.CreativeModeTab;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.minecraft.world.level.ItemLike;
/*   0 */ import net.neoforged.bus.api.IEventBus;
/*   0 */ import net.neoforged.neoforge.registries.DeferredHolder;
/*   0 */ import net.neoforged.neoforge.registries.DeferredRegister;
/*   0 */ 
/*   0 */ public class ModCreativeTabs {
/*  15 */   private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "mob_farms");
/*   0 */   
/*  17 */   public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_MOB_FARMS = TAB_REGISTER.register("mob_farms", () -> CreativeModeTab.builder().icon(()).displayItems(()).title((Component)Component.translatable("itemGroup.mob_farms")).build());
/*   0 */   
/*   0 */   public static void init(IEventBus eventBus) {
/*  85 */     TAB_REGISTER.register(eventBus);
/*   0 */   }
/*   0 */ }
