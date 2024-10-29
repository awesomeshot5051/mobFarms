/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.PillagerFarmBlock;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.items.MobFarmClass;
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
/*    0 */ import net.minecraft.util.RandomSource;
/*    0 */ import net.minecraft.world.Container;
/*    0 */ import net.minecraft.world.ContainerHelper;
/*    0 */ import net.minecraft.world.Difficulty;
/*    0 */ import net.minecraft.world.DifficultyInstance;
/*    0 */ import net.minecraft.world.entity.EntityType;
/*    0 */ import net.minecraft.world.entity.EquipmentSlot;
/*    0 */ import net.minecraft.world.item.ItemStack;
/*    0 */ import net.minecraft.world.item.Items;
/*    0 */ import net.minecraft.world.level.ItemLike;
/*    0 */ import net.minecraft.world.level.Level;
/*    0 */ import net.minecraft.world.level.ServerLevelAccessor;
/*    0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    0 */ import net.minecraft.world.level.block.state.BlockState;
/*    0 */ import net.minecraft.world.level.storage.loot.LootTable;
/*    0 */ import net.neoforged.neoforge.items.IItemHandler;
/*    0 */ import net.neoforged.neoforge.items.ItemStackHandler;
/*    0 */ 
/*    0 */ public class PillagerFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   39 */   private static final ResourceKey<LootTable> PILLAGER_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/pillager"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public PillagerFarmTileentity(BlockPos pos, BlockState state) {
/*   48 */     super((BlockEntityType)ModTileEntities.PILLAGER_FARM.get(), ((PillagerFarmBlock)ModBlocks.PILLAGER_FARM.get()).defaultBlockState(), pos, state);
/*   49 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   50 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   51 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getPillagerSpawnTime() {
/*   55 */     return ((Integer)Main.SERVER_CONFIG.pillagerSpawnTime.get()).intValue() - 80;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getPillagerExplodeTime() {
/*   59 */     return getPillagerSpawnTime() + 80;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   63 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   71 */     this.timer++;
/*   72 */     setChanged();
/*   74 */     if (this.timer == getPillagerSpawnTime()) {
/*   77 */       sync();
/*   82 */     } else if (this.timer >= getPillagerExplodeTime()) {
/*   85 */       for (ItemStack drop : getDrops()) {
/*   86 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   87 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   88 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*   94 */       this.timer = 0L;
/*   95 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*    0 */     ServerLevel serverWorld;
/*  100 */     Level level = this.level;
/*  100 */     if (level instanceof ServerLevel) {
/*  100 */       serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*  101 */       return Collections.emptyList();
/*    0 */     } 
/*  104 */     List<ItemStack> drops = new ArrayList<>();
/*  107 */     int emeraldCount = 0;
/*  108 */     if (serverWorld.getDifficulty() == Difficulty.EASY) {
/*  109 */       emeraldCount = serverWorld.random.nextInt(2);
/*  110 */     } else if (serverWorld.getDifficulty() == Difficulty.NORMAL) {
/*  111 */       emeraldCount = serverWorld.random.nextInt(3);
/*  112 */     } else if (serverWorld.getDifficulty() == Difficulty.HARD) {
/*  113 */       emeraldCount = serverWorld.random.nextInt(6);
/*    0 */     } 
/*  117 */     if (emeraldCount > 0)
/*  118 */       drops.add(new ItemStack((ItemLike)Items.EMERALD, emeraldCount)); 
/*  122 */     if (serverWorld.random.nextFloat() < 0.12F) {
/*  123 */       ItemStack crossbow = new ItemStack((ItemLike)Items.CROSSBOW);
/*  126 */       MobFarmClass mobFarmClass = new MobFarmClass(EntityType.PILLAGER, (Level)serverWorld);
/*  127 */       RandomSource random = RandomSource.create();
/*  134 */       DifficultyInstance difficultyInstance = new DifficultyInstance(serverWorld.getDifficulty(), serverWorld.getDayTime(), 0L, serverWorld.getMoonBrightness());
/*  138 */       mobFarmClass.enchantSpawnedEquipment((ServerLevelAccessor)serverWorld, EquipmentSlot.MAINHAND, random, 1.0F, difficultyInstance, this, 0);
/*  141 */       drops.add(crossbow);
/*    0 */     } 
/*  146 */     return drops;
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  151 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  155 */     super.saveAdditional(compound, provider);
/*  157 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  158 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  163 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  164 */     this.timer = compound.getLong("Timer");
/*  165 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  169 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */   
/*    0 */   public void setItem(int slot, ItemStack itemStack) {
/*  174 */     if (slot >= 0 && slot < this.inventory.size()) {
/*  175 */       this.inventory.set(slot, itemStack);
/*  176 */       setChanged();
/*    0 */     } 
/*    0 */   }
/*    0 */ }
