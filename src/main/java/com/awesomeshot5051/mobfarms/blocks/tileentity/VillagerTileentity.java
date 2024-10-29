package com.awesomeshot5051.mobfarms.blocks.tileentity;

import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VillagerTileentity extends FakeWorldTileentity {
   protected ItemStack villager;
   
   protected EasyVillagerEntity villagerEntity;
   
   public VillagerTileentity(BlockEntityType<?> type, BlockState defaultState, BlockPos pos, BlockState state) {
/*  19 */     super(type, defaultState, pos, state);
/*  20 */     this.villager = ItemStack.EMPTY;
   }
   
   public boolean hasVillager() {
/*  24 */     return !this.villager.isEmpty();
   }
   
   @Nullable
   public EasyVillagerEntity getVillagerEntity() {
/*  29 */     if (this.villagerEntity == null && !this.villager.isEmpty())
/*  30 */       this.villagerEntity = VillagerData.createEasyVillager(this.villager, this.level); 
/*  32 */     return this.villagerEntity;
   }
   
   protected void onAddVillager(EasyVillagerEntity villager) {}
}
