/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.ElderGuardianFarmBlock;
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
/*    0 */ import net.minecraft.world.entity.monster.ElderGuardian;
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
/*    0 */ public class ElderGuardianFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   37 */   private static final ResourceKey<LootTable> ELDERGUARDIAN_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/elder_guardian"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public ElderGuardianFarmTileentity(BlockPos pos, BlockState state) {
/*   46 */     super((BlockEntityType)ModTileEntities.ELDER_GUARDIAN_FARM.get(), ((ElderGuardianFarmBlock)ModBlocks.ELDER_GUARDIAN_FARM.get()).defaultBlockState(), pos, state);
/*   47 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   48 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   49 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getElderGuardianSpawnTime() {
/*   53 */     return ((Integer)Main.SERVER_CONFIG.elderGuardianSpawnTime.get()).intValue() - 80;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getElderGuardianExplodeTime() {
/*   57 */     return getElderGuardianSpawnTime() + 80;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   61 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   69 */     this.timer++;
/*   70 */     setChanged();
/*   72 */     if (this.timer == getElderGuardianSpawnTime()) {
/*   75 */       sync();
/*   80 */     } else if (this.timer >= getElderGuardianExplodeTime()) {
/*   83 */       for (ItemStack drop : getDrops()) {
/*   84 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   85 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   86 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*   92 */       this.timer = 0L;
/*   93 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*    0 */     ServerLevel serverWorld;
/*   98 */     Level level = this.level;
/*   98 */     if (level instanceof ServerLevel) {
/*   98 */       serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*   99 */       return Collections.emptyList();
/*    0 */     } 
/*  105 */     LootParams.Builder builder = (new LootParams.Builder(serverWorld)).withParameter(LootContextParams.THIS_ENTITY, new ElderGuardian(EntityType.ELDER_GUARDIAN, this.level)).withParameter(LootContextParams.ORIGIN, new Vec3(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ())).withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().explosion(null));
/*  107 */     LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
/*  109 */     LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(ELDERGUARDIAN_LOOT_TABLE);
/*  111 */     return (List<ItemStack>)lootTable.getRandomItems(lootContext);
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
