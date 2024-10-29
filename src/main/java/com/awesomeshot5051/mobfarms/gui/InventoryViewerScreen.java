package com.awesomeshot5051.mobfarms.gui;

import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class InventoryViewerScreen extends ScreenBase<InventoryViewerContainer> {
/*  12 */   public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mob_farms", "textures/gui/container/villager_inventory.png");
   
/*  14 */   public static final Component VILLAGER_INVENTORY = (Component)Component.translatable("gui.mob_farms.villager_inventory");
   
   public static final Component VILLAGER_EQUIPMENT = (Component)Component.translatable("gui.mob_farms.villager_equipment");
   
   protected final Inventory playerInventory;
   
   public InventoryViewerScreen(InventoryViewerContainer container, Inventory playerInventory, Component title) {
/*  20 */     super(BACKGROUND, (AbstractContainerMenu)container, playerInventory, title);
/*  21 */     this.playerInventory = playerInventory;
/*  22 */     this.imageWidth = 176;
/*  23 */     this.imageHeight = 182;
   }
   
   protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
/*  28 */     drawCentered(guiGraphics, VILLAGER_INVENTORY, 9, 4210752);
/*  29 */     drawCentered(guiGraphics, VILLAGER_EQUIPMENT, 58, 4210752);
/*  30 */     guiGraphics.drawString(this.font, this.playerInventory.getDisplayName().getVisualOrderText(), 8.0F, (this.imageHeight - 96 + 3), 4210752, false);
   }
}
