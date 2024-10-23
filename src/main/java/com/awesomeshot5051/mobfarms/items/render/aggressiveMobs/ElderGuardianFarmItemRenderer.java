package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ElderGuardianFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ElderGuardianFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ElderGuardianFarmItemRenderer extends BlockItemRendererBase<ElderGuardianFarmRenderer, ElderGuardianFarmTileentity> {

    public ElderGuardianFarmItemRenderer() {
        super(ElderGuardianFarmRenderer::new, () -> new ElderGuardianFarmTileentity(BlockPos.ZERO, ModBlocks.ELDER_GUARDIAN_FARM.get().defaultBlockState()));
    }

}
