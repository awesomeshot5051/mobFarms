package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.items.render.*;
import net.minecraft.core.*;

public class WitherFarmItemRenderer extends BlockItemRendererBase<WitherFarmRenderer, WitherFarmTileentity> {
    public WitherFarmItemRenderer() {
        /*  12 */
        super(WitherFarmRenderer::new, () -> new WitherFarmTileentity(BlockPos.ZERO, ModBlocks.WITHER_FARM.get().defaultBlockState()));
    }
}
