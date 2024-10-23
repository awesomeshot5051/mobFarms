package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.IllusionerFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.IllusionerRenderer;
import net.minecraft.client.renderer.entity.state.IllusionerRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Illusioner;

import java.lang.ref.WeakReference;

public class IllusionerFarmRenderer extends RendererBase<IllusionerFarmTileentity> {

    private WeakReference<Illusioner> illusionerCache = new WeakReference<>(null);
    private WeakReference<IllusionerRenderer> illusionerRendererCache = new WeakReference<>(null);
    private IllusionerRenderState illusionerRenderState;
    public IllusionerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(IllusionerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Illusioner illusioner = illusionerCache.get();
        if (illusioner == null) {
            illusioner = new Illusioner(EntityType.ILLUSIONER, minecraft.level);
            illusionerCache = new WeakReference<>(illusioner);
        }

        IllusionerRenderer illusionerRenderer = illusionerRendererCache.get();
        if (illusionerRenderer == null) {
            illusionerRenderer = new IllusionerRenderer(createEntityRenderer());
            illusionerRendererCache = new WeakReference<>(illusionerRenderer);
        }
        illusionerRenderState = getRenderState(illusionerRenderer, illusionerRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= IllusionerFarmTileentity.getIllusionerSpawnTime() && farm.getTimer() < IllusionerFarmTileentity.getIllusionerExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            illusionerRenderer.render(illusionerRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
