package com.awesomeshot5051.mobfarms.integration.theoneprobe;

import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TileInfoProvider implements IProbeInfoProvider {
   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("mob_farms", "probeinfoprovider");
   
   public ResourceLocation getID() {
/*  19 */     return ID;
   }
   
   public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player playerEntity, Level world, BlockState blockState, IProbeHitData iProbeHitData) {
/*  24 */     BlockEntity te = world.getBlockEntity(iProbeHitData.getPos());
/*  26 */     if (te instanceof VillagerTileentity) {
/*  26 */       VillagerTileentity v = (VillagerTileentity)te;
/*  27 */       addVillager(v.getVillagerEntity(), iProbeInfo);
     } 
   }
   
   private void addVillager(EasyVillagerEntity villager, IProbeInfo iProbeInfo) {
/*  32 */     if (villager != null) {
/*  33 */       IProbeInfo info = iProbeInfo.horizontal(iProbeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
/*  34 */       info.entity((Entity)villager).text(villager.getAdvancedName());
     } 
   }
}
