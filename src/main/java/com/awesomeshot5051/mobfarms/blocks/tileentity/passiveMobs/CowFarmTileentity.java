/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.CowFarmBlock;
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
/*    0 */ public class CowFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   34 */   private static final ResourceKey<LootTable> COW_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/cow"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public CowFarmTileentity(BlockPos pos, BlockState state) {
/*   42 */     super((BlockEntityType)ModTileEntities.COW_FARM.get(), ((CowFarmBlock)ModBlocks.COW_FARM.get()).defaultBlockState(), pos, state);
/*   43 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   44 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   45 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getCowSpawnTime() {
/*   49 */     return ((Integer)Main.SERVER_CONFIG.cowSpawnTime.get()).intValue() - 200;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getCowKillTime() {
/*   53 */     return getCowSpawnTime() + 200;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   57 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   65 */     this.timer++;
/*   66 */     setChanged();
/*   68 */     if (this.timer == getCowSpawnTime()) {
/*   71 */       sync();
/*   76 */     } else if (this.timer >= getCowKillTime()) {
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
/*   94 */     Level level = this.level;
/*   94 */     if (level instanceof ServerLevel) {
/*   94 */       ServerLevel serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*   95 */       return Collections.emptyList();
/*    0 */     } 
/*   98 */     List<ItemStack> drops = new ArrayList<>();
/*  101 */     drops.add(new ItemStack((ItemLike)Items.COOKED_BEEF));
/*  104 */     ItemStack leather = new ItemStack((ItemLike)Items.LEATHER);
/*  105 */     drops.add(leather);
/*  107 */     return drops;
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  111 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  116 */     super.saveAdditional(compound, provider);
/*  117 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  118 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  123 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  124 */     this.timer = compound.getLong("Timer");
/*  125 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  129 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
