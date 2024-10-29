/*   0 */ package com.awesomeshot5051.mobfarms.gui;
/*   0 */ 
/*   0 */ import de.maxhenkel.corelib.inventory.ContainerBase;
/*   0 */ import net.minecraft.world.Container;
/*   0 */ import net.minecraft.world.entity.player.Player;
/*   0 */ import net.minecraft.world.inventory.AbstractContainerMenu;
/*   0 */ import net.minecraft.world.inventory.ContainerLevelAccess;
/*   0 */ import net.minecraft.world.inventory.MenuType;
/*   0 */ import net.minecraft.world.level.block.Block;
/*   0 */ 
/*   0 */ public abstract class ModContainerBase extends ContainerBase {
/*   0 */   protected ContainerLevelAccess access;
/*   0 */   
/*   0 */   public ModContainerBase(MenuType containerType, int id, Container playerInventory, Container inventory, ContainerLevelAccess access) {
/*  16 */     super(containerType, id, playerInventory, inventory);
/*  17 */     this.access = access;
/*   0 */   }
/*   0 */   
/*   0 */   public abstract Block getBlock();
/*   0 */   
/*   0 */   public boolean stillValid(Player player) {
/*  24 */     return (super.stillValid(player) && AbstractContainerMenu.stillValid(this.access, player, getBlock()));
/*   0 */   }
/*   0 */ }
