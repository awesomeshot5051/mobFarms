package com.awesomeshot5051.mobfarms.gui;

import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public abstract class InputOutputScreen<T extends AbstractContainerMenu> extends ScreenBase<T> {
/*  14 */   public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mob_farms", "textures/gui/container/input_output.png");
   
   private final Inventory playerInventory;
   
   public InputOutputScreen(T container, Inventory playerInventory, Component name) {
/*  19 */     super(BACKGROUND, (AbstractContainerMenu)container, playerInventory, name);
/*  20 */     this.playerInventory = playerInventory;
/*  21 */     this.imageWidth = 176;
/*  22 */     this.imageHeight = 164;
   }
   
   protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
/*  27 */     drawCentered(guiGraphics, (Component)getTopText(), 9, 4210752);
/*  28 */     drawCentered(guiGraphics, (Component)getBottomText(), 40, 4210752);
/*  29 */     guiGraphics.drawString(this.font, this.playerInventory.getDisplayName().getVisualOrderText(), 8.0F, (this.imageHeight - 96 + 3), 4210752, false);
   }
   
   protected abstract MutableComponent getTopText();
   
   protected abstract MutableComponent getBottomText();
}
