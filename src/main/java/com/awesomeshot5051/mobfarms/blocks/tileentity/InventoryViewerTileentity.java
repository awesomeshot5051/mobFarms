package com.awesomeshot5051.mobfarms.blocks.tileentity;

import com.awesomeshot5051.mobfarms.blocks.InventoryViewerBlock;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import com.awesomeshot5051.mobfarms.gui.ModItemStackHandler;
import de.maxhenkel.corelib.blockentity.IServerTickableBlockEntity;
import de.maxhenkel.corelib.inventory.ItemListInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;

public class InventoryViewerTileentity extends VillagerTileentity implements IServerTickableBlockEntity {
   public InventoryViewerTileentity(BlockPos pos, BlockState state) {
/*  20 */     super((BlockEntityType)ModTileEntities.INVENTORY_VIEWER.get(), ((InventoryViewerBlock)ModBlocks.INVENTORY_VIEWER.get()).defaultBlockState(), pos, state);
   }
   
   public void tickServer() {
/*  25 */     if (hasVillager());
   }
   
   public Container getVillagerInventory() {
/*  31 */     return (Container)new ItemListInventory(getVillagerEntity().getInventory().getItems(), this::setChanged);
   }
   
   public Container getVillagerArmorInventory() {
/*  35 */     return (Container)new ItemListInventory((NonNullList)getVillagerEntity().getArmorSlots(), this::setChanged);
   }
   
   public IItemHandler getItemHandler() {
/*  39 */     EasyVillagerEntity ve = getVillagerEntity();
/*  40 */     if (ve == null)
/*  41 */       return null; 
/*  43 */     return (IItemHandler)new ModItemStackHandler(ve.getInventory().getItems(), this);
   }
}
