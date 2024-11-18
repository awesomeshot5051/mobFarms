package com.awesomeshot5051.mobfarms;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_MOB_FARMS = TAB_REGISTER.register("mob_farms", () -> {
        return CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModItems.CREEPER_FARM.get())) // Use your custom item here
                .displayItems((features, output) -> {

                    //passive mobs
                    output.accept(new ItemStack(ModBlocks.CHICKEN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.COD_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.COW_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.GLOW_SQUID_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.HORSE_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.MOOSHROOM_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.PARROT_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.PIG_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.PUFFERFISH_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.RABBIT_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.SALMON_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.SHEEP_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.SNOW_GOLEM_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.SQUID_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.STRIDER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.TROPICAL_FISH_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.TURTLE_FARM.get()));


                    //neutral mobs
                    output.accept(new ItemStack(ModBlocks.SPIDER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.ENDERMAN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.GOAT_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.IRON_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.PIGLIN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.ZOMBIFIED_PIGLIN_FARM.get()));


                    //aggressive mobs
                    output.accept(new ItemStack(ModBlocks.BLAZE_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.CREAKING_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.CREEPER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.DROWNED_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.ELDER_GUARDIAN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.EVOKER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.GHAST_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.GUARDIAN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.HOGLIN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.ILLUSIONER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.MAGMA_CUBE_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.PHANTOM_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.PILLAGER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.RAVAGER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.SHULKER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.SKELETON_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.SLIME_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.WITHER_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.VINDICATOR_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.WARDEN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.WITCH_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.WITHER_SKELETON_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.ZOGLIN_FARM.get()));
                    output.accept(new ItemStack(ModBlocks.ZOMBIE_FARM.get()));


                    output.accept(new ItemStack(ModBlocks.INVENTORY_VIEWER.get()));

                })
                .title(Component.translatable("itemGroup.mob_farms"))
                .build();
    });

    public static void init(IEventBus eventBus) {
        TAB_REGISTER.register(eventBus);
    }

}
