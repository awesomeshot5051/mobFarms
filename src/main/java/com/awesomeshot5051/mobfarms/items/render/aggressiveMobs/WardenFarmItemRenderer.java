package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.WardenFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.WardenFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class WardenFarmItemRenderer extends BlockItemRendererBase<WardenFarmRenderer, WardenFarmTileentity> {

    public WardenFarmItemRenderer() {
        super(WardenFarmRenderer::new, () -> new WardenFarmTileentity(BlockPos.ZERO, ModBlocks.WARDEN_FARM.get().defaultBlockState()));
    }

}
