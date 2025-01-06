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

public class ElderGuardianFarmRenderer extends RendererBase<ElderGuardianFarmTileentity> {

    private WeakReference<ElderGuardian> elderGuardianCache = new WeakReference<>(null);
    private WeakReference<ElderGuardianRenderer> elderGuardianRendererCache = new WeakReference<>(null);

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

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= ElderGuardianFarmTileentity.getElderGuardianSpawnTime(farm) && farm.getTimer() < ElderGuardianFarmTileentity.getElderGuardianExplodeTime(farm)) {
            renderMob(matrixStack);
            matrixStack.scale(.5f, .5f, .5f);
            elderGuardianRenderer.render(elderGuardian, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
