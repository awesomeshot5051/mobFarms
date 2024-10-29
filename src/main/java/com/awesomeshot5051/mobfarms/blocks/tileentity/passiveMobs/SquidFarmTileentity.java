/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SquidFarmBlock;
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
/*    0 */ import net.minecraft.world.entity.animal.Squid;
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
/*    0 */ public class SquidFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   37 */   private static final ResourceKey<LootTable> SQUID_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/squid"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public SquidFarmTileentity(BlockPos pos, BlockState state) {
/*   47 */     super((BlockEntityType)ModTileEntities.SQUID_FARM.get(), ((SquidFarmBlock)ModBlocks.SQUID_FARM.get()).defaultBlockState(), pos, state);
/*   48 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   49 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   50 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getSquidSpawnTime() {
/*   54 */     return ((Integer)Main.SERVER_CONFIG.squidSpawnTime.get()).intValue() - 200;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getSquidKillTime() {
/*   58 */     return getSquidSpawnTime() + 200;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   62 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   74 */     this.timer++;
/*   75 */     setChanged();
/*   77 */     if (this.timer == getSquidSpawnTime()) {
/*   79 */       sync();
/*   80 */     } else if (this.timer > getSquidSpawnTime() && this.timer < getSquidKillTime()) {
/*   81 */       if (this.timer % 20L == 0L);
/*   84 */     } else if (this.timer >= getSquidKillTime()) {
/*   86 */       for (ItemStack drop : getDrops()) {
/*   87 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   88 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   89 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*   95 */       this.timer = 0L;
/*   96 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*    0 */     ServerLevel serverWorld;
/*  101 */     Level level = this.level;
/*  101 */     if (level instanceof ServerLevel) {
/*  101 */       serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*  102 */       return Collections.emptyList();
/*    0 */     } 
/*  108 */     LootParams.Builder builder = (new LootParams.Builder(serverWorld)).withParameter(LootContextParams.THIS_ENTITY, new Squid(EntityType.SQUID, this.level)).withParameter(LootContextParams.ORIGIN, new Vec3(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ())).withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());
/*  110 */     LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
/*  112 */     LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(SQUID_LOOT_TABLE);
/*  114 */     return (List<ItemStack>)lootTable.getRandomItems(lootContext);
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  118 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  123 */     super.saveAdditional(compound, provider);
/*  125 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  126 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  131 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  132 */     this.timer = compound.getLong("Timer");
/*  133 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  137 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
