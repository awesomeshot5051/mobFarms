package com.awesomeshot5051.mobfarms.integration.theoneprobe;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import mcjty.theoneprobe.api.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TileInfoProvider implements IProbeInfoProvider {

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(Main.MODID, "probeinfoprovider");

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player playerEntity, Level world, BlockState blockState, IProbeHitData iProbeHitData) {
        BlockEntity te = world.getBlockEntity(iProbeHitData.getPos());

        if (te instanceof VillagerTileentity v) {
            addVillager(v.getVillagerEntity(), iProbeInfo);
        }
    }

    private void addVillager(EasyVillagerEntity villager, IProbeInfo iProbeInfo) {
        if (villager != null) {
            IProbeInfo info = iProbeInfo.horizontal(iProbeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
            info.entity(villager).text(villager.getAdvancedName());
        }
    }
}
