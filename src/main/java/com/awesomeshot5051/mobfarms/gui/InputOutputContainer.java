package com.awesomeshot5051.mobfarms.gui;

import de.maxhenkel.corelib.inventory.LockedSlot;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

public abstract class InputOutputContainer extends ModContainerBase {
   public InputOutputContainer(MenuType type, int id, Inventory playerInventory, Container inputInventory, Container outputInventory, ContainerLevelAccess access) {
/*  14 */     super(type, id, (Container)playerInventory, (Container)null, access);
     int i;
/*  16 */     for (i = 0; i < 4; i++)
       addSlot(getInputSlot(inputInventory, i, 52 + i * 18, 20)); 
/*  20 */     for (i = 0; i < 4; i++)
/*  21 */       addSlot((Slot)new LockedSlot(outputInventory, i, 52 + i * 18, 51, true, false)); 
/*  24 */     addPlayerInventorySlots();
   }
   
   public InputOutputContainer(MenuType type, int id, Inventory playerInventory) {
/*  28 */     this(type, id, playerInventory, (Container)new SimpleContainer(4), (Container)new SimpleContainer(4), ContainerLevelAccess.NULL);
   }
   
   public int getInvOffset() {
/*  33 */     return -2;
   }
   
   public int getInventorySize() {
/*  38 */     return 8;
   }
   
   public abstract Slot getInputSlot(Container paramContainer, int paramInt1, int paramInt2, int paramInt3);
}
