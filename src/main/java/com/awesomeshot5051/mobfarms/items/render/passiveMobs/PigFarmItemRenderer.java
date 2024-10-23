package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PigFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class PigFarmItemRenderer extends BlockItemRendererBase<PigFarmRenderer, PigFarmTileentity> {

    public PigFarmItemRenderer() {
        super(PigFarmRenderer::new, () -> new PigFarmTileentity(BlockPos.ZERO, ModBlocks.PIG_FARM.get().defaultBlockState()));
    }

}
