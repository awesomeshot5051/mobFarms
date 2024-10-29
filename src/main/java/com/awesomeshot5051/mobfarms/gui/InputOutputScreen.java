/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import de.maxhenkel.corelib.inventory.ScreenBase;
/*   0 */ import net.minecraft.client.gui.GuiGraphics;
/*   0 */ import net.minecraft.network.chat.Component;
/*   0 */ import net.minecraft.network.chat.MutableComponent;
/*   0 */ import net.minecraft.resources.ResourceLocation;
/*   0 */ import net.minecraft.world.entity.player.Inventory;
/*   0 */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*   0 */ 
/*   0 */ public abstract class InputOutputScreen<T extends AbstractContainerMenu> extends ScreenBase<T> {
/*  14 */   public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath("mob_farms", "textures/gui/container/input_output.png");
/*   0 */   
/*   0 */   private final Inventory playerInventory;
/*   0 */   
/*   0 */   public InputOutputScreen(T container, Inventory playerInventory, Component name) {
/*  19 */     super(BACKGROUND, (AbstractContainerMenu)container, playerInventory, name);
/*  20 */     this.playerInventory = playerInventory;
/*  21 */     this.imageWidth = 176;
/*  22 */     this.imageHeight = 164;
/*   0 */   }
/*   0 */   
/*   0 */   protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
/*  27 */     drawCentered(guiGraphics, (Component)getTopText(), 9, 4210752);
/*  28 */     drawCentered(guiGraphics, (Component)getBottomText(), 40, 4210752);
/*  29 */     guiGraphics.drawString(this.font, this.playerInventory.getDisplayName().getVisualOrderText(), 8.0F, (this.imageHeight - 96 + 3), 4210752, false);
/*   0 */   }
/*   0 */   
/*   0 */   protected abstract MutableComponent getTopText();
/*   0 */   
/*   0 */   protected abstract MutableComponent getBottomText();
/*   0 */ }
