package com.awesomeshot5051.mobfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.aggressiveMobs.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.boss.wither.*;

import java.lang.ref.*;

public class WitherFarmRenderer extends RendererBase<WitherFarmTileentity> {

    private WeakReference<WitherBoss> witherCache = new WeakReference<>(null);
    private WeakReference<WitherBossRenderer> witherRendererCache = new WeakReference<>(null);

    public WitherFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(WitherFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        WitherBoss wither = witherCache.get();
        if (wither == null) {
            wither = new WitherBoss(EntityType.WITHER, minecraft.level);
            witherCache = new WeakReference<>(wither);
        }

        WitherBossRenderer witherRenderer = witherRendererCache.get();
        if (witherRenderer == null) {
            witherRenderer = new WitherBossRenderer(createEntityRenderer());
            witherRendererCache = new WeakReference<>(witherRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= WitherFarmTileentity.getWitherSpawnTime(farm) && farm.getTimer() < WitherFarmTileentity.getWitherExplodeTime(farm)) {
            renderMob(matrixStack);
            // Adjust the scaling factor here
            matrixStack.scale(0.6F, 0.6F, 0.6F); // Change to 0.09F
            witherRenderer.render(wither, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}
