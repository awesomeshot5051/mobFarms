/*   0 */ package com.awesomeshot5051.mobfarms.events;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.BlockBase;
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.DyeDispenseItemBehavior;
/*   0 */ import net.minecraft.core.dispenser.DispenseItemBehavior;
/*   0 */ import net.minecraft.world.item.Item;
/*   0 */ import net.minecraft.world.item.Items;
/*   0 */ import net.minecraft.world.level.ItemLike;
/*   0 */ import net.minecraft.world.level.block.Block;
/*   0 */ import net.minecraft.world.level.block.DispenserBlock;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ import net.neoforged.bus.api.SubscribeEvent;
/*   0 */ import net.neoforged.neoforge.common.util.TriState;
/*   0 */ import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
/*   0 */ 
/*   0 */ public class BlockEvents {
/*   0 */   public BlockEvents() {
/*  16 */     registerDispenserBehaviors();
/*   0 */   }
/*   0 */   
/*   0 */   private void registerDispenserBehaviors() {
/*  21 */     for (Item dyeItem : new Item[] { 
/*  21 */         Items.WHITE_DYE, Items.ORANGE_DYE, Items.MAGENTA_DYE, Items.LIGHT_BLUE_DYE, Items.YELLOW_DYE, Items.LIME_DYE, Items.PINK_DYE, Items.GRAY_DYE, Items.LIGHT_GRAY_DYE, Items.CYAN_DYE, 
/*  21 */         Items.PURPLE_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.GREEN_DYE, Items.RED_DYE, Items.BLACK_DYE })
/*  27 */       DispenserBlock.registerBehavior((ItemLike)dyeItem, (DispenseItemBehavior)new DyeDispenseItemBehavior()); 
/*   0 */   }
/*   0 */   
/*   0 */   @SubscribeEvent
/*   0 */   public void onBlockClick(PlayerInteractEvent.RightClickBlock event) {
/*   0 */     BlockBase block;
/*  33 */     BlockState state = event.getLevel().getBlockState(event.getPos());
/*  34 */     Block block1 = state.getBlock();
/*  34 */     if (block1 instanceof BlockBase) {
/*  34 */       block = (BlockBase)block1;
/*   0 */     } else {
/*   0 */       return;
/*   0 */     } 
/*  38 */     if (block.overrideClick(state, event.getLevel(), event.getPos(), event.getEntity(), event.getHand()))
/*  39 */       event.setUseBlock(TriState.TRUE); 
/*   0 */   }
/*   0 */ }
