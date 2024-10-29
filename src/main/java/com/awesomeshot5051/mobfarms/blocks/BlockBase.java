/*   0 */ package com.awesomeshot5051.mobfarms.blocks;
/*   0 */ 
/*   0 */ import de.maxhenkel.corelib.block.VoxelUtils;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ import net.minecraft.world.InteractionHand;
/*   0 */ import net.minecraft.world.entity.player.Player;
/*   0 */ import net.minecraft.world.level.BlockGetter;
/*   0 */ import net.minecraft.world.level.Level;
/*   0 */ import net.minecraft.world.level.block.Block;
/*   0 */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ import net.minecraft.world.phys.shapes.CollisionContext;
/*   0 */ import net.minecraft.world.phys.shapes.VoxelShape;
/*   0 */ 
/*   0 */ public class BlockBase extends HorizontalRotatableBlock {
/*  19 */   private static final VoxelShape SHAPE = VoxelUtils.combine(new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D), 
/*  21 */         Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  22 */         Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D), 
/*  23 */         Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), 
/*  24 */         Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D), 
/*  25 */         Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D) });
/*   0 */   
/*   0 */   public BlockBase(Properties properties) {
/*  29 */     super(properties);
/*   0 */   }
/*   0 */   
/*   0 */   public boolean overrideClick(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn) {
/*  33 */     return (player.isShiftKeyDown() && player.getMainHandItem().isEmpty());
/*   0 */   }
/*   0 */   
/*   0 */   public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
/*  54 */     return SHAPE;
/*   0 */   }
/*   0 */ }
