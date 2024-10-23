package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ShulkerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ShulkerFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ShulkerFarmItemRenderer extends BlockItemRendererBase<ShulkerFarmRenderer, ShulkerFarmTileentity> {

    public ShulkerFarmItemRenderer() {
        super(ShulkerFarmRenderer::new, () -> new ShulkerFarmTileentity(BlockPos.ZERO, ModBlocks.SHULKER_FARM.get().defaultBlockState()));
    }

}
