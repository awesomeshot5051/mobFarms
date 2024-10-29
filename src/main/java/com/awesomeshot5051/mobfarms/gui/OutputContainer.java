/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import de.maxhenkel.corelib.inventory.LockedSlot;
/*   0 */ import java.util.function.Supplier;
/*   0 */ import javax.annotation.Nullable;
/*   0 */ import net.minecraft.world.Container;
/*   0 */ import net.minecraft.world.SimpleContainer;
/*   0 */ import net.minecraft.world.entity.player.Inventory;
/*   0 */ import net.minecraft.world.inventory.ContainerLevelAccess;
/*   0 */ import net.minecraft.world.inventory.MenuType;
/*   0 */ import net.minecraft.world.inventory.Slot;
/*   0 */ import net.minecraft.world.level.block.Block;
/*   0 */ import net.minecraft.world.level.block.Blocks;
/*   0 */ 
/*   0 */ public class OutputContainer extends ModContainerBase {
/*   0 */   @Nullable
/*   0 */   protected Supplier<Block> blockSupplier;
/*   0 */   
/*   0 */   public OutputContainer(int id, Inventory playerInventory, Container outputInventory, ContainerLevelAccess access, Supplier<Block> blockSupplier) {
/*  20 */     super((MenuType)Containers.OUTPUT_CONTAINER.get(), id, (Container)playerInventory, outputInventory, access);
/*  21 */     this.blockSupplier = blockSupplier;
/*  23 */     for (int i = 0; i < 4; i++)
/*  24 */       addSlot((Slot)new LockedSlot(outputInventory, i, 52 + i * 18, 20, true, false)); 
/*  27 */     addPlayerInventorySlots();
/*   0 */   }
/*   0 */   
/*   0 */   public OutputContainer(int id, Inventory playerInventory) {
/*  31 */     this(id, playerInventory, (Container)new SimpleContainer(4), ContainerLevelAccess.NULL, (Supplier<Block>)null);
/*   0 */   }
/*   0 */   
/*   0 */   public int getInvOffset() {
/*  36 */     return -33;
/*   0 */   }
/*   0 */   
/*   0 */   public int getInventorySize() {
/*  41 */     return 4;
/*   0 */   }
/*   0 */   
/*   0 */   public Block getBlock() {
/*  46 */     if (this.blockSupplier == null)
/*  47 */       return Blocks.AIR; 
/*  49 */     return this.blockSupplier.get();
/*   0 */   }
/*   0 */ }
