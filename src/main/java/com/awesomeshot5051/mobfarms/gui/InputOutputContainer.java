/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import de.maxhenkel.corelib.inventory.LockedSlot;
/*   0 */ import net.minecraft.world.Container;
/*   0 */ import net.minecraft.world.SimpleContainer;
/*   0 */ import net.minecraft.world.entity.player.Inventory;
/*   0 */ import net.minecraft.world.inventory.ContainerLevelAccess;
/*   0 */ import net.minecraft.world.inventory.MenuType;
/*   0 */ import net.minecraft.world.inventory.Slot;
/*   0 */ 
/*   0 */ public abstract class InputOutputContainer extends ModContainerBase {
/*   0 */   public InputOutputContainer(MenuType type, int id, Inventory playerInventory, Container inputInventory, Container outputInventory, ContainerLevelAccess access) {
/*  14 */     super(type, id, (Container)playerInventory, (Container)null, access);
/*   0 */     int i;
/*  16 */     for (i = 0; i < 4; i++)
/*  17 */       addSlot(getInputSlot(inputInventory, i, 52 + i * 18, 20)); 
/*  20 */     for (i = 0; i < 4; i++)
/*  21 */       addSlot((Slot)new LockedSlot(outputInventory, i, 52 + i * 18, 51, true, false)); 
/*  24 */     addPlayerInventorySlots();
/*   0 */   }
/*   0 */   
/*   0 */   public InputOutputContainer(MenuType type, int id, Inventory playerInventory) {
/*  28 */     this(type, id, playerInventory, (Container)new SimpleContainer(4), (Container)new SimpleContainer(4), ContainerLevelAccess.NULL);
/*   0 */   }
/*   0 */   
/*   0 */   public int getInvOffset() {
/*  33 */     return -2;
/*   0 */   }
/*   0 */   
/*   0 */   public int getInventorySize() {
/*  38 */     return 8;
/*   0 */   }
/*   0 */   
/*   0 */   public abstract Slot getInputSlot(Container paramContainer, int paramInt1, int paramInt2, int paramInt3);
/*   0 */ }
