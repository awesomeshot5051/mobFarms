/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import de.maxhenkel.corelib.inventory.ScreenBase;
/*   0 */ import net.minecraft.client.gui.GuiGraphics;
/*   0 */ import net.minecraft.network.chat.Component;
/*   0 */ import net.minecraft.network.chat.FormattedText;
/*   0 */ import net.minecraft.network.chat.MutableComponent;
/*   0 */ import net.minecraft.resources.ResourceLocation;
/*   0 */ import net.minecraft.world.entity.player.Inventory;
/*   0 */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*   0 */ 
/*   0 */ public class OutputScreen extends ScreenBase<OutputContainer> {
/*  13 */   public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mob_farms", "textures/gui/container/output.png");
/*   0 */   
/*   0 */   private final Inventory playerInventory;
/*   0 */   
/*   0 */   public OutputScreen(OutputContainer container, Inventory playerInventory, Component name) {
/*  18 */     super(BACKGROUND, (AbstractContainerMenu)container, playerInventory, name);
/*  19 */     this.playerInventory = playerInventory;
/*  20 */     this.imageWidth = 176;
/*  21 */     this.imageHeight = 133;
/*   0 */   }
/*   0 */   
/*   0 */   protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
/*  26 */     drawCentered(guiGraphics, Component.translatable("gui.mob_farms.output"), 9, 4210752);
/*  27 */     guiGraphics.drawString(this.font, this.playerInventory.getDisplayName().getVisualOrderText(), 8.0F, (this.imageHeight - 96 + 3), 4210752, false);
/*   0 */   }
/*   0 */   
/*   0 */   protected void drawCentered(GuiGraphics guiGraphics, MutableComponent text, int y, int color) {
/*  31 */     int width = this.font.width((FormattedText)text);
/*  32 */     guiGraphics.drawString(this.font, text.getVisualOrderText(), this.imageWidth / 2.0F - width / 2.0F, y, color, false);
/*   0 */   }
/*   0 */ }
