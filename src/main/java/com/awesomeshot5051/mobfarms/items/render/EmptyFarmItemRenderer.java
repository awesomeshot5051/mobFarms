package com.awesomeshot5051.mobfarms.items.render;

import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import net.minecraft.core.*;

public class EmptyFarmItemRenderer extends BlockItemRendererBase<EmptyFarmRenderer, EmptyFarmTileentity> {

    public EmptyFarmItemRenderer() {
        super(EmptyFarmRenderer::new, () -> new EmptyFarmTileentity(BlockPos.ZERO, ModBlocks.EMPTY_FARM.get().defaultBlockState()));
    }

}
