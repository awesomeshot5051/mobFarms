package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZoglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZoglinFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ZoglinFarmItemRenderer extends BlockItemRendererBase<ZoglinFarmRenderer, ZoglinFarmTileentity> {

    public ZoglinFarmItemRenderer() {
        super(ZoglinFarmRenderer::new, () -> new ZoglinFarmTileentity(BlockPos.ZERO, ModBlocks.ZOGLIN_FARM.get().defaultBlockState()));
    }

}
