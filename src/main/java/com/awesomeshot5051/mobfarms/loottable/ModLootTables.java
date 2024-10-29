/*   0 */ package com.awesomeshot5051.mobfarms.loottable;
/*   0 */ 
/*   0 */ import net.minecraft.core.registries.BuiltInRegistries;
/*   0 */ import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
/*   0 */ import net.neoforged.bus.api.IEventBus;
/*   0 */ import net.neoforged.neoforge.registries.DeferredHolder;
/*   0 */ import net.neoforged.neoforge.registries.DeferredRegister;
/*   0 */ 
/*   0 */ public class ModLootTables {
/*  12 */   private static final DeferredRegister<LootItemFunctionType<?>> LOOT_FUNCTION_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.LOOT_FUNCTION_TYPE, "mob_farms");
/*   0 */   
/*  13 */   public static DeferredHolder<LootItemFunctionType<?>, LootItemFunctionType<CopyBlockEntityData>> COPY_BLOCK_ENTITY = LOOT_FUNCTION_TYPE_REGISTER.register("copy_block_entity", () -> new LootItemFunctionType(CopyBlockEntityData.CODEC));
/*   0 */   
/*   0 */   public static void init(IEventBus eventBus) {
/*  16 */     LOOT_FUNCTION_TYPE_REGISTER.register(eventBus);
/*   0 */   }
/*   0 */ }
