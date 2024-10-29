package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.HoglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.HoglinFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class HoglinFarmItemRenderer extends BlockItemRendererBase<HoglinFarmRenderer, HoglinFarmTileentity> {

    public HoglinFarmItemRenderer() {
        super(HoglinFarmRenderer::new, () -> new HoglinFarmTileentity(BlockPos.ZERO, ModBlocks.HOGLIN_FARM.get().defaultBlockState()));
    }

}
