/*   0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.datacomponents.VillagerData;
/*   0 */ import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
/*   0 */ import javax.annotation.Nullable;
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ 
/*   0 */ public class VillagerTileentity extends FakeWorldTileentity {
/*   0 */   protected ItemStack villager;
/*   0 */   
/*   0 */   protected EasyVillagerEntity villagerEntity;
/*   0 */   
/*   0 */   public VillagerTileentity(BlockEntityType<?> type, BlockState defaultState, BlockPos pos, BlockState state) {
/*  19 */     super(type, defaultState, pos, state);
/*  20 */     this.villager = ItemStack.EMPTY;
/*   0 */   }
/*   0 */   
/*   0 */   public boolean hasVillager() {
/*  24 */     return !this.villager.isEmpty();
/*   0 */   }
/*   0 */   
/*   0 */   @Nullable
/*   0 */   public EasyVillagerEntity getVillagerEntity() {
/*  29 */     if (this.villagerEntity == null && !this.villager.isEmpty())
/*  30 */       this.villagerEntity = VillagerData.createEasyVillager(this.villager, this.level); 
/*  32 */     return this.villagerEntity;
/*   0 */   }
/*   0 */   
/*   0 */   protected void onAddVillager(EasyVillagerEntity villager) {}
/*   0 */ }
