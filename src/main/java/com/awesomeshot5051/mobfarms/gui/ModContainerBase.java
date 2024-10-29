package com.awesomeshot5051.mobfarms.gui;

import de.maxhenkel.corelib.inventory.ContainerBase;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;

public abstract class ModContainerBase extends ContainerBase {
   protected ContainerLevelAccess access;
   
   public ModContainerBase(MenuType containerType, int id, Container playerInventory, Container inventory, ContainerLevelAccess access) {
/*  16 */     super(containerType, id, playerInventory, inventory);
     this.access = access;
   }
   
   public abstract Block getBlock();
   
   public boolean stillValid(Player player) {
/*  24 */     return (super.stillValid(player) && AbstractContainerMenu.stillValid(this.access, player, getBlock()));
   }
}
