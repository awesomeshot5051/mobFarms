/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import de.maxhenkel.corelib.inventory.ScreenBase;
/*   0 */ import net.minecraft.client.gui.GuiGraphics;
/*   0 */ import net.minecraft.network.chat.Component;
/*   0 */ import net.minecraft.resources.ResourceLocation;
/*   0 */ import net.minecraft.world.entity.player.Inventory;
/*   0 */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*   0 */ 
/*   0 */ public class InventoryViewerScreen extends ScreenBase<InventoryViewerContainer> {
/*  12 */   public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mob_farms", "textures/gui/container/villager_inventory.png");
/*   0 */   
/*  14 */   public static final Component VILLAGER_INVENTORY = (Component)Component.translatable("gui.mob_farms.villager_inventory");
/*   0 */   
/*  15 */   public static final Component VILLAGER_EQUIPMENT = (Component)Component.translatable("gui.mob_farms.villager_equipment");
/*   0 */   
/*   0 */   protected final Inventory playerInventory;
/*   0 */   
/*   0 */   public InventoryViewerScreen(InventoryViewerContainer container, Inventory playerInventory, Component title) {
/*  20 */     super(BACKGROUND, (AbstractContainerMenu)container, playerInventory, title);
/*  21 */     this.playerInventory = playerInventory;
/*  22 */     this.imageWidth = 176;
/*  23 */     this.imageHeight = 182;
/*   0 */   }
/*   0 */   
/*   0 */   protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
/*  28 */     drawCentered(guiGraphics, VILLAGER_INVENTORY, 9, 4210752);
/*  29 */     drawCentered(guiGraphics, VILLAGER_EQUIPMENT, 58, 4210752);
/*  30 */     guiGraphics.drawString(this.font, this.playerInventory.getDisplayName().getVisualOrderText(), 8.0F, (this.imageHeight - 96 + 3), 4210752, false);
/*   0 */   }
/*   0 */ }
