package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.HorseFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.HorseFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class HorseFarmItemRenderer extends BlockItemRendererBase<HorseFarmRenderer, HorseFarmTileentity> {

    public HorseFarmItemRenderer() {
        super(HorseFarmRenderer::new, () -> new HorseFarmTileentity(BlockPos.ZERO, ModBlocks.HORSE_FARM.get().defaultBlockState()));
    }

}
