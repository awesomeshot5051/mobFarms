/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.neutralMobs.GoatFarmBlock;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
/*    0 */ import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
/*    0 */ import de.maxhenkel.corelib.inventory.ItemListInventory;
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
/*    0 */ public class GoatFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   33 */   private static final ResourceKey<LootTable> GOAT_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/goat"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public GoatFarmTileentity(BlockPos pos, BlockState state) {
/*   41 */     super((BlockEntityType)ModTileEntities.GOAT_FARM.get(), ((GoatFarmBlock)ModBlocks.GOAT_FARM.get()).defaultBlockState(), pos, state);
/*   42 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   43 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   44 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getGoatSpawnTime() {
/*   48 */     return ((Integer)Main.SERVER_CONFIG.goatSpawnTime.get()).intValue() - 200;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getGoatKillTime() {
/*   52 */     return getGoatSpawnTime() + 200;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   56 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   64 */     this.timer++;
/*   65 */     setChanged();
/*   67 */     if (this.timer == getGoatSpawnTime()) {
/*   70 */       sync();
/*   75 */     } else if (this.timer >= getGoatKillTime()) {
/*   78 */       for (ItemStack drop : getDrops()) {
/*   79 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   80 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   81 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*   87 */       this.timer = 0L;
/*   88 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*  110 */     Level level = this.level;
/*  110 */     if (level instanceof ServerLevel) {
/*  110 */       ServerLevel serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*  111 */       return Collections.emptyList();
/*    0 */     } 
/*  115 */     ItemStack goatHorn = new ItemStack((ItemLike)Items.GOAT_HORN);
/*  118 */     return Collections.singletonList(goatHorn);
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  122 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  127 */     super.saveAdditional(compound, provider);
/*  128 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  129 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  134 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  135 */     this.timer = compound.getLong("Timer");
/*  136 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  140 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
