package com.awesomeshot5051.mobfarms.loottable;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.function.Function;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class CopyBlockEntityData extends LootItemConditionalFunction {
   public static final MapCodec<CopyBlockEntityData> CODEC;
   
   static {
/*  19 */     CODEC = RecordCodecBuilder.mapCodec(instance -> commonFields(instance).apply((Applicative)instance, CopyBlockEntityData::new));
   }
   
   protected CopyBlockEntityData(List<LootItemCondition> conditions) {
/*  22 */     super(conditions);
   }
   
   public ItemStack run(ItemStack stack, LootContext context) {
/*  27 */     BlockEntity blockEntity = (BlockEntity)context.getParamOrNull(LootContextParams.BLOCK_ENTITY);
/*  28 */     if (blockEntity == null)
/*  29 */       return stack; 
/*  31 */     CompoundTag compoundtag = blockEntity.saveCustomAndMetadata((HolderLookup.Provider)context.getLevel().registryAccess());
/*  32 */     BlockItem.setBlockEntityData(stack, blockEntity.getType(), compoundtag);
/*  33 */     stack.applyComponents(blockEntity.collectComponents());
/*  34 */     return stack;
   }
   
   public LootItemFunctionType getType() {
/*  39 */     return (LootItemFunctionType)ModLootTables.COPY_BLOCK_ENTITY.get();
   }
}
