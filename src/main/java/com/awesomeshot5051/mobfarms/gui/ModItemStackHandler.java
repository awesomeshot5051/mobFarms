/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.InventoryViewerTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
/*   0 */ import net.minecraft.core.NonNullList;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.neoforged.neoforge.items.ItemStackHandler;
/*   0 */ import org.jetbrains.annotations.NotNull;
/*   0 */ 
/*   0 */ public class ModItemStackHandler extends ItemStackHandler {
/*   0 */   protected final InventoryViewerTileentity inventoryViewer;
/*   0 */   
/*   0 */   public ModItemStackHandler(NonNullList<ItemStack> stacks, InventoryViewerTileentity inventoryViewer) {
/*  15 */     super(stacks);
/*  16 */     this.inventoryViewer = inventoryViewer;
/*   0 */   }
/*   0 */   
/*   0 */   public boolean isItemValid(int slot, @NotNull ItemStack stack) {
/*  21 */     EasyVillagerEntity v = this.inventoryViewer.getVillagerEntity();
/*  22 */     return (super.isItemValid(slot, stack) && v != null && v.wantsToPickUp(stack));
/*   0 */   }
/*   0 */ }
