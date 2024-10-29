/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.VindicatorFarmBlock;
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
/*    0 */ public class VindicatorFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   33 */   private static final ResourceKey<LootTable> VINDICATOR_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/vindicator"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public VindicatorFarmTileentity(BlockPos pos, BlockState state) {
/*   42 */     super((BlockEntityType)ModTileEntities.VINDICATOR_FARM.get(), ((VindicatorFarmBlock)ModBlocks.VINDICATOR_FARM.get()).defaultBlockState(), pos, state);
/*   43 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   44 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   45 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getVindicatorSpawnTime() {
/*   49 */     return ((Integer)Main.SERVER_CONFIG.vindicatorSpawnTime.get()).intValue() - 80;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getVindicatorExplodeTime() {
/*   53 */     return getVindicatorSpawnTime() + 80;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   57 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   65 */     this.timer++;
/*   66 */     setChanged();
/*   68 */     if (this.timer == getVindicatorSpawnTime()) {
/*   71 */       sync();
/*   76 */     } else if (this.timer >= getVindicatorExplodeTime()) {
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
/*   98 */     List<ItemStack> drops = new ArrayList<>();
/*  101 */     if (serverWorld.random.nextFloat() < 0.5F)
/*  102 */       drops.add(new ItemStack((ItemLike)Items.EMERALD, serverWorld.random.nextInt(2))); 
/*  106 */     ItemStack ironAxe = new ItemStack((ItemLike)Items.IRON_AXE);
/*  107 */     drops.add(ironAxe);
/*  109 */     return drops;
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  113 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  118 */     super.saveAdditional(compound, provider);
/*  120 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  121 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  126 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  127 */     this.timer = compound.getLong("Timer");
/*  128 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  132 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
