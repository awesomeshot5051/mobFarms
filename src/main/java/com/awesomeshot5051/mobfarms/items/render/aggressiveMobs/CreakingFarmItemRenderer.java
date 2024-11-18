package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.CreakingFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.CreakingFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class CreakingFarmItemRenderer extends BlockItemRendererBase<CreakingFarmRenderer, CreakingFarmTileentity> {

    public CreakingFarmItemRenderer() {
        super(CreakingFarmRenderer::new, () -> new CreakingFarmTileentity(BlockPos.ZERO, ModBlocks.CREAKING_FARM.get().defaultBlockState()));
    }

}
