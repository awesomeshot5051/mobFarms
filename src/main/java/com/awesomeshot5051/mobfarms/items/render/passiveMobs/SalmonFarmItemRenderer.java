package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SalmonFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SalmonFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SalmonFarmItemRenderer extends BlockItemRendererBase<SalmonFarmRenderer, SalmonFarmTileentity> {

    public SalmonFarmItemRenderer() {
        super(SalmonFarmRenderer::new, () -> new SalmonFarmTileentity(BlockPos.ZERO, ModBlocks.SALMON_FARM.get().defaultBlockState()));
    }

}
