package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;

import java.lang.ref.*;

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

        if (farm.getTimer() >= GuardianFarmTileentity.getGuardianSpawnTime(farm) && farm.getTimer() < GuardianFarmTileentity.getGuardianExplodeTime(farm)) {
            renderMob(matrixStack);
            guardianRenderer.render(guardian, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
