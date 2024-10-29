/*    0 */ package com.awesomeshot5051.mobfarms.entity;
/*    0 */ 
/*    0 */ import com.awesomeshot5051.mobfarms.Main;
/*    0 */ import java.util.UUID;
/*    0 */ import net.minecraft.ChatFormatting;
/*    0 */ import net.minecraft.network.chat.Component;
/*    0 */ import net.minecraft.util.Mth;
/*    0 */ import net.minecraft.world.entity.EntityType;
/*    0 */ import net.minecraft.world.entity.ai.gossip.GossipType;
/*    0 */ import net.minecraft.world.entity.npc.Villager;
/*    0 */ import net.minecraft.world.entity.npc.VillagerData;
/*    0 */ import net.minecraft.world.entity.npc.VillagerProfession;
/*    0 */ import net.minecraft.world.entity.npc.VillagerType;
/*    0 */ import net.minecraft.world.entity.player.Player;
/*    0 */ import net.minecraft.world.item.trading.MerchantOffer;
/*    0 */ import net.minecraft.world.level.Level;
/*    0 */ 
/*    0 */ public class EasyVillagerEntity extends Villager {
/*    0 */   public long lastRestockGameTime;
/*    0 */   
/*    0 */   public boolean increaseProfessionLevelOnUpdate;
/*    0 */   
/*    0 */   public EasyVillagerEntity(EntityType<? extends Villager> type, Level worldIn) {
/*   23 */     super(type, worldIn);
/*    0 */   }
/*    0 */   
/*    0 */   public EasyVillagerEntity(EntityType<? extends Villager> type, Level worldIn, VillagerType villagerType) {
/*   27 */     super(type, worldIn, villagerType);
/*    0 */   }
/*    0 */   
/*    0 */   public int getPlayerReputation(Player player) {
/*   32 */     if (((Boolean)Main.SERVER_CONFIG.universalReputation.get()).booleanValue())
/*   33 */       return getUniversalReputation(this); 
/*   35 */     return super.getPlayerReputation(player);
/*    0 */   }
/*    0 */   
/*    0 */   public static int getReputation(Villager villager) {
/*   40 */     if (((Boolean)Main.SERVER_CONFIG.universalReputation.get()).booleanValue())
/*   41 */       return getUniversalReputation(villager); 
/*   43 */     return 0;
/*    0 */   }
/*    0 */   
/*    0 */   public static int getUniversalReputation(Villager villager) {
/*   48 */     return ((Integer)villager.getGossips().getGossipEntries().keySet().stream().map(uuid -> Integer.valueOf(villager.getGossips().getReputation(uuid, EasyVillagerEntity::isPositive))).reduce(Integer.valueOf(0), Integer::sum)).intValue();
/*    0 */   }
/*    0 */   
/*    0 */   public static boolean isPositive(GossipType gossipType) {
/*   52 */     switch (gossipType) {
/*    0 */       case MAJOR_NEGATIVE:
/*    0 */       case MINOR_NEGATIVE:
/*    0 */       
/*    0 */     } 
/*   52 */     return true;
/*    0 */   }
/*    0 */   
/*    0 */   public void recalculateOffers() {
/*   59 */     resetOffers(this);
/*   60 */     calculateOffers(this);
/*    0 */   }
/*    0 */   
/*    0 */   public int getAge() {
/*   65 */     if (level() != null && (level()).isClientSide)
/*   66 */       return (super.getAge() < 0) ? -24000 : 1; 
/*   68 */     return this.age;
/*    0 */   }
/*    0 */   
/*    0 */   public static void recalculateOffers(Villager villager) {
/*   73 */     resetOffers(villager);
/*   74 */     calculateOffers(villager);
/*    0 */   }
/*    0 */   
/*    0 */   private static void resetOffers(Villager villager) {
/*   78 */     for (MerchantOffer merchantoffer : villager.getOffers())
/*   79 */       merchantoffer.resetSpecialPriceDiff(); 
/*    0 */   }
/*    0 */   
/*    0 */   private static void calculateOffers(Villager villager) {
/*   84 */     int i = getReputation(villager);
/*   85 */     if (i != 0)
/*   86 */       for (MerchantOffer merchantoffer : villager.getOffers())
/*   87 */         merchantoffer.addToSpecialPriceDiff(-Mth.floor(i * merchantoffer.getPriceMultiplier()));  
/*    0 */   }
/*    0 */   
/*    0 */   public Component getName() {
/*   94 */     if (hasCustomName())
/*   95 */       return super.getName(); 
/*   97 */     VillagerData villagerData = getVillagerData();
/*   98 */     VillagerProfession profession = villagerData.getProfession();
/*   99 */     if (profession.equals(VillagerProfession.NONE))
/*  100 */       return (Component)EntityType.VILLAGER.getDescription().copy(); 
/*  102 */     return getTypeName();
/*    0 */   }
/*    0 */   
/*    0 */   public Component getAdvancedName() {
/*  107 */     return (Component)Component.translatable("tooltip.mob_farms.villager_profession", new Object[] { getName().copy(), Component.translatable("merchant.level." + getVillagerData().getLevel()) }).withStyle(ChatFormatting.GRAY);
/*    0 */   }
/*    0 */   
/*    0 */   public void increaseMerchantCareer() {
/*  111 */     setVillagerData(getVillagerData().setLevel(getVillagerData().getLevel() + 1));
/*  112 */     updateTrades();
/*    0 */   }
/*    0 */   
/*    0 */   public boolean shouldIncreaseLevel() {
/*  116 */     int i = getVillagerData().getLevel();
/*  117 */     return (VillagerData.canLevelUp(i) && getVillagerXp() >= VillagerData.getMaxXpPerLevel(i));
/*    0 */   }
/*    0 */ }
