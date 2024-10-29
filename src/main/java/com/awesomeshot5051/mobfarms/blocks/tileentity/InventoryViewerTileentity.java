/*   0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.InventoryViewerBlock;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*   0 */ import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
/*   0 */ import com.awesomeshot5051.mobfarms.gui.ModItemStackHandler;
/*   0 */ import de.maxhenkel.corelib.blockentity.IServerTickableBlockEntity;
/*   0 */ import de.maxhenkel.corelib.inventory.ItemListInventory;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ import net.minecraft.core.NonNullList;
/*   0 */ import net.minecraft.world.Container;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ import net.neoforged.neoforge.items.IItemHandler;
/*   0 */ 
/*   0 */ public class InventoryViewerTileentity extends VillagerTileentity implements IServerTickableBlockEntity {
/*   0 */   public InventoryViewerTileentity(BlockPos pos, BlockState state) {
/*  20 */     super((BlockEntityType)ModTileEntities.INVENTORY_VIEWER.get(), ((InventoryViewerBlock)ModBlocks.INVENTORY_VIEWER.get()).defaultBlockState(), pos, state);
/*   0 */   }
/*   0 */   
/*   0 */   public void tickServer() {
/*  25 */     if (hasVillager());
/*   0 */   }
/*   0 */   
/*   0 */   public Container getVillagerInventory() {
/*  31 */     return (Container)new ItemListInventory(getVillagerEntity().getInventory().getItems(), this::setChanged);
/*   0 */   }
/*   0 */   
/*   0 */   public Container getVillagerArmorInventory() {
/*  35 */     return (Container)new ItemListInventory((NonNullList)getVillagerEntity().getArmorSlots(), this::setChanged);
/*   0 */   }
/*   0 */   
/*   0 */   public IItemHandler getItemHandler() {
/*  39 */     EasyVillagerEntity ve = getVillagerEntity();
/*  40 */     if (ve == null)
/*  41 */       return null; 
/*  43 */     return (IItemHandler)new ModItemStackHandler(ve.getInventory().getItems(), this);
/*   0 */   }
/*   0 */ }
