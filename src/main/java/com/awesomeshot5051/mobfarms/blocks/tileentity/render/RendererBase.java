package com.awesomeshot5051.mobfarms.blocks.tileentity.render;

import com.awesomeshot5051.mobfarms.blocks.tileentity.FakeWorldTileentity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.VillagerRenderState;
import net.minecraft.world.entity.npc.Villager;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

public class RendererBase<T extends FakeWorldTileentity> extends BlockRendererBase<T> {

    protected WeakReference<VillagerRenderer> villagerRendererCache = new WeakReference<>(null);

    @Nullable
    protected static VillagerRenderState villagerRenderState;

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

    protected static VillagerRenderState getVillagerRenderState(VillagerRenderer renderer, Villager villager) {
        if (villagerRenderState == null) {
            villagerRenderState = renderer.createRenderState();
        }
        renderer.extractRenderState(villager, villagerRenderState, 0F);
        return villagerRenderState;
    }

    public <S extends EntityRenderState, L extends MobRenderer<?, ?, ?>> S getRenderState(L render, S state) {
        if (state == null) {
            state = (S) render.createRenderState();
        }
        return state;
    }


}