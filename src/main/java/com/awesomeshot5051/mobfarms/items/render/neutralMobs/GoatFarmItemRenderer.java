package com.awesomeshot5051.mobfarms.items.render.neutralMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.neutralMobs.GoatFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.neutralMobs.GoatFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class GoatFarmItemRenderer extends BlockItemRendererBase<GoatFarmRenderer, GoatFarmTileentity> {

    public GoatFarmItemRenderer() {
        super(GoatFarmRenderer::new, () -> new GoatFarmTileentity(BlockPos.ZERO, ModBlocks.GOAT_FARM.get().defaultBlockState()));
    }

}
