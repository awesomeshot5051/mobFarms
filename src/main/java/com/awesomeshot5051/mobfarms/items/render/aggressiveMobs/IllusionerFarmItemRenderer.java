package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.IllusionerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.IllusionerFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class IllusionerFarmItemRenderer extends BlockItemRendererBase<IllusionerFarmRenderer, IllusionerFarmTileentity> {

    public IllusionerFarmItemRenderer() {
        super(IllusionerFarmRenderer::new, () -> new IllusionerFarmTileentity(BlockPos.ZERO, ModBlocks.ILLUSIONER_FARM.get().defaultBlockState()));
    }

}
