package com.awesomeshot5051.mobfarms.items.render.passiveMobs;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.GlowSquidFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.GlowSquidFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs.GlowSquidFarmRenderer;
import com.awesomeshot5051.mobfarms.items.render.BlockItemRendererBase;
import net.minecraft.client.renderer.entity.GlowSquidRenderer;
import net.minecraft.core.BlockPos;

public class GlowSquidFarmItemRenderer extends BlockItemRendererBase<GlowSquidFarmRenderer, GlowSquidFarmTileentity> {

    public GlowSquidFarmItemRenderer() {
        super(GlowSquidFarmRenderer::new, () -> new GlowSquidFarmTileentity(BlockPos.ZERO, ModBlocks.GLOW_SQUID_FARM.get().defaultBlockState()));
    }

}
