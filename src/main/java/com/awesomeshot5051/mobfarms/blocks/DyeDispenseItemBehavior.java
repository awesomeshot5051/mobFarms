package com.awesomeshot5051.mobfarms.blocks;

import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class DyeDispenseItemBehavior extends DefaultDispenseItemBehavior {
   public ItemStack execute(BlockSource blockSource, ItemStack item) {
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
     } else {
/*  34 */       return super.execute(blockSource, item);
     } 
/*  37 */     return item;
   }
   
   protected void playSound(BlockSource blockSource) {
/*  42 */     blockSource.level().levelEvent(1000, blockSource.pos(), 0);
   }
}
