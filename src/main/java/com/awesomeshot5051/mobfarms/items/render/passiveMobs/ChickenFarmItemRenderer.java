package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.ChickenFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PigFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.ChickenFarmRenderer;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.PigFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ChickenFarmItemRenderer extends BlockItemRendererBase<ChickenFarmRenderer, ChickenFarmTileentity> {

    public ChickenFarmItemRenderer() {
        super(ChickenFarmRenderer::new, () -> new ChickenFarmTileentity(BlockPos.ZERO, ModBlocks.CHICKEN_FARM.get().defaultBlockState()));
    }

}
