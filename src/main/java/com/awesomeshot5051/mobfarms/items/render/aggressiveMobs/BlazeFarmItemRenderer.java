package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.BlazeFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.BlazeFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class BlazeFarmItemRenderer extends BlockItemRendererBase<BlazeFarmRenderer, BlazeFarmTileentity> {

    public BlazeFarmItemRenderer() {
        super(BlazeFarmRenderer::new, () -> new BlazeFarmTileentity(BlockPos.ZERO, ModBlocks.BLAZE_FARM.get().defaultBlockState()));
    }

}
