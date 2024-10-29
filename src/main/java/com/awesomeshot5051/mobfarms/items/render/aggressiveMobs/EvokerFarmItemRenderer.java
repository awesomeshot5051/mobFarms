package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.EvokerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.EvokerFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class EvokerFarmItemRenderer extends BlockItemRendererBase<EvokerFarmRenderer, EvokerFarmTileentity> {

    public EvokerFarmItemRenderer() {
        super(EvokerFarmRenderer::new, () -> new EvokerFarmTileentity(BlockPos.ZERO, ModBlocks.EVOKER_FARM.get().defaultBlockState()));
    }

}
