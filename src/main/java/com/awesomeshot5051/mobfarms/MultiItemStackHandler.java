/*    0 */ package com.awesomeshot5051.mobfarms;
/*    0 */ 
/*    0 */ import java.util.function.Predicate;
/*    0 */ import javax.annotation.Nonnull;
/*    0 */ import javax.annotation.Nullable;
/*    0 */ import net.minecraft.core.NonNullList;
/*    0 */ import net.minecraft.world.item.ItemStack;
/*    0 */ import net.neoforged.neoforge.items.IItemHandler;
/*    0 */ import org.jetbrains.annotations.NotNull;
/*    0 */ 
/*    0 */ public class MultiItemStackHandler implements IItemHandler {
/*    0 */   protected NonNullList<ItemStack> modifiable;
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> takeOnly;
/*    0 */   
/*    0 */   @Nullable
/*    0 */   protected Predicate<ItemStack> inputValidator;
/*    0 */   
/*    0 */   public MultiItemStackHandler(NonNullList<ItemStack> modifiable, NonNullList<ItemStack> takeOnly, Predicate<ItemStack> inputValidator) {
/*   20 */     this.modifiable = modifiable;
/*   21 */     this.takeOnly = takeOnly;
/*   22 */     this.inputValidator = inputValidator;
/*    0 */   }
/*    0 */   
/*    0 */   public MultiItemStackHandler(NonNullList<ItemStack> modifiable, NonNullList<ItemStack> takeOnly) {
/*   26 */     this(modifiable, takeOnly, null);
/*    0 */   }
/*    0 */   
/*    0 */   public int getSlots() {
/*   31 */     return this.modifiable.size() + this.takeOnly.size();
/*    0 */   }
/*    0 */   
/*    0 */   @NotNull
/*    0 */   public ItemStack getStackInSlot(int slot) {
/*   37 */     validateSlotIndex(slot);
/*   38 */     return (ItemStack)getList(slot).get(getListIndex(slot));
/*    0 */   }
/*    0 */   
/*    0 */   @NotNull
/*    0 */   public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
/*   44 */     if (stack.isEmpty())
/*   45 */       return ItemStack.EMPTY; 
/*   48 */     if (!isItemValid(slot, stack))
/*   49 */       return stack; 
/*   52 */     validateSlotIndex(slot);
/*   54 */     ItemStack existing = getStackInSlot(slot);
/*   56 */     int limit = getStackLimit(slot, stack);
/*   58 */     if (!existing.isEmpty()) {
/*   59 */       if (!ItemStack.isSameItemSameComponents(stack, existing))
/*   60 */         return stack; 
/*   63 */       limit -= existing.getCount();
/*    0 */     } 
/*   66 */     if (limit <= 0)
/*   67 */       return stack; 
/*   70 */     boolean reachedLimit = (stack.getCount() > limit);
/*   72 */     if (!simulate)
/*   73 */       if (existing.isEmpty()) {
/*   74 */         getList(slot).set(getListIndex(slot), reachedLimit ? copyStackWithSize(stack, limit) : stack);
/*    0 */       } else {
/*   76 */         existing.grow(reachedLimit ? limit : stack.getCount());
/*    0 */       }  
/*   80 */     return reachedLimit ? copyStackWithSize(stack, stack.getCount() - limit) : ItemStack.EMPTY;
/*    0 */   }
/*    0 */   
/*    0 */   private ItemStack copyStackWithSize(ItemStack stack, int amount) {
/*   84 */     if (amount == 0)
/*   85 */       return ItemStack.EMPTY; 
/*   87 */     ItemStack copy = stack.copy();
/*   88 */     copy.setCount(amount);
/*   89 */     return copy;
/*    0 */   }
/*    0 */   
/*    0 */   @NotNull
/*    0 */   public ItemStack extractItem(int slot, int amount, boolean simulate) {
/*   95 */     if (amount == 0)
/*   96 */       return ItemStack.EMPTY; 
/*   99 */     validateSlotIndex(slot);
/*  101 */     if (!canExtract(slot))
/*  102 */       return ItemStack.EMPTY; 
/*  105 */     ItemStack existing = getStackInSlot(slot);
/*  107 */     if (existing.isEmpty())
/*  108 */       return ItemStack.EMPTY; 
/*  111 */     int toExtract = Math.min(amount, existing.getMaxStackSize());
/*  113 */     if (existing.getCount() <= toExtract) {
/*  114 */       if (!simulate) {
/*  115 */         getList(slot).set(getListIndex(slot), ItemStack.EMPTY);
/*  116 */         return existing;
/*    0 */       } 
/*  118 */       return existing.copy();
/*    0 */     } 
/*  121 */     if (!simulate)
/*  122 */       getList(slot).set(getListIndex(slot), copyStackWithSize(existing, existing.getCount() - toExtract)); 
/*  125 */     return copyStackWithSize(existing, toExtract);
/*    0 */   }
/*    0 */   
/*    0 */   public int getSlotLimit(int slot) {
/*  131 */     return 64;
/*    0 */   }
/*    0 */   
/*    0 */   public boolean isItemValid(int slot, @NotNull ItemStack stack) {
/*  136 */     if (slot < this.modifiable.size()) {
/*  137 */       if (this.inputValidator != null)
/*  138 */         return this.inputValidator.test(stack); 
/*  140 */       return true;
/*    0 */     } 
/*  142 */     return false;
/*    0 */   }
/*    0 */   
/*    0 */   protected boolean canExtract(int slot) {
/*  146 */     return (slot >= this.modifiable.size());
/*    0 */   }
/*    0 */   
/*    0 */   protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
/*  150 */     return Math.min(getSlotLimit(slot), stack.getMaxStackSize());
/*    0 */   }
/*    0 */   
/*    0 */   protected void validateSlotIndex(int slot) {
/*  154 */     if (slot < 0 || slot >= getSlots())
/*  155 */       throw new RuntimeException("Slot " + slot + " not in valid range - [0," + getSlots() + ")"); 
/*    0 */   }
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> getList(int slot) {
/*  160 */     validateSlotIndex(slot);
/*  161 */     if (slot < this.modifiable.size())
/*  162 */       return this.modifiable; 
/*  164 */     return this.takeOnly;
/*    0 */   }
/*    0 */   
/*    0 */   protected int getListIndex(int slot) {
/*  168 */     validateSlotIndex(slot);
/*  169 */     if (slot < this.modifiable.size())
/*  170 */       return slot; 
/*  172 */     return slot - this.modifiable.size();
/*    0 */   }
/*    0 */ }
