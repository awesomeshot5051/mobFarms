package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GhastFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.GhastFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class GhastFarmItemRenderer extends BlockItemRendererBase<GhastFarmRenderer, GhastFarmTileentity> {

    public GhastFarmItemRenderer() {
        super(GhastFarmRenderer::new, () -> new GhastFarmTileentity(BlockPos.ZERO, ModBlocks.GHAST_FARM.get().defaultBlockState()));
    }

}
