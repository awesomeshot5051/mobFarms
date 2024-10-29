package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.CreeperFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.CreeperFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class CreeperFarmItemRenderer extends BlockItemRendererBase<CreeperFarmRenderer, CreeperFarmTileentity> {

    public CreeperFarmItemRenderer() {
        super(CreeperFarmRenderer::new, () -> new CreeperFarmTileentity(BlockPos.ZERO, ModBlocks.CREEPER_FARM.get().defaultBlockState()));
    }

}
