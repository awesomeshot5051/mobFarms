package com.awesomeshot5051.mobfarms;

 import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
   private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "mob_farms");
   
   public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_MOB_FARMS = TAB_REGISTER.register("mob_farms", () -> CreativeModeTab.builder().icon((CREEPER_FARM.get)).displayItems(()).title((Component)Component.translatable("itemGroup.mob_farms")).build());
   
   public static void init(IEventBus eventBus) {
/*  85 */     TAB_REGISTER.register(eventBus);
   }
}
