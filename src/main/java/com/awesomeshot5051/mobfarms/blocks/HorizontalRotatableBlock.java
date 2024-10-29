package com.awesomeshot5051.mobfarms.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class HorizontalRotatableBlock extends Block {
   public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
   
   public HorizontalRotatableBlock(Properties properties) {
/*  18 */     super(properties);
/*  19 */     registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH));
   }
   
   public BlockState rotate(BlockState state, Rotation rot) {
/*  24 */     return (BlockState)state.setValue((Property)FACING, (Comparable)rot.rotate((Direction)state.getValue((Property)FACING)));
   }
   
   public BlockState mirror(BlockState state, Mirror mirrorIn) {
/*  29 */     return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
   }
   
   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/*  34 */     builder.add(new Property[] { (Property)FACING });
   }
   
   public BlockState getStateForPlacement(BlockPlaceContext context) {
/*  39 */     return (BlockState)defaultBlockState().setValue((Property)FACING, (Comparable)context.getHorizontalDirection().getOpposite());
   }
}
