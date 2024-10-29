package com.awesomeshot5051.mobfarms.events;

import com.awesomeshot5051.mobfarms.blocks.BlockBase;
import com.awesomeshot5051.mobfarms.blocks.DyeDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class BlockEvents {
   public BlockEvents() {
/*  16 */     registerDispenserBehaviors();
   }
   
   private void registerDispenserBehaviors() {
/*  21 */     for (Item dyeItem : new Item[] { 
/*  21 */         Items.WHITE_DYE, Items.ORANGE_DYE, Items.MAGENTA_DYE, Items.LIGHT_BLUE_DYE, Items.YELLOW_DYE, Items.LIME_DYE, Items.PINK_DYE, Items.GRAY_DYE, Items.LIGHT_GRAY_DYE, Items.CYAN_DYE, 
/*  21 */         Items.PURPLE_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.GREEN_DYE, Items.RED_DYE, Items.BLACK_DYE })
/*  27 */       DispenserBlock.registerBehavior((ItemLike)dyeItem, (DispenseItemBehavior)new DyeDispenseItemBehavior()); 
   }
   
   @SubscribeEvent
   public void onBlockClick(PlayerInteractEvent.RightClickBlock event) {
     BlockBase block;
/*  33 */     BlockState state = event.getLevel().getBlockState(event.getPos());
/*  34 */     Block block1 = state.getBlock();
/*  34 */     if (block1 instanceof BlockBase) {
/*  34 */       block = (BlockBase)block1;
     } else {
       return;
     } 
/*  38 */     if (block.overrideClick(state, event.getLevel(), event.getPos(), event.getEntity(), event.getHand()))
/*  39 */       event.setUseBlock(TriState.TRUE); 
   }
}
