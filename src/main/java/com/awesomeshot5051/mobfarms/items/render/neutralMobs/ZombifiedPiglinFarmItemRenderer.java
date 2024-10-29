package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;

import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.ZombifiedPiglinFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.ZombifiedPiglinFarmRenderer;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PigFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ZombifiedPiglinFarmItemRenderer extends BlockItemRendererBase<ZombifiedPiglinFarmRenderer, ZombifiedPiglinFarmTileentity> {

    public ZombifiedPiglinFarmItemRenderer() {
        super(ZombifiedPiglinFarmRenderer::new, () -> new ZombifiedPiglinFarmTileentity(BlockPos.ZERO, ModBlocks.ZOMBIFIED_PIGLIN_FARM.get().defaultBlockState()));
    }

}
