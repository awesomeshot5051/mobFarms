package com.awesomeshot5051.mobfarms.gui;

import com.awesomeshot5051.mobfarms.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.inventory.*;
import net.neoforged.api.distmarker.*;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.common.extensions.*;
import net.neoforged.neoforge.registries.*;

public class Containers {

    private static final DeferredRegister<MenuType<?>> MENU_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.MENU, Main.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<OutputContainer>> OUTPUT_CONTAINER = MENU_TYPE_REGISTER.register("output", () ->
            IMenuTypeExtension.create((windowId, inv, data) -> new OutputContainer(windowId, inv))
    );
    public static final DeferredHolder<MenuType<?>, MenuType<EmptyFarmContainer>> EMPTY_FARM_CONTAINER = MENU_TYPE_REGISTER.register("empty_farm", () ->
            IMenuTypeExtension.create((windowId, inv, data) -> new EmptyFarmContainer(windowId, inv, data.readBlockPos()))
    );

    public static void init(IEventBus eventBus) {
        MENU_TYPE_REGISTER.register(eventBus);
    }

    public static void initClient(IEventBus eventBus) {
        eventBus.addListener(Containers::onRegisterScreens);
    }

    @OnlyIn(Dist.CLIENT)
    public static void onRegisterScreens(RegisterMenuScreensEvent containers) {
        containers.register(OUTPUT_CONTAINER.get(), OutputScreen::new);
        containers.register(EMPTY_FARM_CONTAINER.get(), EmptyFarmScreen::new);
    }

}
