/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.OutputItemHandler;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.passiveMobs.SheepFarmBlock;
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
/*    0 */ import net.minecraft.world.entity.EntityType;
/*    0 */ import net.minecraft.world.entity.animal.Sheep;
/*    0 */ import net.minecraft.world.item.DyeColor;
/*    0 */ import net.minecraft.world.item.Item;
/*    0 */ import net.minecraft.world.item.ItemStack;
/*    0 */ import net.minecraft.world.item.Items;
/*    0 */ import net.minecraft.world.level.ItemLike;
/*    0 */ import net.minecraft.world.level.Level;
/*    0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    0 */ import net.minecraft.world.level.block.state.BlockState;
/*    0 */ import net.minecraft.world.level.block.state.properties.Property;
/*    0 */ import net.minecraft.world.level.storage.loot.LootParams;
/*    0 */ import net.minecraft.world.level.storage.loot.LootTable;
/*    0 */ import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
/*    0 */ import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
/*    0 */ import net.minecraft.world.phys.Vec3;
/*    0 */ import net.neoforged.neoforge.items.IItemHandler;
/*    0 */ import net.neoforged.neoforge.items.ItemStackHandler;
/*    0 */ 
/*    0 */ public class SheepFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
/*   43 */   private static final ResourceKey<LootTable> SHEEP_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/sheep"));
/*    0 */   
/*    0 */   protected NonNullList<ItemStack> inventory;
/*    0 */   
/*    0 */   protected long timer;
/*    0 */   
/*    0 */   protected ItemStackHandler itemHandler;
/*    0 */   
/*    0 */   protected OutputItemHandler outputItemHandler;
/*    0 */   
/*    0 */   public SheepFarmTileentity(BlockPos pos, BlockState state) {
/*   53 */     super((BlockEntityType)ModTileEntities.SHEEP_FARM.get(), ((SheepFarmBlock)ModBlocks.SHEEP_FARM.get()).defaultBlockState(), pos, state);
/*   54 */     this.inventory = NonNullList.withSize(4, ItemStack.EMPTY);
/*   55 */     this.itemHandler = new ItemStackHandler(this.inventory);
/*   56 */     this.outputItemHandler = new OutputItemHandler(this.inventory);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getSheepSpawnTime() {
/*   60 */     return ((Integer)Main.SERVER_CONFIG.sheepSpawnTime.get()).intValue() - 200;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getSheepKillTime() {
/*   64 */     return getSheepSpawnTime() + 200;
/*    0 */   }
/*    0 */   
/*    0 */   public long getTimer() {
/*   68 */     return this.timer;
/*    0 */   }
/*    0 */   
/*    0 */   public void tick() {
/*   80 */     this.timer++;
/*   81 */     setChanged();
/*   83 */     if (this.timer == getSheepSpawnTime()) {
/*   85 */       sync();
/*   86 */     } else if (this.timer > getSheepSpawnTime() && this.timer < getSheepKillTime()) {
/*   87 */       if (this.timer % 20L == 0L);
/*   90 */     } else if (this.timer >= getSheepKillTime()) {
/*   92 */       for (ItemStack drop : getDrops()) {
/*   93 */         for (int i = 0; i < this.itemHandler.getSlots(); i++) {
/*   94 */           drop = this.itemHandler.insertItem(i, drop, false);
/*   95 */           if (drop.isEmpty())
/*    0 */             break; 
/*    0 */         } 
/*    0 */       } 
/*  101 */       this.timer = 0L;
/*  102 */       sync();
/*    0 */     } 
/*    0 */   }
/*    0 */   
/*    0 */   private List<ItemStack> getDrops() {
/*    0 */     ServerLevel serverWorld;
/*  107 */     Level level = this.level;
/*  107 */     if (level instanceof ServerLevel) {
/*  107 */       serverWorld = (ServerLevel)level;
/*    0 */     } else {
/*  108 */       return Collections.emptyList();
/*    0 */     } 
/*  115 */     LootParams.Builder builder = (new LootParams.Builder(serverWorld)).withParameter(LootContextParams.THIS_ENTITY, new Sheep(EntityType.SHEEP, this.level)).withParameter(LootContextParams.ORIGIN, new Vec3(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ())).withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().lava());
/*  117 */     LootParams lootContext = builder.create(LootContextParamSets.ENTITY);
/*  120 */     List<ItemStack> drops = new ArrayList<>();
/*  123 */     DyeColor woolColor = getWoolColor();
/*  124 */     ItemStack WoolColor = setWoolColor(woolColor);
/*  125 */     drops.add(WoolColor);
/*  128 */     drops.add(new ItemStack((ItemLike)Items.COOKED_MUTTON, 3));
/*  130 */     return drops;
/*    0 */   }
/*    0 */   
/*    0 */   private ItemStack setWoolColor(DyeColor woolColor) {
/*  134 */     switch (woolColor) {
/*    0 */       case WHITE:
/*    0 */       
/*    0 */       case ORANGE:
/*    0 */       
/*    0 */       case MAGENTA:
/*    0 */       
/*    0 */       case LIGHT_BLUE:
/*    0 */       
/*    0 */       case YELLOW:
/*    0 */       
/*    0 */       case LIME:
/*    0 */       
/*    0 */       case PINK:
/*    0 */       
/*    0 */       case GRAY:
/*    0 */       
/*    0 */       case LIGHT_GRAY:
/*    0 */       
/*    0 */       case CYAN:
/*    0 */       
/*    0 */       case PURPLE:
/*    0 */       
/*    0 */       case BLUE:
/*    0 */       
/*    0 */       case BROWN:
/*    0 */       
/*    0 */       case GREEN:
/*    0 */       
/*    0 */       case RED:
/*    0 */       
/*    0 */       case BLACK:
/*    0 */       
/*    0 */     } 
/*  134 */     return 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */       
/*  151 */       new ItemStack((ItemLike)Items.WHITE_WOOL, 3);
/*    0 */   }
/*    0 */   
/*    0 */   private DyeColor getWoolColor() {
/*  157 */     BlockState state = getBlockState();
/*  158 */     if (state.hasProperty((Property)SheepFarmBlock.COLOR))
/*  159 */       return (DyeColor)state.getValue((Property)SheepFarmBlock.COLOR); 
/*  161 */     return DyeColor.WHITE;
/*    0 */   }
/*    0 */   
/*    0 */   public Container getOutputInventory() {
/*  166 */     return (Container)new ItemListInventory(this.inventory, this::setChanged);
/*    0 */   }
/*    0 */   
/*    0 */   protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  171 */     super.saveAdditional(compound, provider);
/*  173 */     ContainerHelper.saveAllItems(compound, this.inventory, false, provider);
/*  174 */     compound.putLong("Timer", this.timer);
/*    0 */   }
/*    0 */   
/*    0 */   protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
/*  179 */     ContainerHelper.loadAllItems(compound, this.inventory, provider);
/*  180 */     this.timer = compound.getLong("Timer");
/*  181 */     super.loadAdditional(compound, provider);
/*    0 */   }
/*    0 */   
/*    0 */   public IItemHandler getItemHandler() {
/*  185 */     return (IItemHandler)this.outputItemHandler;
/*    0 */   }
/*    0 */   
/*    0 */   private Item getWoolFromColor(DyeColor color) {
/*  189 */     switch (color) {
/*    0 */       case RED:
/*  191 */         return Items.RED_WOOL;
/*    0 */       case BLUE:
/*  193 */         return Items.BLUE_WOOL;
/*    0 */       case GREEN:
/*  195 */         return Items.GREEN_WOOL;
/*    0 */     } 
/*  198 */     return Items.WHITE_WOOL;
/*    0 */   }
/*    0 */ }
