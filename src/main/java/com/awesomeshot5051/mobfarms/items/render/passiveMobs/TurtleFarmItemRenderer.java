package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.TurtleFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.TurtleFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class TurtleFarmItemRenderer extends BlockItemRendererBase<TurtleFarmRenderer, TurtleFarmTileentity> {

    public TurtleFarmItemRenderer() {
        super(TurtleFarmRenderer::new, () -> new TurtleFarmTileentity(BlockPos.ZERO, ModBlocks.TURTLE_FARM.get().defaultBlockState()));
    }

}
