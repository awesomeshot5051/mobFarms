/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.DrownedFarmBlock;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
/*    0 */ import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
/*    0 */ import de.maxhenkel.corelib.inventory.ItemListInventory;
/*    0 */ import java.util.ArrayList;
/*    0 */ import java.util.Collection;
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
/*    0 */ import net.minecraft.world.entity.EntityType;
/*    0 */ import net.minecraft.world.entity.monster.Drowned;
/*    0 */ import net.minecraft.world.item.ItemStack;
/*    0 */ import net.minecraft.world.item.Items;
/*    0 */ import net.minecraft.world.level.ItemLike;
/*    0 */ import net.minecraft.world.level.Level;
/*    0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    0 */ import net.minecraft.world.level.block.state.BlockState;
/*    0 */ import net.minecraft.world.level.storage.loot.LootParams;
/*    0 */ import net.minecraft.world.level.storage.loot.LootTable;
/*    0 */ import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
/*    0 */ import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
/*    0 */ import net.minecraft.world.phys.Vec3;
/*    0 */ import net.neoforged.neoforge.items.IItemHandler;
/*    0 */ import net.neoforged.neoforge.items.ItemStackHandler;
/*    0 */ 
/*    0 */ public class DrownedFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   39 */   private static final ResourceKey<LootTable> DROWNED_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/drowned"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public DrownedFarmTileentity(BlockPos pos, BlockState state) {
/*   48 */     super((BlockEntityType)ModTileEntities.DROWNED_FARM.get(), ((DrownedFarmBlock)ModBlocks.DROWNED_FARM.get()).defaultBlockState(), pos, state);
/*   49 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   50 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   51 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getDrownedSpawnTime() {
/*   55 */     return ((Integer)Main.SERVER_CONFIG.drownedSpawnTime.get()).intValue() - 80;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getDrownedExplodeTime() {
/*   59 */     return getDrownedSpawnTime() + 80;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   63 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   71 */     this.timer++;
/*   72 */     setChanged();
/*   74 */     if (this.timer == getDrownedSpawnTime()) {
/*   77 */       sync();
/*   82 */     } else if (this.timer >= getDrownedExplodeTime()) {
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
/*  110 */     LootParams.Builder builder = (new LootParams.Builder(serverWorld)).withParameter(LootContextParams.THIS_ENTITY, new Drowned(EntityType.DROWNED, this.level)).withParameter(LootContextParams.ORIGIN, new Vec3(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ())).withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().explosion(null));
/*  112 */     LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
/*  113 */     LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(DROWNED_LOOT_TABLE);
/*  116 */     drops.addAll((Collection<? extends ItemStack>)lootTable.getRandomItems(lootContext));
/*  119 */     if (serverWorld.random.nextFloat() < 0.5F)
/*  120 */       drops.add(new ItemStack((ItemLike)Items.NAUTILUS_SHELL)); 
/*  123 */     if (serverWorld.random.nextFloat() < 0.1F)
/*  124 */       drops.add(new ItemStack((ItemLike)Items.TRIDENT)); 
/*  127 */     return drops;
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  132 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  137 */     super.saveAdditional(compound, provider);
/*  139 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  140 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  145 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  146 */     this.timer = compound.getLong("Timer");
/*  147 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  151 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
