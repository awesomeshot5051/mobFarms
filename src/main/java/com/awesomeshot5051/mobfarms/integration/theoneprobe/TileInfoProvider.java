/*   0 */ package com.awesomeshot5051.mobfarms.integration.theoneprobe;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
/*   0 */ import mcjty.theoneprobe.api.ElementAlignment;
/*   0 */ import mcjty.theoneprobe.api.IProbeHitData;
/*   0 */ import mcjty.theoneprobe.api.IProbeInfo;
/*   0 */ import mcjty.theoneprobe.api.IProbeInfoProvider;
/*   0 */ import mcjty.theoneprobe.api.ProbeMode;
/*   0 */ import net.minecraft.resources.ResourceLocation;
/*   0 */ import net.minecraft.world.entity.Entity;
/*   0 */ import net.minecraft.world.entity.player.Player;
/*   0 */ import net.minecraft.world.level.Level;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntity;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ 
/*   0 */ public class TileInfoProvider implements IProbeInfoProvider {
/*  15 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("mob_farms", "probeinfoprovider");
/*   0 */   
/*   0 */   public ResourceLocation getID() {
/*  19 */     return ID;
/*   0 */   }
/*   0 */   
/*   0 */   public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player playerEntity, Level world, BlockState blockState, IProbeHitData iProbeHitData) {
/*  24 */     BlockEntity te = world.getBlockEntity(iProbeHitData.getPos());
/*  26 */     if (te instanceof VillagerTileentity) {
/*  26 */       VillagerTileentity v = (VillagerTileentity)te;
/*  27 */       addVillager(v.getVillagerEntity(), iProbeInfo);
/*   0 */     } 
/*   0 */   }
/*   0 */   
/*   0 */   private void addVillager(EasyVillagerEntity villager, IProbeInfo iProbeInfo) {
/*  32 */     if (villager != null) {
/*  33 */       IProbeInfo info = iProbeInfo.horizontal(iProbeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
/*  34 */       info.entity((Entity)villager).text(villager.getAdvancedName());
/*   0 */     } 
/*   0 */   }
/*   0 */ }
