package com.awesomeshot5051.mobfarms.items.render;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.EmptyFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.EmptyFarmRenderer;
import net.minecraft.core.BlockPos;

public class EmptyFarmItemRenderer extends BlockItemRendererBase<EmptyFarmRenderer, EmptyFarmTileentity> {

    public EmptyFarmItemRenderer() {
        super(EmptyFarmRenderer::new, () -> new EmptyFarmTileentity(BlockPos.ZERO, ModBlocks.EMPTY_FARM.get().defaultBlockState()));
    }

}
