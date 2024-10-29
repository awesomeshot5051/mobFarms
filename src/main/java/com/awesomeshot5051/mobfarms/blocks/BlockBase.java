package com.awesomeshot5051.mobfarms.blocks;

import de.maxhenkel.corelib.block.VoxelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockBase extends HorizontalRotatableBlock {
/*  19 */   private static final VoxelShape SHAPE = VoxelUtils.combine(new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D), 
/*  21 */         Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  22 */         Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D), 
/*  23 */         Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  24 */         Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D), 
/*  25 */         Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D) });
   
   public BlockBase(Properties properties) {
/*  29 */     super(properties);
   }
   
   public boolean overrideClick(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn) {
/*  33 */     return (player.isShiftKeyDown() && player.getMainHandItem().isEmpty());
   }
   
   public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
/*  54 */     return SHAPE;
   }
}
