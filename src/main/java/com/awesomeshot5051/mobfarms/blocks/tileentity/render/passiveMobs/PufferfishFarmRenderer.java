package com.awesomeshot5051.mobfarms.blocks.tileentity.render.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.PufferfishFarmTileentity;
import com.awesomeshot5051.mobfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.PufferfishRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pufferfish;

import java.lang.ref.WeakReference;

public class PufferfishFarmRenderer extends RendererBase<PufferfishFarmTileentity> {  
  
  private WeakReference<Pufferfish> pufferfishCache = new WeakReference<>(null);  
  private WeakReference<PufferfishRenderer> pufferfishRendererCache = new WeakReference<>(null);  
  
  public PufferfishFarmRenderer(BlockEntityRendererProvider.Context renderer) {  
    super(renderer);  
  }  
  
  @Override  
  public void render(PufferfishFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {  
    super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);  
    matrixStack.pushPose();  
  
    Pufferfish pufferfish = pufferfishCache.get();  
    if (pufferfish == null) {  
    pufferfish = new Pufferfish(EntityType.PUFFERFISH, minecraft.level);  
    pufferfishCache = new WeakReference<>(pufferfish);  
    }  
  
    PufferfishRenderer pufferfishRenderer = pufferfishRendererCache.get();  
    if (pufferfishRenderer == null) {  
    pufferfishRenderer = new PufferfishRenderer(createEntityRenderer());  
    pufferfishRendererCache = new WeakReference<>(pufferfishRenderer);  
    }  
  
    Direction direction = Direction.SOUTH;  
  
    if (farm.getTimer() >= PufferfishFarmTileentity.getPufferfishSpawnTime() && farm.getTimer() < PufferfishFarmTileentity.getPufferfishKillTime()) {  
    matrixStack.pushPose();  
    matrixStack.translate(0.5D, 1D / 16D, 0.5D);  
    matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));  
    matrixStack.translate(0D, 0D, 3D / 16D);  
    matrixStack.scale(0.3F, 0.3F, 0.3F);  
    pufferfishRenderer.render(pufferfish, 0F, 1F, matrixStack, buffer, combinedLight);  
    matrixStack.popPose();  
    }  
  
    matrixStack.popPose();  
  }
}
