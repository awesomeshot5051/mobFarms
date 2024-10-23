package com.awesomeshot5051.mobfarms.items.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ParrotFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.ParrotFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ParrotFarmItemRenderer extends BlockItemRendererBase<ParrotFarmRenderer, ParrotFarmTileentity> {
    public ParrotFarmItemRenderer() {
        super(ParrotFarmRenderer::new, () -> new ParrotFarmTileentity(BlockPos.ZERO, ModBlocks.PARROT_FARM.get().defaultBlockState()));
    }
}
