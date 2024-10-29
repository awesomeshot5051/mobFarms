/*   0 */ package com.awesomeshot5051.mobfarms.loottable;
/*   0 */ 
/*   0 */ import com.mojang.datafixers.kinds.App;
/*   0 */ import com.mojang.datafixers.kinds.Applicative;
/*   0 */ import com.mojang.serialization.MapCodec;
/*   0 */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*   0 */ import java.util.List;
/*   0 */ import java.util.function.Function;
/*   0 */ import net.minecraft.core.HolderLookup;
/*   0 */ import net.minecraft.nbt.CompoundTag;
/*   0 */ import net.minecraft.world.item.BlockItem;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntity;
/*   0 */ import net.minecraft.world.level.storage.loot.LootContext;
/*   0 */ import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
/*   0 */ import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
/*   0 */ import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
/*   0 */ import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
/*   0 */ 
/*   0 */ public class CopyBlockEntityData extends LootItemConditionalFunction {
/*   0 */   public static final MapCodec<CopyBlockEntityData> CODEC;
/*   0 */   
/*   0 */   static {
/*  19 */     CODEC = RecordCodecBuilder.mapCodec(instance -> commonFields(instance).apply((Applicative)instance, CopyBlockEntityData::new));
/*   0 */   }
/*   0 */   
/*   0 */   protected CopyBlockEntityData(List<LootItemCondition> conditions) {
/*  22 */     super(conditions);
/*   0 */   }
/*   0 */   
/*   0 */   public ItemStack run(ItemStack stack, LootContext context) {
/*  27 */     BlockEntity blockEntity = (BlockEntity)context.getParamOrNull(LootContextParams.BLOCK_ENTITY);
/*  28 */     if (blockEntity == null)
/*  29 */       return stack; 
/*  31 */     CompoundTag compoundtag = blockEntity.saveCustomAndMetadata((HolderLookup.Provider)context.getLevel().registryAccess());
/*  32 */     BlockItem.setBlockEntityData(stack, blockEntity.getType(), compoundtag);
/*  33 */     stack.applyComponents(blockEntity.collectComponents());
/*  34 */     return stack;
/*   0 */   }
/*   0 */   
/*   0 */   public LootItemFunctionType getType() {
/*  39 */     return (LootItemFunctionType)ModLootTables.COPY_BLOCK_ENTITY.get();
/*   0 */   }
/*   0 */ }
