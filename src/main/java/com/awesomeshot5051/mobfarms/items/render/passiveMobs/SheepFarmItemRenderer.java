package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SheepFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.SheepFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SheepFarmItemRenderer extends BlockItemRendererBase<SheepFarmRenderer, SheepFarmTileentity> {

    public SheepFarmItemRenderer() {
        super(SheepFarmRenderer::new, () -> new SheepFarmTileentity(BlockPos.ZERO, ModBlocks.SHEEP_FARM.get().defaultBlockState()));
    }

}
