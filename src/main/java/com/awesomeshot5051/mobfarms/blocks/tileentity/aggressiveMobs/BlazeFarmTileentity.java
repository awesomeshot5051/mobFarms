/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.BlazeFarmBlock;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
/*    0 */ import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
/*    0 */ import de.maxhenkel.corelib.inventory.ItemListInventory;
/*    0 */ import java.util.ArrayList;
/*    0 */ import java.util.Collections;
/*    0 */ import java.util.List;
/*    0 */ import net.minecraft.core.BlockPos;
/*    0 */ import net.minecraft.core.HolderLookup;
/*    0 */ import net.minecraft.core.NonNullList;
/*    0 */ import net.minecraft.core.registries.Registries;
/*    0 */ import net.minecraft.nbt.CompoundTag;
/*    0 */ import net.minecraft.resources.ResourceKey;
/*    0 */ import net.minecraft.resources.ResourceLocation;
/*    0 */ import net.minecraft.server.level.ServerLevel;
/*    0 */ import net.minecraft.world.Container;
/*    0 */ import net.minecraft.world.ContainerHelper;
/*    0 */ import net.minecraft.world.item.ItemStack;
/*    0 */ import net.minecraft.world.item.Items;
/*    0 */ import net.minecraft.world.level.ItemLike;
/*    0 */ import net.minecraft.world.level.Level;
/*    0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    0 */ import net.minecraft.world.level.block.state.BlockState;
/*    0 */ import net.minecraft.world.level.storage.loot.LootTable;
/*    0 */ import net.neoforged.neoforge.items.IItemHandler;
/*    0 */ import net.neoforged.neoforge.items.ItemStackHandler;
/*    0 */ 
/*    0 */ public class BlazeFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   33 */   private static final ResourceKey<LootTable> BLAZE_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/blaze"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public BlazeFarmTileentity(BlockPos pos, BlockState state) {
/*   42 */     super((BlockEntityType)ModTileEntities.BLAZE_FARM.get(), ((BlazeFarmBlock)ModBlocks.BLAZE_FARM.get()).defaultBlockState(), pos, state);
/*   43 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   44 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   45 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getBlazeSpawnTime() {
/*   49 */     return ((Integer)Main.SERVER_CONFIG.blazeSpawnTime.get()).intValue() - 80;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getBlazeExplodeTime() {
/*   53 */     return getBlazeSpawnTime() + 80;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   57 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   65 */     this.timer++;
/*   66 */     setChanged();
/*   68 */     if (this.timer == getBlazeSpawnTime()) {
/*   71 */       sync();
/*   76 */     } else if (this.timer >= getBlazeExplodeTime()) {
/*   79 */       for (ItemStack drop : getDrops()) {
/*   80 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   81 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   82 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*   88 */       this.timer = 0L;
/*   89 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*    0 */     ServerLevel serverWorld;
/*   94 */     Level level = this.level;
/*   94 */     if (level instanceof ServerLevel) {
/*   94 */       serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*   95 */       return Collections.emptyList();
/*    0 */     } 
/*   99 */     double dropChance = 0.5D;
/*  100 */     List<ItemStack> drops = new ArrayList<>();
/*  102 */     if (serverWorld.random.nextDouble() < dropChance) {
/*  103 */       int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
/*  104 */       drops.add(new ItemStack((ItemLike)Items.BLAZE_ROD, dropCount));
/*    0 */     } 
/*  110 */     return drops;
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  115 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  120 */     super.saveAdditional(compound, provider);
/*  122 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  123 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  128 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  129 */     this.timer = compound.getLong("Timer");
/*  130 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  134 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
