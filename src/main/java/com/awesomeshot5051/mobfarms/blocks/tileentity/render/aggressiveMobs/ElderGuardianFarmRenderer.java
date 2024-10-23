package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.ElderGuardianFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ElderGuardianRenderer;
import net.minecraft.client.renderer.entity.state.GuardianRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.ElderGuardian;

import java.lang.ref.WeakReference;

public class ElderGuardianFarmRenderer extends RendererBase<ElderGuardianFarmTileentity> {

    private WeakReference<ElderGuardian> elderGuardianCache = new WeakReference<>(null);
    private WeakReference<ElderGuardianRenderer> elderGuardianRendererCache = new WeakReference<>(null);
    private GuardianRenderState elderGuardianRenderState;

    public ElderGuardianFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(ElderGuardianFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        ElderGuardian elderGuardian = elderGuardianCache.get();
        if (elderGuardian == null) {
            elderGuardian = new ElderGuardian(EntityType.ELDER_GUARDIAN, minecraft.level);
            elderGuardianCache = new WeakReference<>(elderGuardian);
        }

        ElderGuardianRenderer elderGuardianRenderer = elderGuardianRendererCache.get();
        if (elderGuardianRenderer == null) {
            elderGuardianRenderer = new ElderGuardianRenderer(createEntityRenderer());
            elderGuardianRendererCache = new WeakReference<>(elderGuardianRenderer);
        }
        elderGuardianRenderState = getRenderState(elderGuardianRenderer, elderGuardianRenderState);
        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ElderGuardianFarmTileentity.getElderGuardianSpawnTime() && farm.getTimer() < ElderGuardianFarmTileentity.getElderGuardianExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            elderGuardianRenderer.render(elderGuardianRenderState, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
