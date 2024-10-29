package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SquidFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SquidFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SquidFarmItemRenderer extends BlockItemRendererBase<SquidFarmRenderer, SquidFarmTileentity> {

    public SquidFarmItemRenderer() {
        super(SquidFarmRenderer::new, () -> new SquidFarmTileentity(BlockPos.ZERO, ModBlocks.SQUID_FARM.get().defaultBlockState()));
    }

}
