/*   0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity;
/*   0 */ 
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ import net.minecraft.world.level.Level;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ 
/*   0 */ public class FakeWorldTileentity extends SyncableTileentity {
/*   0 */   protected boolean fakeWorld;
/*   0 */   
/*   0 */   protected BlockState defaultState;
/*   0 */   
/*   0 */   public FakeWorldTileentity(BlockEntityType<?> type, BlockState defaultState, BlockPos pos, BlockState state) {
/*  14 */     super(type, pos, state);
/*  15 */     this.defaultState = defaultState;
/*   0 */   }
/*   0 */   
/*   0 */   public void setFakeWorld(Level w) {
/*  19 */     this.level = w;
/*  20 */     this.fakeWorld = true;
/*   0 */   }
/*   0 */   
/*   0 */   public boolean isFakeWorld() {
/*  24 */     return this.fakeWorld;
/*   0 */   }
/*   0 */   
/*   0 */   public BlockState getBlockState() {
/*  29 */     if (this.fakeWorld)
/*  30 */       return this.defaultState; 
/*  32 */     return super.getBlockState();
/*   0 */   }
/*   0 */ }
