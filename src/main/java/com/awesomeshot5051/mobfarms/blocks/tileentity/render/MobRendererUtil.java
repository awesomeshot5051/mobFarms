package com.awesomeshot5051.mobfarms.blocks.tileentity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.core.Direction;

public class MobRendererUtil {

    public static void renderMob(PoseStack matrixStack, Direction direction) {
        // Push the pose stack to ensure transformations are applied correctly
        matrixStack.pushPose();

        // Adjust the translation based on direction
        switch (direction) {
            case NORTH, WEST -> matrixStack.translate(.5D, 0D, .5D);
            case EAST -> matrixStack.translate(.5D, 0D, 0.5D);
            case SOUTH -> matrixStack.translate(0.5D, 0D, 0.5D);
        }

        matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        matrixStack.scale(0.4F, 0.4F, 0.4F);
    }
}

