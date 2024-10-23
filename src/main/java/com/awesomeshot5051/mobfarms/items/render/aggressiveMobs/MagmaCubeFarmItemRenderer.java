package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.MagmaCubeFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.MagmaCubeFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class MagmaCubeFarmItemRenderer extends BlockItemRendererBase<MagmaCubeFarmRenderer, MagmaCubeFarmTileentity> {

    public MagmaCubeFarmItemRenderer() {
        super(MagmaCubeFarmRenderer::new, () -> new MagmaCubeFarmTileentity(BlockPos.ZERO, ModBlocks.MAGMA_CUBE_FARM.get().defaultBlockState()));
    }

}
