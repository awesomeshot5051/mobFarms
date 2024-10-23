package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.RabbitFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.RabbitFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class RabbitFarmItemRenderer extends BlockItemRendererBase<RabbitFarmRenderer, RabbitFarmTileentity> {
    public RabbitFarmItemRenderer() {
        super(RabbitFarmRenderer::new, () -> new RabbitFarmTileentity(BlockPos.ZERO, ModBlocks.RABBIT_FARM.get().defaultBlockState()));
    }
}
