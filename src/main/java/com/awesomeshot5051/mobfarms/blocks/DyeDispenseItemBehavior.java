/*   0 */ package com.awesomeshot5051.mobfarms.blocks;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ import net.minecraft.core.Direction;
/*   0 */ import net.minecraft.core.dispenser.BlockSource;
/*   0 */ import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
/*   0 */ import net.minecraft.server.level.ServerLevel;
/*   0 */ import net.minecraft.world.item.DyeColor;
/*   0 */ import net.minecraft.world.item.DyeItem;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.minecraft.world.level.Level;
/*   0 */ import net.minecraft.world.level.block.DispenserBlock;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ import net.minecraft.world.level.block.state.properties.Property;
/*   0 */ 
/*   0 */ public class DyeDispenseItemBehavior extends DefaultDispenseItemBehavior {
/*   0 */   public ItemStack execute(BlockSource blockSource, ItemStack item) {
/*  19 */     if (!(item.getItem() instanceof DyeItem))
/*  20 */       return super.execute(blockSource, item); 
/*  23 */     ServerLevel serverLevel = blockSource.level();
/*  24 */     Direction direction = (Direction)blockSource.state().getValue((Property)DispenserBlock.FACING);
/*  25 */     BlockPos pos = blockSource.pos().relative(direction);
/*  26 */     BlockState state = serverLevel.getBlockState(pos);
/*  29 */     if (state.getBlock() instanceof SheepFarmBlock) {
/*  30 */       DyeColor dyeColor = ((DyeItem)item.getItem()).getDyeColor();
/*  31 */       ((SheepFarmBlock)state.getBlock()).dyeBlock(state, (Level)serverLevel, dyeColor, pos);
/*  32 */       item.shrink(1);
/*   0 */     } else {
/*  34 */       return super.execute(blockSource, item);
/*   0 */     } 
/*  37 */     return item;
/*   0 */   }
/*   0 */   
/*   0 */   protected void playSound(BlockSource blockSource) {
/*  42 */     blockSource.level().levelEvent(1000, blockSource.pos(), 0);
/*   0 */   }
/*   0 */ }
