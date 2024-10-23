package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.DrownedFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.DrownedFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class DrownedFarmItemRenderer extends BlockItemRendererBase<DrownedFarmRenderer, DrownedFarmTileentity> {

    public DrownedFarmItemRenderer() {
        super(DrownedFarmRenderer::new, () -> new DrownedFarmTileentity(BlockPos.ZERO, ModBlocks.DROWNED_FARM.get().defaultBlockState()));
    }

}
