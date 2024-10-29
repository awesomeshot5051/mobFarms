package com.awesomeshot5051.mobfarms.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CookedmeatConfigScreen extends AbstractContainerScreen<CookedmeatConfigMenu> {
    private final static HashMap<String, Object> guistate = CookedmeatConfigMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Checkbox isCookeed;

    public CookedmeatConfigScreen(CookedmeatConfigMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }

    private static final ResourceLocation texture = ResourceLocation.parse("guimaker:textures/screens/cookedmeat_config.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    @Override
    public void init() {
        super.init();
        isCookeed = Checkbox.builder(Component.translatable("gui.guimaker.cookedmeat_config.isCookeed"), this.font).pos(this.leftPos + 78, this.topPos + 61)

                .build();
        guistate.put("checkbox:isCookeed", isCookeed);
        this.addRenderableWidget(isCookeed);
    }
}
