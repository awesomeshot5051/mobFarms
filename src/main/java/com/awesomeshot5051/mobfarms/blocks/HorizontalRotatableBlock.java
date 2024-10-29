/*   0 */ package com.awesomeshot5051.mobfarms.blocks;
/*   0 */ 
/*   0 */ import net.minecraft.core.Direction;
/*   0 */ import net.minecraft.world.item.context.BlockPlaceContext;
/*   0 */ import net.minecraft.world.level.block.Block;
/*   0 */ import net.minecraft.world.level.block.Mirror;
/*   0 */ import net.minecraft.world.level.block.Rotation;
/*   0 */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ import net.minecraft.world.level.block.state.StateDefinition;
/*   0 */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*   0 */ import net.minecraft.world.level.block.state.properties.DirectionProperty;
/*   0 */ import net.minecraft.world.level.block.state.properties.Property;
/*   0 */ 
/*   0 */ public class HorizontalRotatableBlock extends Block {
/*  15 */   public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
/*   0 */   
/*   0 */   public HorizontalRotatableBlock(Properties properties) {
/*  18 */     super(properties);
/*  19 */     registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH));
/*   0 */   }
/*   0 */   
/*   0 */   public BlockState rotate(BlockState state, Rotation rot) {
/*  24 */     return (BlockState)state.setValue((Property)FACING, (Comparable)rot.rotate((Direction)state.getValue((Property)FACING)));
/*   0 */   }
/*   0 */   
/*   0 */   public BlockState mirror(BlockState state, Mirror mirrorIn) {
/*  29 */     return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
/*   0 */   }
/*   0 */   
/*   0 */   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
/*  34 */     builder.add(new Property[] { (Property)FACING });
/*   0 */   }
/*   0 */   
/*   0 */   public BlockState getStateForPlacement(BlockPlaceContext context) {
/*  39 */     return (BlockState)defaultBlockState().setValue((Property)FACING, (Comparable)context.getHorizontalDirection().getOpposite());
/*   0 */   }
/*   0 */ }
