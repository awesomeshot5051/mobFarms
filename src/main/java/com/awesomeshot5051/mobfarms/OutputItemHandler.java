/*   0 */ package com.awesomeshot5051.mobfarms;
/*   0 */ 
/*   0 */ import net.minecraft.core.NonNullList;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.neoforged.neoforge.items.ItemStackHandler;
/*   0 */ import org.jetbrains.annotations.NotNull;
/*   0 */ 
/*   0 */ public class OutputItemHandler extends ItemStackHandler {
/*   0 */   public OutputItemHandler(NonNullList<ItemStack> stacks) {
/*  11 */     super(stacks);
/*   0 */   }
/*   0 */   
/*   0 */   public boolean isItemValid(int slot, @NotNull ItemStack stack) {
/*  16 */     return false;
/*   0 */   }
/*   0 */ }
