package com.awesomeshot5051.mobfarms.gui;

import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class OutputScreen extends ScreenBase<OutputContainer> {
/*  13 */   public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mob_farms", "textures/gui/container/output.png");
   
   private final Inventory playerInventory;
   
   public OutputScreen(OutputContainer container, Inventory playerInventory, Component name) {
/*  18 */     super(BACKGROUND, (AbstractContainerMenu)container, playerInventory, name);
/*  19 */     this.playerInventory = playerInventory;
/*  20 */     this.imageWidth = 176;
/*  21 */     this.imageHeight = 133;
   }
   
   protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
/*  26 */     drawCentered(guiGraphics, Component.translatable("gui.mob_farms.output"), 9, 4210752);
/*  27 */     guiGraphics.drawString(this.font, this.playerInventory.getDisplayName().getVisualOrderText(), 8.0F, (this.imageHeight - 96 + 3), 4210752, false);
   }
   
   protected void drawCentered(GuiGraphics guiGraphics, MutableComponent text, int y, int color) {
/*  31 */     int width = this.font.width((FormattedText)text);
/*  32 */     guiGraphics.drawString(this.font, text.getVisualOrderText(), this.imageWidth / 2.0F - width / 2.0F, y, color, false);
   }
}
