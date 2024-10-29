package com.awesomeshot5051.mobfarms.gui;

import de.maxhenkel.corelib.inventory.LockedSlot;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class OutputContainer extends ModContainerBase {
   @Nullable
   protected Supplier<Block> blockSupplier;
   
   public OutputContainer(int id, Inventory playerInventory, Container outputInventory, ContainerLevelAccess access, Supplier<Block> blockSupplier) {
/*  20 */     super((MenuType)Containers.OUTPUT_CONTAINER.get(), id, (Container)playerInventory, outputInventory, access);
/*  21 */     this.blockSupplier = blockSupplier;
/*  23 */     for (int i = 0; i < 4; i++)
/*  24 */       addSlot((Slot)new LockedSlot(outputInventory, i, 52 + i * 18, 20, true, false)); 
/*  27 */     addPlayerInventorySlots();
   }
   
   public OutputContainer(int id, Inventory playerInventory) {
/*  31 */     this(id, playerInventory, (Container)new SimpleContainer(4), ContainerLevelAccess.NULL, (Supplier<Block>)null);
   }
   
   public int getInvOffset() {
/*  36 */     return -33;
   }
   
   public int getInventorySize() {
/*  41 */     return 4;
   }
   
   public Block getBlock() {
/*  46 */     if (this.blockSupplier == null)
/*  47 */       return Blocks.AIR; 
/*  49 */     return this.blockSupplier.get();
   }
}
