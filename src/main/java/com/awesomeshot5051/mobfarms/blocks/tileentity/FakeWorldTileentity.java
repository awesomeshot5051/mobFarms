package com.awesomeshot5051.mobfarms.blocks.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FakeWorldTileentity extends SyncableTileentity {
   protected boolean fakeWorld;
   
   protected BlockState defaultState;
   
   public FakeWorldTileentity(BlockEntityType<?> type, BlockState defaultState, BlockPos pos, BlockState state) {
/*  14 */     super(type, pos, state);
     this.defaultState = defaultState;
   }
   
   public void setFakeWorld(Level w) {
/*  19 */     this.level = w;
/*  20 */     this.fakeWorld = true;
   }
   
   public boolean isFakeWorld() {
/*  24 */     return this.fakeWorld;
   }
   
   public BlockState getBlockState() {
/*  29 */     if (this.fakeWorld)
/*  30 */       return this.defaultState; 
/*  32 */     return super.getBlockState();
   }
}
