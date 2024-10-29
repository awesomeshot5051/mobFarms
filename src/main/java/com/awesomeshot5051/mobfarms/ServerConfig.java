/*    0 */ package com.awesomeshot5051.mobfarms;
/*    0 */ 
/*    0 */ import de.maxhenkel.corelib.config.ConfigBase;
/*    0 */ import net.neoforged.neoforge.common.ModConfigSpec;
/*    0 */ 
/*    0 */ public class ServerConfig extends ConfigBase {
/*    0 */   public final ModConfigSpec.IntValue chickenSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue codSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue cowSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue glowSquidSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue horseSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue mooshroomSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue parrotSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue pigSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue pufferfishSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue rabbitSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue salmonSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue sheepSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue snowGolemSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue squidSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue striderSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue tropicalFishSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue turtleSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue spiderSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue endermanSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue goatSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue golemSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue piglinSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue zombifiedPiglinSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue blazeSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue creeperSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue drownedSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue elderGuardianSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue evokerSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue ghastSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue guardianSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue hoglinSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue illusionerSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue magmaCubeSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue phantomSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue pillagerSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue ravagerSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue shulkerSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue skeletonSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue slimeSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue vexSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue vindicatorSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue wardenSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue witchSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue witherSkeletonSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue zoglinSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue zombieSpawnTime;
/*    0 */   
/*    0 */   public final ModConfigSpec.BooleanValue universalReputation;
/*    0 */   
/*    0 */   public final ModConfigSpec.IntValue witherSpawnTime;
/*    0 */   
/*    0 */   public ServerConfig(ModConfigSpec.Builder builder) {
/*   64 */     super(builder);
/*   68 */     this
/*   69 */       .chickenSpawnTime = builder.comment("The time in ticks the chicken farm takes to spawn a chicken").defineInRange("chicken_farm.spawn_time", 60, 60, 60);
/*   71 */     this
/*   72 */       .codSpawnTime = builder.comment("The time in ticks the cod farm takes to spawn a cod").defineInRange("cod_farm.spawn_time", 60, 60, 60);
/*   74 */     this
/*   75 */       .cowSpawnTime = builder.comment("The time in ticks the cow farm takes to spawn a cow").defineInRange("cow_farm.spawn_time", 60, 60, 60);
/*   77 */     this
/*   78 */       .glowSquidSpawnTime = builder.comment("The time in ticks the glow squid farm takes to spawn a glow squid").defineInRange("glow_squid_farm.spawn_time", 60, 60, 60);
/*   80 */     this
/*   81 */       .horseSpawnTime = builder.comment("The time in ticks the horse farm takes to spawn a horse").defineInRange("horse_farm.spawn_time", 60, 60, 60);
/*   83 */     this
/*   84 */       .mooshroomSpawnTime = builder.comment("The time in ticks the mooshroom farm takes to spawn a mooshroom").defineInRange("mooshroom_farm.spawn_time", 60, 60, 60);
/*   86 */     this
/*   87 */       .parrotSpawnTime = builder.comment("The time in ticks the parrot farm takes to spawn a parrot").defineInRange("parrot_farm.spawn_time", 60, 60, 60);
/*   89 */     this
/*   90 */       .pigSpawnTime = builder.comment("The time in ticks the pig farm takes to spawn a pig").defineInRange("pig_farm.spawn_time", 60, 60, 60);
/*   92 */     this
/*   93 */       .pufferfishSpawnTime = builder.comment("The time in ticks the pufferfish farm takes to spawn a pufferfish").defineInRange("pufferfish_farm.spawn_time", 60, 60, 60);
/*   95 */     this
/*   96 */       .rabbitSpawnTime = builder.comment("The time in ticks the rabbit farm takes to spawn a rabbit").defineInRange("rabbit_farm.spawn_time", 60, 60, 60);
/*   98 */     this
/*   99 */       .salmonSpawnTime = builder.comment("The time in ticks the salmon farm takes to spawn a salmon").defineInRange("salmon_farm.spawn_time", 60, 60, 60);
/*  101 */     this
/*  102 */       .sheepSpawnTime = builder.comment("The time in ticks the sheep farm takes to spawn a sheep").defineInRange("sheep_farm.spawn_time", 60, 60, 60);
/*  104 */     this
/*  105 */       .snowGolemSpawnTime = builder.comment("The time in ticks the snow golem farm takes to spawn a snow golem").defineInRange("snow_golem_farm.spawn_time", 60, 60, 60);
/*  107 */     this
/*  108 */       .squidSpawnTime = builder.comment("The time in ticks the squid farm takes to spawn a squid").defineInRange("squid_farm.spawn_time", 60, 60, 60);
/*  110 */     this
/*  111 */       .striderSpawnTime = builder.comment("The time in ticks the strider farm takes to spawn a strider").defineInRange("strider_farm.spawn_time", 60, 60, 60);
/*  113 */     this
/*  114 */       .tropicalFishSpawnTime = builder.comment("The time in ticks the tropical fish farm takes to spawn a tropical fish").defineInRange("tropical_fish_farm.spawn_time", 60, 60, 60);
/*  116 */     this
/*  117 */       .turtleSpawnTime = builder.comment("The time in ticks the turtle farm takes to spawn a turtle").defineInRange("turtle_farm.spawn_time", 60, 60, 60);
/*  120 */     this
/*    0 */       
/*  122 */       .endermanSpawnTime = builder.comment("The time in ticks the enderman farm takes to spawn an enderman").defineInRange("enderman_farm.spawn_time", 60, 60, 60);
/*  124 */     this
/*    0 */       
/*  126 */       .goatSpawnTime = builder.comment("The time in ticks the goat farm takes to spawn a goat").defineInRange("goat_farm.spawn_time", 60, 60, 60);
/*  128 */     this
/*    0 */       
/*  130 */       .golemSpawnTime = builder.comment("The time in ticks the iron farm takes to spawn an iron golem").defineInRange("iron_golem_farm.spawn_time", 60, 60, 60);
/*  132 */     this
/*    0 */       
/*  134 */       .piglinSpawnTime = builder.comment("The time in ticks the piglin farm takes to spawn a piglin").defineInRange("piglin_farm.spawn_time", 60, 60, 60);
/*  136 */     this
/*    0 */       
/*  138 */       .spiderSpawnTime = builder.comment("The time in ticks the spider farm takes to spawn a spider").defineInRange("spider_farm.spawn_time", 60, 60, 60);
/*  139 */     this
/*    0 */       
/*  141 */       .zombifiedPiglinSpawnTime = builder.comment("The time in ticks the zombified piglin farm takes to spawn a zombified piglin").defineInRange("zombified_piglin_farm.spawn_time", 60, 60, 60);
/*  145 */     this
/*    0 */       
/*  147 */       .blazeSpawnTime = builder.comment("The time in ticks the blaze farm takes to spawn a blaze").defineInRange("blaze_farm.spawn_time", 60, 60, 60);
/*  149 */     this
/*    0 */       
/*  151 */       .creeperSpawnTime = builder.comment("The time in ticks the creeper farm takes to spawn a creeper").defineInRange("creeper_farm.spawn_time", 60, 60, 60);
/*  153 */     this
/*    0 */       
/*  155 */       .drownedSpawnTime = builder.comment("The time in ticks the drowned farm takes to spawn a drowned").defineInRange("drowned_farm.spawn_time", 60, 60, 60);
/*  157 */     this
/*    0 */       
/*  159 */       .elderGuardianSpawnTime = builder.comment("The time in ticks the elder guardian farm takes to spawn an elder guardian").defineInRange("elder_guardian_farm.spawn_time", 60, 60, 60);
/*  161 */     this
/*    0 */       
/*  163 */       .evokerSpawnTime = builder.comment("The time in ticks the evoker farm takes to spawn an evoker").defineInRange("evoker_farm.spawn_time", 60, 60, 60);
/*  165 */     this
/*    0 */       
/*  167 */       .ghastSpawnTime = builder.comment("The time in ticks the ghast farm takes to spawn a ghast").defineInRange("ghast_farm.spawn_time", 60, 60, 60);
/*  169 */     this
/*    0 */       
/*  171 */       .guardianSpawnTime = builder.comment("The time in ticks the guardian farm takes to spawn a guardian").defineInRange("guardian_farm.spawn_time", 60, 60, 60);
/*  173 */     this
/*    0 */       
/*  175 */       .hoglinSpawnTime = builder.comment("The time in ticks the hoglin farm takes to spawn a hoglin").defineInRange("hoglin_farm.spawn_time", 60, 60, 60);
/*  177 */     this
/*    0 */       
/*  179 */       .illusionerSpawnTime = builder.comment("The time in ticks the illusioner farm takes to spawn an illusioner").defineInRange("illusioner_farm.spawn_time", 60, 60, 60);
/*  181 */     this
/*    0 */       
/*  183 */       .magmaCubeSpawnTime = builder.comment("The time in ticks the magma cube farm takes to spawn a magma cube").defineInRange("magma_cube_farm.spawn_time", 60, 60, 60);
/*  185 */     this
/*    0 */       
/*  187 */       .phantomSpawnTime = builder.comment("The time in ticks the phantom farm takes to spawn a phantom").defineInRange("phantom_farm.spawn_time", 60, 60, 60);
/*  189 */     this
/*    0 */       
/*  191 */       .pillagerSpawnTime = builder.comment("The time in ticks the pillager farm takes to spawn a pillager").defineInRange("pillager_farm.spawn_time", 60, 60, 60);
/*  193 */     this
/*    0 */       
/*  195 */       .ravagerSpawnTime = builder.comment("The time in ticks the ravager farm takes to spawn a ravager").defineInRange("ravager_farm.spawn_time", 60, 60, 60);
/*  197 */     this
/*    0 */       
/*  199 */       .shulkerSpawnTime = builder.comment("The time in ticks the shulker farm takes to spawn a shulker").defineInRange("shulker_farm.spawn_time", 60, 60, 60);
/*  201 */     this
/*    0 */       
/*  203 */       .skeletonSpawnTime = builder.comment("The time in ticks the skeleton farm takes to spawn a skeleton").defineInRange("skeleton_farm.spawn_time", 60, 60, 60);
/*  205 */     this
/*    0 */       
/*  207 */       .slimeSpawnTime = builder.comment("The time in ticks the slime farm takes to spawn a slime").defineInRange("slime_farm.spawn_time", 60, 60, 60);
/*  209 */     this
/*    0 */       
/*  211 */       .vexSpawnTime = builder.comment("The time in ticks the vex farm takes to spawn a vex").defineInRange("vex_farm.spawn_time", 60, 60, 60);
/*  213 */     this
/*    0 */       
/*  215 */       .vindicatorSpawnTime = builder.comment("The time in ticks the vindicator farm takes to spawn a vindicator").defineInRange("vindicator_farm.spawn_time", 60, 60, 60);
/*  217 */     this
/*    0 */       
/*  219 */       .wardenSpawnTime = builder.comment("The time in ticks the warden farm takes to spawn a warden").defineInRange("warden_farm.spawn_time", 60, 60, 60);
/*  221 */     this
/*    0 */       
/*  223 */       .witchSpawnTime = builder.comment("The time in ticks the witch farm takes to spawn a witch").defineInRange("witch_farm.spawn_time", 60, 60, 60);
/*  225 */     this
/*    0 */       
/*  227 */       .witherSkeletonSpawnTime = builder.comment("The time in ticks the wither skeleton farm takes to spawn a wither skeleton").defineInRange("wither_skeleton_farm.spawn_time", 60, 60, 60);
/*  228 */     this
/*    0 */       
/*  230 */       .witherSpawnTime = builder.comment("The time in ticks the wither skeleton farm takes to spawn a wither skeleton").defineInRange("wither_skeleton_farm.spawn_time", 60, 60, 60);
/*  232 */     this
/*    0 */       
/*  234 */       .zoglinSpawnTime = builder.comment("The time in ticks the zoglin farm takes to spawn a zoglin").defineInRange("zoglin_farm.spawn_time", 60, 60, 60);
/*  236 */     this
/*    0 */       
/*  238 */       .zombieSpawnTime = builder.comment("The time in ticks the zombie farm takes to spawn a zombie").defineInRange("zombie_farm.spawn_time", 60, 60, 60);
/*  240 */     this
/*    0 */ 
/*    0 */ 
/*    0 */ 
/*    0 */       
/*  245 */       .universalReputation = builder.comment(new String[] { "If the villager reputation should be the same for every player", "This affects the prices of cured/converted villagers and the prices of the auto trader" }).define("villager.universal_reputation", true);
/*    0 */   }
/*    0 */ }
