/*    0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.BlazeFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.CreeperFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.DrownedFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ElderGuardianFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.EvokerFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GhastFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GuardianFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.HoglinFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.IllusionerFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.MagmaCubeFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PhantomFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.PillagerFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.RavagerFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ShulkerFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SkeletonFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.SlimeFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.VindicatorFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WardenFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitchFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WitherSkeletonFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZoglinFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZombieFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.EndermanFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.GoatFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.IronFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.PiglinFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.SpiderFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.ZombifiedPiglinFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ChickenFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CodFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CowFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.GlowSquidFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.HorseFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.MooshroomFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ParrotFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PufferfishFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.RabbitFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SalmonFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SheepFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SnowGolemFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SquidFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.StriderFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TropicalFishFarmTileentity;
/*    0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TurtleFarmTileentity;
/*    0 */ import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
/*    0 */ import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
/*    0 */ import net.minecraft.core.Direction;
/*    0 */ import net.minecraft.core.registries.BuiltInRegistries;
/*    0 */ import net.minecraft.world.level.block.Block;
/*    0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    0 */ import net.neoforged.api.distmarker.Dist;
/*    0 */ import net.neoforged.api.distmarker.OnlyIn;
/*    0 */ import net.neoforged.bus.api.IEventBus;
/*    0 */ import net.neoforged.neoforge.capabilities.Capabilities;
/*    0 */ import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
/*    0 */ import net.neoforged.neoforge.items.IItemHandler;
/*    0 */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    0 */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    0 */ 
/*    0 */ public class ModTileEntities {
/*   24 */   private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, "mob_farms");
/*    0 */   
/*   27 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InventoryViewerTileentity>> INVENTORY_VIEWER = BLOCK_ENTITY_REGISTER.register("inventory_viewer", () -> BlockEntityType.Builder.of(InventoryViewerTileentity::new, new Block[] { (Block)ModBlocks.INVENTORY_VIEWER.get() }).build(null));
/*    0 */   
/*   31 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChickenFarmTileentity>> CHICKEN_FARM = BLOCK_ENTITY_REGISTER.register("chicken_farm", () -> BlockEntityType.Builder.of(ChickenFarmTileentity::new, new Block[] { (Block)ModBlocks.CHICKEN_FARM.get() }).build(null));
/*    0 */   
/*   35 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CodFarmTileentity>> COD_FARM = BLOCK_ENTITY_REGISTER.register("cod_farm", () -> BlockEntityType.Builder.of(CodFarmTileentity::new, new Block[] { (Block)ModBlocks.COD_FARM.get() }).build(null));
/*    0 */   
/*   39 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CowFarmTileentity>> COW_FARM = BLOCK_ENTITY_REGISTER.register("cow_farm", () -> BlockEntityType.Builder.of(CowFarmTileentity::new, new Block[] { (Block)ModBlocks.COW_FARM.get() }).build(null));
/*    0 */   
/*   43 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GlowSquidFarmTileentity>> GLOW_SQUID_FARM = BLOCK_ENTITY_REGISTER.register("glow_squid_farm", () -> BlockEntityType.Builder.of(GlowSquidFarmTileentity::new, new Block[] { (Block)ModBlocks.GLOW_SQUID_FARM.get() }).build(null));
/*    0 */   
/*   47 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HorseFarmTileentity>> HORSE_FARM = BLOCK_ENTITY_REGISTER.register("horse_farm", () -> BlockEntityType.Builder.of(HorseFarmTileentity::new, new Block[] { (Block)ModBlocks.HORSE_FARM.get() }).build(null));
/*    0 */   
/*   51 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MooshroomFarmTileentity>> MOOSHROOM_FARM = BLOCK_ENTITY_REGISTER.register("mooshroom_farm", () -> BlockEntityType.Builder.of(MooshroomFarmTileentity::new, new Block[] { (Block)ModBlocks.MOOSHROOM_FARM.get() }).build(null));
/*    0 */   
/*   55 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ParrotFarmTileentity>> PARROT_FARM = BLOCK_ENTITY_REGISTER.register("parrot_farm", () -> BlockEntityType.Builder.of(ParrotFarmTileentity::new, new Block[] { (Block)ModBlocks.PARROT_FARM.get() }).build(null));
/*    0 */   
/*   59 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PigFarmTileentity>> PIG_FARM = BLOCK_ENTITY_REGISTER.register("pig_farm", () -> BlockEntityType.Builder.of(PigFarmTileentity::new, new Block[] { (Block)ModBlocks.PIG_FARM.get() }).build(null));
/*    0 */   
/*   63 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PufferfishFarmTileentity>> PUFFERFISH_FARM = BLOCK_ENTITY_REGISTER.register("pufferfish_farm", () -> BlockEntityType.Builder.of(PufferfishFarmTileentity::new, new Block[] { (Block)ModBlocks.PUFFERFISH_FARM.get() }).build(null));
/*    0 */   
/*   67 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RabbitFarmTileentity>> RABBIT_FARM = BLOCK_ENTITY_REGISTER.register("rabbit_farm", () -> BlockEntityType.Builder.of(RabbitFarmTileentity::new, new Block[] { (Block)ModBlocks.RABBIT_FARM.get() }).build(null));
/*    0 */   
/*   71 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SalmonFarmTileentity>> SALMON_FARM = BLOCK_ENTITY_REGISTER.register("salmon_farm", () -> BlockEntityType.Builder.of(SalmonFarmTileentity::new, new Block[] { (Block)ModBlocks.SALMON_FARM.get() }).build(null));
/*    0 */   
/*   75 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SheepFarmTileentity>> SHEEP_FARM = BLOCK_ENTITY_REGISTER.register("sheep_farm", () -> BlockEntityType.Builder.of(SheepFarmTileentity::new, new Block[] { (Block)ModBlocks.SHEEP_FARM.get() }).build(null));
/*    0 */   
/*   80 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SnowGolemFarmTileentity>> SNOW_GOLEM_FARM = BLOCK_ENTITY_REGISTER.register("snow_golem_farm", () -> BlockEntityType.Builder.of(SnowGolemFarmTileentity::new, new Block[] { (Block)ModBlocks.SNOW_GOLEM_FARM.get() }).build(null));
/*    0 */   
/*   84 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SquidFarmTileentity>> SQUID_FARM = BLOCK_ENTITY_REGISTER.register("squid_farm", () -> BlockEntityType.Builder.of(SquidFarmTileentity::new, new Block[] { (Block)ModBlocks.SQUID_FARM.get() }).build(null));
/*    0 */   
/*   88 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StriderFarmTileentity>> STRIDER_FARM = BLOCK_ENTITY_REGISTER.register("strider_farm", () -> BlockEntityType.Builder.of(StriderFarmTileentity::new, new Block[] { (Block)ModBlocks.STRIDER_FARM.get() }).build(null));
/*    0 */   
/*   92 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TropicalFishFarmTileentity>> TROPICAL_FISH_FARM = BLOCK_ENTITY_REGISTER.register("tropical_fish_farm", () -> BlockEntityType.Builder.of(TropicalFishFarmTileentity::new, new Block[] { (Block)ModBlocks.TROPICAL_FISH_FARM.get() }).build(null));
/*    0 */   
/*   96 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TurtleFarmTileentity>> TURTLE_FARM = BLOCK_ENTITY_REGISTER.register("turtle_farm", () -> BlockEntityType.Builder.of(TurtleFarmTileentity::new, new Block[] { (Block)ModBlocks.TURTLE_FARM.get() }).build(null));
/*    0 */   
/*  102 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SpiderFarmTileentity>> SPIDER_FARM = BLOCK_ENTITY_REGISTER.register("spider_farm", () -> BlockEntityType.Builder.of(SpiderFarmTileentity::new, new Block[] { (Block)ModBlocks.SPIDER_FARM.get() }).build(null));
/*    0 */   
/*  106 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EndermanFarmTileentity>> ENDERMAN_FARM = BLOCK_ENTITY_REGISTER.register("enderman_farm", () -> BlockEntityType.Builder.of(EndermanFarmTileentity::new, new Block[] { (Block)ModBlocks.ENDERMAN_FARM.get() }).build(null));
/*    0 */   
/*  110 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoatFarmTileentity>> GOAT_FARM = BLOCK_ENTITY_REGISTER.register("goat_farm", () -> BlockEntityType.Builder.of(GoatFarmTileentity::new, new Block[] { (Block)ModBlocks.GOAT_FARM.get() }).build(null));
/*    0 */   
/*  114 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronFarmTileentity>> IRON_FARM = BLOCK_ENTITY_REGISTER.register("iron_farm", () -> BlockEntityType.Builder.of(IronFarmTileentity::new, new Block[] { (Block)ModBlocks.IRON_FARM.get() }).build(null));
/*    0 */   
/*  118 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PiglinFarmTileentity>> PIGLIN_FARM = BLOCK_ENTITY_REGISTER.register("piglin_farm", () -> BlockEntityType.Builder.of(PiglinFarmTileentity::new, new Block[] { (Block)ModBlocks.PIGLIN_FARM.get() }).build(null));
/*    0 */   
/*  122 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZombifiedPiglinFarmTileentity>> ZOMBIFIED_PIGLIN_FARM = BLOCK_ENTITY_REGISTER.register("zombified_piglin_farm", () -> BlockEntityType.Builder.of(ZombifiedPiglinFarmTileentity::new, new Block[] { (Block)ModBlocks.ZOMBIFIED_PIGLIN_FARM.get() }).build(null));
/*    0 */   
/*  128 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DrownedFarmTileentity>> DROWNED_FARM = BLOCK_ENTITY_REGISTER.register("drowned_farm", () -> BlockEntityType.Builder.of(DrownedFarmTileentity::new, new Block[] { (Block)ModBlocks.DROWNED_FARM.get() }).build(null));
/*    0 */   
/*  131 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ElderGuardianFarmTileentity>> ELDER_GUARDIAN_FARM = BLOCK_ENTITY_REGISTER.register("elder_guardian_farm", () -> BlockEntityType.Builder.of(ElderGuardianFarmTileentity::new, new Block[] { (Block)ModBlocks.ELDER_GUARDIAN_FARM.get() }).build(null));
/*    0 */   
/*  134 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvokerFarmTileentity>> EVOKER_FARM = BLOCK_ENTITY_REGISTER.register("evoker_farm", () -> BlockEntityType.Builder.of(EvokerFarmTileentity::new, new Block[] { (Block)ModBlocks.EVOKER_FARM.get() }).build(null));
/*    0 */   
/*    0 */   @OnlyIn(Dist.CLIENT)
/*    0 */   public static void clientSetup() {
/*  139 */     if (!((Boolean)Main.CLIENT_CONFIG.renderBlockContents.get()).booleanValue())
/*    0 */       return; 
/*  143 */     BlockEntityRenderers.register((BlockEntityType)CHICKEN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.ChickenFarmRenderer::new);
/*  144 */     BlockEntityRenderers.register((BlockEntityType)COD_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.CodFarmRenderer::new);
/*  145 */     BlockEntityRenderers.register((BlockEntityType)COW_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.CowFarmRenderer::new);
/*  146 */     BlockEntityRenderers.register((BlockEntityType)GLOW_SQUID_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.GlowSquidFarmRenderer::new);
/*  147 */     BlockEntityRenderers.register((BlockEntityType)HORSE_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.HorseFarmRenderer::new);
/*  148 */     BlockEntityRenderers.register((BlockEntityType)MOOSHROOM_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.MooshroomFarmRenderer::new);
/*  149 */     BlockEntityRenderers.register((BlockEntityType)PARROT_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.ParrotFarmRenderer::new);
/*  150 */     BlockEntityRenderers.register((BlockEntityType)PIG_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PigFarmRenderer::new);
/*  151 */     BlockEntityRenderers.register((BlockEntityType)PUFFERFISH_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PufferfishFarmRenderer::new);
/*  152 */     BlockEntityRenderers.register((BlockEntityType)RABBIT_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.RabbitFarmRenderer::new);
/*  153 */     BlockEntityRenderers.register((BlockEntityType)SALMON_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SalmonFarmRenderer::new);
/*  154 */     BlockEntityRenderers.register((BlockEntityType)SHEEP_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SheepFarmRenderer::new);
/*  155 */     BlockEntityRenderers.register((BlockEntityType)SNOW_GOLEM_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SnowGolemFarmRenderer::new);
/*  156 */     BlockEntityRenderers.register((BlockEntityType)SQUID_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SquidFarmRenderer::new);
/*  157 */     BlockEntityRenderers.register((BlockEntityType)STRIDER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.StriderFarmRenderer::new);
/*  158 */     BlockEntityRenderers.register((BlockEntityType)TROPICAL_FISH_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.TropicalFishFarmRenderer::new);
/*  159 */     BlockEntityRenderers.register((BlockEntityType)TURTLE_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.TurtleFarmRenderer::new);
/*  162 */     BlockEntityRenderers.register((BlockEntityType)SPIDER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.SpiderFarmRenderer::new);
/*  163 */     BlockEntityRenderers.register((BlockEntityType)ENDERMAN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.EndermanFarmRenderer::new);
/*  164 */     BlockEntityRenderers.register((BlockEntityType)GOAT_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.GoatFarmRenderer::new);
/*  165 */     BlockEntityRenderers.register((BlockEntityType)IRON_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.IronFarmRenderer::new);
/*  166 */     BlockEntityRenderers.register((BlockEntityType)PIGLIN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.PiglinFarmRenderer::new);
/*  167 */     BlockEntityRenderers.register((BlockEntityType)ZOMBIFIED_PIGLIN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.ZombifiedPiglinFarmRenderer::new);
/*  170 */     BlockEntityRenderers.register((BlockEntityType)BLAZE_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.BlazeFarmRenderer::new);
/*  171 */     BlockEntityRenderers.register((BlockEntityType)CREEPER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.CreeperFarmRenderer::new);
/*  172 */     BlockEntityRenderers.register((BlockEntityType)DROWNED_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.DrownedFarmRenderer::new);
/*  173 */     BlockEntityRenderers.register((BlockEntityType)ELDER_GUARDIAN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ElderGuardianFarmRenderer::new);
/*  174 */     BlockEntityRenderers.register((BlockEntityType)EVOKER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.EvokerFarmRenderer::new);
/*  175 */     BlockEntityRenderers.register((BlockEntityType)GHAST_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.GhastFarmRenderer::new);
/*  176 */     BlockEntityRenderers.register((BlockEntityType)GUARDIAN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.GuardianFarmRenderer::new);
/*  177 */     BlockEntityRenderers.register((BlockEntityType)HOGLIN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.HoglinFarmRenderer::new);
/*  178 */     BlockEntityRenderers.register((BlockEntityType)ILLUSIONER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.IllusionerFarmRenderer::new);
/*  179 */     BlockEntityRenderers.register((BlockEntityType)MAGMA_CUBE_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.MagmaCubeFarmRenderer::new);
/*  180 */     BlockEntityRenderers.register((BlockEntityType)PHANTOM_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.PhantomFarmRenderer::new);
/*  181 */     BlockEntityRenderers.register((BlockEntityType)PILLAGER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.PillagerFarmRenderer::new);
/*  182 */     BlockEntityRenderers.register((BlockEntityType)RAVAGER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.RavagerFarmRenderer::new);
/*  183 */     BlockEntityRenderers.register((BlockEntityType)SHULKER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ShulkerFarmRenderer::new);
/*  184 */     BlockEntityRenderers.register((BlockEntityType)SKELETON_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.SkeletonFarmRenderer::new);
/*  185 */     BlockEntityRenderers.register((BlockEntityType)SLIME_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.SlimeFarmRenderer::new);
/*  186 */     BlockEntityRenderers.register((BlockEntityType)WITHER_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitherFarmRenderer::new);
/*  187 */     BlockEntityRenderers.register((BlockEntityType)VINDICATOR_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.VindicatorFarmRenderer::new);
/*  188 */     BlockEntityRenderers.register((BlockEntityType)WARDEN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WardenFarmRenderer::new);
/*  189 */     BlockEntityRenderers.register((BlockEntityType)WITCH_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitchFarmRenderer::new);
/*  190 */     BlockEntityRenderers.register((BlockEntityType)WITHER_SKELETON_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WitherSkeletonFarmRenderer::new);
/*  191 */     BlockEntityRenderers.register((BlockEntityType)ZOMBIE_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZombieFarmRenderer::new);
/*  192 */     BlockEntityRenderers.register((BlockEntityType)ZOGLIN_FARM.get(), com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZoglinFarmRenderer::new);
/*    0 */   }
/*    0 */   
/*    0 */   public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
/*  199 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)CHICKEN_FARM.get(), (object, context) -> object.getItemHandler());
/*  200 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)COD_FARM.get(), (object, context) -> object.getItemHandler());
/*  201 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)COW_FARM.get(), (object, context) -> object.getItemHandler());
/*  202 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)GLOW_SQUID_FARM.get(), (object, context) -> object.getItemHandler());
/*  203 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)HORSE_FARM.get(), (object, context) -> object.getItemHandler());
/*  204 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)MOOSHROOM_FARM.get(), (object, context) -> object.getItemHandler());
/*  205 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)PARROT_FARM.get(), (object, context) -> object.getItemHandler());
/*  206 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)PIG_FARM.get(), (object, context) -> object.getItemHandler());
/*  207 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)PUFFERFISH_FARM.get(), (object, context) -> object.getItemHandler());
/*  208 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)RABBIT_FARM.get(), (object, context) -> object.getItemHandler());
/*  209 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SALMON_FARM.get(), (object, context) -> object.getItemHandler());
/*  210 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SHEEP_FARM.get(), (object, context) -> object.getItemHandler());
/*  211 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SNOW_GOLEM_FARM.get(), (object, context) -> object.getItemHandler());
/*  212 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SQUID_FARM.get(), (object, context) -> object.getItemHandler());
/*  213 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)STRIDER_FARM.get(), (object, context) -> object.getItemHandler());
/*  214 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)TROPICAL_FISH_FARM.get(), (object, context) -> object.getItemHandler());
/*  215 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)TURTLE_FARM.get(), (object, context) -> object.getItemHandler());
/*  218 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SPIDER_FARM.get(), (object, context) -> object.getItemHandler());
/*  219 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)ENDERMAN_FARM.get(), (object, context) -> object.getItemHandler());
/*  220 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)GOAT_FARM.get(), (object, context) -> object.getItemHandler());
/*  221 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)IRON_FARM.get(), (object, context) -> object.getItemHandler());
/*  222 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)PIGLIN_FARM.get(), (object, context) -> object.getItemHandler());
/*  223 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)ZOMBIFIED_PIGLIN_FARM.get(), (object, context) -> object.getItemHandler());
/*  226 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)BLAZE_FARM.get(), (object, context) -> object.getItemHandler());
/*  227 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)CREEPER_FARM.get(), (object, context) -> object.getItemHandler());
/*  228 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)DROWNED_FARM.get(), (object, context) -> object.getItemHandler());
/*  229 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)ELDER_GUARDIAN_FARM.get(), (object, context) -> object.getItemHandler());
/*  230 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)EVOKER_FARM.get(), (object, context) -> object.getItemHandler());
/*  231 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)GHAST_FARM.get(), (object, context) -> object.getItemHandler());
/*  232 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)GUARDIAN_FARM.get(), (object, context) -> object.getItemHandler());
/*  233 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)HOGLIN_FARM.get(), (object, context) -> object.getItemHandler());
/*  234 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)ILLUSIONER_FARM.get(), (object, context) -> object.getItemHandler());
/*  235 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)MAGMA_CUBE_FARM.get(), (object, context) -> object.getItemHandler());
/*  236 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)PHANTOM_FARM.get(), (object, context) -> object.getItemHandler());
/*  237 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)PILLAGER_FARM.get(), (object, context) -> object.getItemHandler());
/*  238 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)RAVAGER_FARM.get(), (object, context) -> object.getItemHandler());
/*  239 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SHULKER_FARM.get(), (object, context) -> object.getItemHandler());
/*  240 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SKELETON_FARM.get(), (object, context) -> object.getItemHandler());
/*  241 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)SLIME_FARM.get(), (object, context) -> object.getItemHandler());
/*  242 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)WITHER_FARM.get(), (object, context) -> object.getItemHandler());
/*  243 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)VINDICATOR_FARM.get(), (object, context) -> object.getItemHandler());
/*  244 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)WARDEN_FARM.get(), (object, context) -> object.getItemHandler());
/*  245 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)WITCH_FARM.get(), (object, context) -> object.getItemHandler());
/*  246 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)WITHER_SKELETON_FARM.get(), (object, context) -> object.getItemHandler());
/*  247 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)ZOGLIN_FARM.get(), (object, context) -> object.getItemHandler());
/*  248 */     event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, (BlockEntityType)ZOMBIE_FARM.get(), (object, context) -> object.getItemHandler());
/*    0 */   }
/*    0 */   
/*  250 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GhastFarmTileentity>> GHAST_FARM = BLOCK_ENTITY_REGISTER.register("ghast_farm", () -> BlockEntityType.Builder.of(GhastFarmTileentity::new, new Block[] { (Block)ModBlocks.GHAST_FARM.get() }).build(null));
/*    0 */   
/*  253 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeFarmTileentity>> BLAZE_FARM = BLOCK_ENTITY_REGISTER.register("blaze_farm", () -> BlockEntityType.Builder.of(BlazeFarmTileentity::new, new Block[] { (Block)ModBlocks.BLAZE_FARM.get() }).build(null));
/*    0 */   
/*  257 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreeperFarmTileentity>> CREEPER_FARM = BLOCK_ENTITY_REGISTER.register("creeper_farm", () -> BlockEntityType.Builder.of(CreeperFarmTileentity::new, new Block[] { (Block)ModBlocks.CREEPER_FARM.get() }).build(null));
/*    0 */   
/*  260 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GuardianFarmTileentity>> GUARDIAN_FARM = BLOCK_ENTITY_REGISTER.register("guardian_farm", () -> BlockEntityType.Builder.of(GuardianFarmTileentity::new, new Block[] { (Block)ModBlocks.GUARDIAN_FARM.get() }).build(null));
/*    0 */   
/*  263 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HoglinFarmTileentity>> HOGLIN_FARM = BLOCK_ENTITY_REGISTER.register("hoglin_farm", () -> BlockEntityType.Builder.of(HoglinFarmTileentity::new, new Block[] { (Block)ModBlocks.HOGLIN_FARM.get() }).build(null));
/*    0 */   
/*  266 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IllusionerFarmTileentity>> ILLUSIONER_FARM = BLOCK_ENTITY_REGISTER.register("illusioner_farm", () -> BlockEntityType.Builder.of(IllusionerFarmTileentity::new, new Block[] { (Block)ModBlocks.ILLUSIONER_FARM.get() }).build(null));
/*    0 */   
/*  269 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MagmaCubeFarmTileentity>> MAGMA_CUBE_FARM = BLOCK_ENTITY_REGISTER.register("magma_cube_farm", () -> BlockEntityType.Builder.of(MagmaCubeFarmTileentity::new, new Block[] { (Block)ModBlocks.MAGMA_CUBE_FARM.get() }).build(null));
/*    0 */   
/*  272 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PhantomFarmTileentity>> PHANTOM_FARM = BLOCK_ENTITY_REGISTER.register("phantom_farm", () -> BlockEntityType.Builder.of(PhantomFarmTileentity::new, new Block[] { (Block)ModBlocks.PHANTOM_FARM.get() }).build(null));
/*    0 */   
/*  275 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PillagerFarmTileentity>> PILLAGER_FARM = BLOCK_ENTITY_REGISTER.register("pillager_farm", () -> BlockEntityType.Builder.of(PillagerFarmTileentity::new, new Block[] { (Block)ModBlocks.PILLAGER_FARM.get() }).build(null));
/*    0 */   
/*  278 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RavagerFarmTileentity>> RAVAGER_FARM = BLOCK_ENTITY_REGISTER.register("ravager_farm", () -> BlockEntityType.Builder.of(RavagerFarmTileentity::new, new Block[] { (Block)ModBlocks.RAVAGER_FARM.get() }).build(null));
/*    0 */   
/*  281 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ShulkerFarmTileentity>> SHULKER_FARM = BLOCK_ENTITY_REGISTER.register("shulker_farm", () -> BlockEntityType.Builder.of(ShulkerFarmTileentity::new, new Block[] { (Block)ModBlocks.SHULKER_FARM.get() }).build(null));
/*    0 */   
/*  284 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SkeletonFarmTileentity>> SKELETON_FARM = BLOCK_ENTITY_REGISTER.register("skeleton_farm", () -> BlockEntityType.Builder.of(SkeletonFarmTileentity::new, new Block[] { (Block)ModBlocks.SKELETON_FARM.get() }).build(null));
/*    0 */   
/*  287 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SlimeFarmTileentity>> SLIME_FARM = BLOCK_ENTITY_REGISTER.register("slime_farm", () -> BlockEntityType.Builder.of(SlimeFarmTileentity::new, new Block[] { (Block)ModBlocks.SLIME_FARM.get() }).build(null));
/*    0 */   
/*  290 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VindicatorFarmTileentity>> VINDICATOR_FARM = BLOCK_ENTITY_REGISTER.register("vindicator_farm", () -> BlockEntityType.Builder.of(VindicatorFarmTileentity::new, new Block[] { (Block)ModBlocks.VINDICATOR_FARM.get() }).build(null));
/*    0 */   
/*  293 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WardenFarmTileentity>> WARDEN_FARM = BLOCK_ENTITY_REGISTER.register("warden_farm", () -> BlockEntityType.Builder.of(WardenFarmTileentity::new, new Block[] { (Block)ModBlocks.WARDEN_FARM.get() }).build(null));
/*    0 */   
/*  296 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitchFarmTileentity>> WITCH_FARM = BLOCK_ENTITY_REGISTER.register("witch_farm", () -> BlockEntityType.Builder.of(WitchFarmTileentity::new, new Block[] { (Block)ModBlocks.WITCH_FARM.get() }).build(null));
/*    0 */   
/*  301 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitherFarmTileentity>> WITHER_FARM = BLOCK_ENTITY_REGISTER.register("wither_farm", () -> BlockEntityType.Builder.of(WitherFarmTileentity::new, new Block[] { (Block)ModBlocks.WITHER_FARM.get() }).build(null));
/*    0 */   
/*  304 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitherSkeletonFarmTileentity>> WITHER_SKELETON_FARM = BLOCK_ENTITY_REGISTER.register("wither_skeleton_farm", () -> BlockEntityType.Builder.of(WitherSkeletonFarmTileentity::new, new Block[] { (Block)ModBlocks.WITHER_SKELETON_FARM.get() }).build(null));
/*    0 */   
/*  307 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZoglinFarmTileentity>> ZOGLIN_FARM = BLOCK_ENTITY_REGISTER.register("zoglin_farm", () -> BlockEntityType.Builder.of(ZoglinFarmTileentity::new, new Block[] { (Block)ModBlocks.ZOGLIN_FARM.get() }).build(null));
/*    0 */   
/*  310 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZombieFarmTileentity>> ZOMBIE_FARM = BLOCK_ENTITY_REGISTER.register("zombie_farm", () -> BlockEntityType.Builder.of(ZombieFarmTileentity::new, new Block[] { (Block)ModBlocks.ZOMBIE_FARM.get() }).build(null));
/*    0 */   
/*    0 */   public static void init(IEventBus eventBus) {
/*  318 */     BLOCK_ENTITY_REGISTER.register(eventBus);
/*    0 */   }
/*    0 */ }
