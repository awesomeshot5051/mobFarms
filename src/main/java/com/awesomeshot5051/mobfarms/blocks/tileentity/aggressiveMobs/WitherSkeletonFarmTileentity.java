/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.aggressiveMobs.WitherSkeletonFarmBlock;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.ModTileEntities;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
/*    0 */ import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
/*    0 */ import de.maxhenkel.corelib.inventory.ItemListInventory;
/*    0 */ import it.unimi.dsi.fastutil.objects.ObjectArrayList;
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
/*    0 */ import net.minecraft.world.entity.EntityType;
/*    0 */ import net.minecraft.world.entity.monster.WitherSkeleton;
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
/*    0 */ public class WitherSkeletonFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   39 */   private static final ResourceKey<LootTable> WITHERSKELETON_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/wither_skeleton"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public WitherSkeletonFarmTileentity(BlockPos pos, BlockState state) {
/*   48 */     super((BlockEntityType)ModTileEntities.WITHER_SKELETON_FARM.get(), ((WitherSkeletonFarmBlock)ModBlocks.WITHER_SKELETON_FARM.get()).defaultBlockState(), pos, state);
/*   49 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   50 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   51 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getWitherSkeletonSpawnTime() {
/*   55 */     return ((Integer)Main.SERVER_CONFIG.witherSkeletonSpawnTime.get()).intValue() - 80;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getWitherSkeletonExplodeTime() {
/*   59 */     return getWitherSkeletonSpawnTime() + 80;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   63 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   71 */     this.timer++;
/*   72 */     setChanged();
/*   74 */     if (this.timer == getWitherSkeletonSpawnTime()) {
/*   77 */       sync();
/*   82 */     } else if (this.timer >= getWitherSkeletonExplodeTime()) {
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
/*  107 */     LootParams.Builder builder = (new LootParams.Builder(serverWorld)).withParameter(LootContextParams.THIS_ENTITY, new WitherSkeleton(EntityType.WITHER_SKELETON, this.level)).withParameter(LootContextParams.ORIGIN, new Vec3(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ())).withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().explosion(null));
/*  109 */     LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
/*  111 */     LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(WITHERSKELETON_LOOT_TABLE);
/*  114 */     ObjectArrayList<ItemStack> objectArrayList = lootTable.getRandomItems(lootContext);
/*  117 */     RandomSource random = serverWorld.getRandom();
/*  118 */     if (random.nextFloat() < 0.06F)
/*  119 */       objectArrayList.add(new ItemStack((ItemLike)Items.WITHER_SKELETON_SKULL)); 
/*  122 */     return (List<ItemStack>)objectArrayList;
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  126 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  131 */     super.saveAdditional(compound, provider);
/*  133 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  134 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  139 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  140 */     this.timer = compound.getLong("Timer");
/*  141 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  145 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */ }
