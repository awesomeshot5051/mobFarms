package com.awesomeshot5051.mobfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ZombieFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs.ZombieFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ZombieFarmItemRenderer extends BlockItemRendererBase<ZombieFarmRenderer, ZombieFarmTileentity> {

    public ZombieFarmItemRenderer() {
        super(ZombieFarmRenderer::new, () -> new ZombieFarmTileentity(BlockPos.ZERO, ModBlocks.ZOMBIE_FARM.get().defaultBlockState()));
    }

}
