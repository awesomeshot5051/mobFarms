/*   0 */ package com.awesomeshot5051.mobfarms.events;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.Main;
/*   0 */ import net.minecraft.sounds.SoundEvent;
/*   0 */ import net.minecraft.sounds.SoundEvents;
/*   0 */ import net.minecraft.sounds.SoundSource;
/*   0 */ import net.neoforged.bus.api.SubscribeEvent;
/*   0 */ import net.neoforged.neoforge.event.PlayLevelSoundEvent;
/*   0 */ 
/*   0 */ public class ModSoundEvents {
/*   0 */   @SubscribeEvent
/*   0 */   public void onSound(PlayLevelSoundEvent.AtEntity event) {
/*  14 */     if (event.getSound() != null && event.getSource() != null && isVillagerSound((SoundEvent)event.getSound().value()) && event.getSource().equals(SoundSource.BLOCKS))
/*  15 */       event.setNewVolume(((Double)Main.CLIENT_CONFIG.villagerVolume.get()).floatValue()); 
/*   0 */   }
/*   0 */   
/*   0 */   @SubscribeEvent
/*   0 */   public void onSound(PlayLevelSoundEvent.AtPosition event) {
/*  21 */     if (event.getSound() != null && event.getSound().value() != null && event.getSource() != null && isVillagerSound((SoundEvent)event.getSound().value()) && event.getSource().equals(SoundSource.BLOCKS))
/*  22 */       event.setNewVolume(((Double)Main.CLIENT_CONFIG.villagerVolume.get()).floatValue()); 
/*   0 */   }
/*   0 */   
/*   0 */   private boolean isVillagerSound(SoundEvent event) {
/*  27 */     return (event.equals(SoundEvents.VILLAGER_NO) || event
/*  28 */       .equals(SoundEvents.VILLAGER_CELEBRATE) || event
/*  29 */       .equals(SoundEvents.VILLAGER_DEATH) || event
/*  30 */       .equals(SoundEvents.VILLAGER_AMBIENT) || event
/*  31 */       .equals(SoundEvents.VILLAGER_HURT) || event
/*  32 */       .equals(SoundEvents.VILLAGER_TRADE) || event
/*  33 */       .equals(SoundEvents.VILLAGER_WORK_ARMORER) || event
/*  34 */       .equals(SoundEvents.VILLAGER_WORK_BUTCHER) || event
/*  35 */       .equals(SoundEvents.VILLAGER_WORK_CARTOGRAPHER) || event
/*  36 */       .equals(SoundEvents.VILLAGER_WORK_CLERIC) || event
/*  37 */       .equals(SoundEvents.VILLAGER_WORK_FARMER) || event
/*  38 */       .equals(SoundEvents.VILLAGER_WORK_FISHERMAN) || event
/*  39 */       .equals(SoundEvents.VILLAGER_WORK_FLETCHER) || event
/*  40 */       .equals(SoundEvents.VILLAGER_WORK_LEATHERWORKER) || event
/*  41 */       .equals(SoundEvents.VILLAGER_WORK_LIBRARIAN) || event
/*  42 */       .equals(SoundEvents.VILLAGER_WORK_MASON) || event
/*  43 */       .equals(SoundEvents.VILLAGER_WORK_SHEPHERD) || event
/*  44 */       .equals(SoundEvents.VILLAGER_WORK_TOOLSMITH) || event
/*  45 */       .equals(SoundEvents.VILLAGER_WORK_WEAPONSMITH) || event
/*  46 */       .equals(SoundEvents.VILLAGER_YES) || event
/*  47 */       .equals(SoundEvents.IRON_GOLEM_HURT) || event
/*  48 */       .equals(SoundEvents.IRON_GOLEM_DEATH) || event
/*  49 */       .equals(SoundEvents.ZOMBIE_AMBIENT) || event
/*  50 */       .equals(SoundEvents.ZOMBIE_INFECT) || event
/*  51 */       .equals(SoundEvents.ZOMBIE_VILLAGER_AMBIENT) || event
/*  52 */       .equals(SoundEvents.ZOMBIE_VILLAGER_CONVERTED) || event
/*  53 */       .equals(SoundEvents.ZOMBIE_VILLAGER_CURE));
/*   0 */   }
/*   0 */ }
