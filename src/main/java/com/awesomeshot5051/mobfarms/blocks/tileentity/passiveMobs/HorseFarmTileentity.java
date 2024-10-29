/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.HorseFarmBlock;
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
/*    0 */ import net.minecraft.world.entity.EntityType;
/*    0 */ import net.minecraft.world.entity.animal.horse.Horse;
/*    0 */ import net.minecraft.world.item.ItemStack;
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
/*    0 */ public class HorseFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   37 */   private static final ResourceKey<LootTable> HORSE_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/horse"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public HorseFarmTileentity(BlockPos pos, BlockState state) {
/*   45 */     super((BlockEntityType)ModTileEntities.HORSE_FARM.get(), ((HorseFarmBlock)ModBlocks.HORSE_FARM.get()).defaultBlockState(), pos, state);
/*   46 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   47 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   48 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getHorseSpawnTime() {
/*   52 */     return ((Integer)Main.SERVER_CONFIG.horseSpawnTime.get()).intValue() - 200;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getHorseKillTime() {
/*   56 */     return getHorseSpawnTime() + 200;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   60 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   65 */     this.timer++;
/*   66 */     setChanged();
/*   68 */     if (this.timer == getHorseSpawnTime()) {
/*   69 */       sync();
/*   70 */     } else if (this.timer >= getHorseKillTime()) {
/*   71 */       for (ItemStack drop : getDrops()) {
/*   72 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   73 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   74 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*   80 */       this.timer = 0L;
/*   81 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*    0 */     ServerLevel serverWorld;
/*   86 */     Level level = this.level;
/*   86 */     if (level instanceof ServerLevel) {
/*   86 */       serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*   87 */       return Collections.emptyList();
/*    0 */     } 
/*   93 */     LootParams.Builder builder = (new LootParams.Builder(serverWorld)).withParameter(LootContextParams.THIS_ENTITY, new Horse(EntityType.HORSE, this.level)).withParameter(LootContextParams.ORIGIN, new Vec3(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ())).withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().generic());
/*   95 */     LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
/*   97 */     LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(HORSE_LOOT_TABLE);
/*   99 */     return (List<ItemStack>)lootTable.getRandomItems(lootContext);
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  103 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  108 */     super.saveAdditional(compound, provider);
/*  109 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  110 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  115 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  116 */     this.timer = compound.getLong("Timer");
/*  117 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  121 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
