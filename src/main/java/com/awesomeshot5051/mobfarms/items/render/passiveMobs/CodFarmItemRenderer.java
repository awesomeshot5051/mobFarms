package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.CodFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.CodFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class CodFarmItemRenderer extends BlockItemRendererBase<CodFarmRenderer, CodFarmTileentity> {

    public CodFarmItemRenderer() {
        super(CodFarmRenderer::new, () -> new CodFarmTileentity(BlockPos.ZERO, ModBlocks.COD_FARM.get().defaultBlockState()));
    }

}