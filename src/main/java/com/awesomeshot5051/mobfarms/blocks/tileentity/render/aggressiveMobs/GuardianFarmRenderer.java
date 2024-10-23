package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.GuardianFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.GuardianRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Guardian;

import java.lang.ref.WeakReference;

public class GuardianFarmRenderer extends RendererBase<GuardianFarmTileentity> {

    private WeakReference<Guardian> guardianCache = new WeakReference<>(null);
    private WeakReference<GuardianRenderer> guardianRendererCache = new WeakReference<>(null);

    public GuardianFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(GuardianFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Guardian guardian = guardianCache.get();
        if (guardian == null) {
            guardian = new Guardian(EntityType.GUARDIAN, minecraft.level);
            guardianCache = new WeakReference<>(guardian);
        }

        GuardianRenderer guardianRenderer = guardianRendererCache.get();
        if (guardianRenderer == null) {
            guardianRenderer = new GuardianRenderer(createEntityRenderer());
            guardianRendererCache = new WeakReference<>(guardianRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= GuardianFarmTileentity.getGuardianSpawnTime() && farm.getTimer() < GuardianFarmTileentity.getGuardianExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            guardianRenderer.render(guardian, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
