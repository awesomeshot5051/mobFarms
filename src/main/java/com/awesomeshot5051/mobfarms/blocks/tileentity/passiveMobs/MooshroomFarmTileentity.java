/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.MooshroomFarmBlock;
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
/*    0 */ import net.minecraft.world.entity.animal.MushroomCow;
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
/*    0 */ public class MooshroomFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   39 */   private static final ResourceKey<LootTable> MOOSHROOM_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/mooshroom"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public MooshroomFarmTileentity(BlockPos pos, BlockState state) {
/*   47 */     super((BlockEntityType)ModTileEntities.MOOSHROOM_FARM.get(), ((MooshroomFarmBlock)ModBlocks.MOOSHROOM_FARM.get()).defaultBlockState(), pos, state);
/*   48 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   49 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   50 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getMooshroomSpawnTime() {
/*   54 */     return ((Integer)Main.SERVER_CONFIG.mooshroomSpawnTime.get()).intValue() - 200;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getMooshroomKillTime() {
/*   58 */     return getMooshroomSpawnTime() + 200;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   62 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   70 */     this.timer++;
/*   71 */     setChanged();
/*   73 */     if (this.timer == getMooshroomSpawnTime()) {
/*   76 */       sync();
/*   81 */     } else if (this.timer >= getMooshroomKillTime()) {
/*   84 */       for (ItemStack drop : getDrops()) {
/*   85 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   86 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   87 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*   93 */       this.timer = 0L;
/*   94 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*    0 */     ServerLevel serverWorld;
/*   99 */     Level level = this.level;
/*   99 */     if (level instanceof ServerLevel) {
/*   99 */       serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*  100 */       return Collections.emptyList();
/*    0 */     } 
/*  106 */     LootParams.Builder builder = (new LootParams.Builder(serverWorld)).withParameter(LootContextParams.THIS_ENTITY, new MushroomCow(EntityType.MOOSHROOM, this.level)).withParameter(LootContextParams.ORIGIN, new Vec3(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ())).withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());
/*  108 */     LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
/*  110 */     LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(MOOSHROOM_LOOT_TABLE);
/*  112 */     return Collections.singletonList(new ItemStack((ItemLike)Items.MUSHROOM_STEW, 3));
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  116 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  121 */     super.saveAdditional(compound, provider);
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
