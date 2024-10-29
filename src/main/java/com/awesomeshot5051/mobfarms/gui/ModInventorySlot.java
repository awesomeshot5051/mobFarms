/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.InventoryViewerTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
/*   0 */ import net.minecraft.world.Container;
/*   0 */ import net.minecraft.world.inventory.Slot;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ 
/*   0 */ public class ModInventorySlot extends Slot {
/*   0 */   protected final InventoryViewerTileentity inventoryViewer;
/*   0 */   
/*   0 */   public ModInventorySlot(Container c, int index, int xPos, int yPos, InventoryViewerTileentity inventoryViewer) {
/*  14 */     super(c, index, xPos, yPos);
/*  15 */     this.inventoryViewer = inventoryViewer;
/*   0 */   }
/*   0 */   
/*   0 */   public boolean mayPlace(ItemStack stack) {
/*  20 */     EasyVillagerEntity v = this.inventoryViewer.getVillagerEntity();
/*  21 */     if (v == null)
/*  22 */       return false; 
/*  24 */     return (super.mayPlace(stack) && v.wantsToPickUp(stack));
/*   0 */   }
/*   0 */ }
