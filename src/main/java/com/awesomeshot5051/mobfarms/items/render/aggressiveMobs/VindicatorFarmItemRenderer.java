package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.VindicatorFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.VindicatorFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class VindicatorFarmItemRenderer extends BlockItemRendererBase<VindicatorFarmRenderer, VindicatorFarmTileentity> {

    public VindicatorFarmItemRenderer() {
        super(VindicatorFarmRenderer::new, () -> new VindicatorFarmTileentity(BlockPos.ZERO, ModBlocks.VINDICATOR_FARM.get().defaultBlockState()));
    }

}
