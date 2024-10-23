package com.awesomeshot5051.mobfarms.blocks.tileentity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.awesomeshot5051.mobfarms.blocks.tileentity.FakeWorldTileentity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.VillagerRenderer;

import java.lang.ref.WeakReference;

public class RendererBase<T extends FakeWorldTileentity> extends BlockRendererBase<T> {

    protected WeakReference<VillagerRenderer> villagerRendererCache = new WeakReference<>(null);

    public RendererBase(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(T tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(tileEntity, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
    }

    protected VillagerRenderer getVillagerRenderer() {
        VillagerRenderer villagerRenderer = villagerRendererCache.get();
        if (villagerRenderer == null) {
            villagerRenderer = new VillagerRenderer(createEntityRenderer());
            villagerRendererCache = new WeakReference<>(villagerRenderer);
        }
        return villagerRenderer;
    }

}
