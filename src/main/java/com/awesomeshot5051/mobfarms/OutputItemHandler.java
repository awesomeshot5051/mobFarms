package com.awesomeshot5051.mobfarms;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class OutputItemHandler extends ItemStackHandler {
   public OutputItemHandler(NonNullList<ItemStack> stacks) {
/*  11 */     super(stacks);
   }
   
   public boolean isItemValid(int slot, @NotNull ItemStack stack) {
/*  16 */     return false;
   }
}
