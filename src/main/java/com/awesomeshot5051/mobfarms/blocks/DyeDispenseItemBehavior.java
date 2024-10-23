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
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DyeDispenseItemBehavior extends DefaultDispenseItemBehavior {

    @Override
    public ItemStack execute(BlockSource blockSource, ItemStack item) {
        if (!(item.getItem() instanceof DyeItem)) {
            return super.execute(blockSource, item); // Call default behavior for non-dye items
        }

        ServerLevel serverLevel = blockSource.level();
        Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
        BlockPos pos = blockSource.pos().relative(direction);
        BlockState state = serverLevel.getBlockState(pos);

        // Check if the block at the position is a SheepFarmBlock
        if (state.getBlock() instanceof SheepFarmBlock) {
            DyeColor dyeColor = ((DyeItem) item.getItem()).getDyeColor();
            ((SheepFarmBlock) state.getBlock()).dyeBlock(state, serverLevel, dyeColor, pos);
            item.shrink(1); // Remove one dye item from the dispenser
        } else {
            return super.execute(blockSource, item); // Call default behavior if it's not a SheepFarmBlock
        }

        return item;
    }

    @Override
    protected void playSound(BlockSource blockSource) {
        blockSource.level().levelEvent(1000, blockSource.pos(), 0); // Sound for item dispense
    }
}
