package com.awesomeshot5051.mobfarms.integration.waila;

import com.awesomeshot5051.mobfarms.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.*;
import net.minecraft.*;
import net.minecraft.core.component.*;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.level.block.entity.*;
import org.jetbrains.annotations.*;
import snownee.jade.api.*;
import snownee.jade.api.config.*;
import snownee.jade.api.ui.*;
import snownee.jade.impl.ui.*;

import java.util.*;
import java.util.stream.*;

public class HUDHandlerVillager implements IBlockComponentProvider {

    public static final HUDHandlerVillager INSTANCE = new HUDHandlerVillager();

    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Main.MODID, "villager");

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof VillagerTileentity blockEntity) {
            ItemStack swordType = blockEntity.getSwordType();
            if (swordType != ItemStack.EMPTY) {
                iTooltip.add(Component.translatable(convertToReadableName(swordType.getDescriptionId())).withStyle(ChatFormatting.RED));
            }
        }
    }

    private String convertToReadableName(String block) {
        // Remove "item.minecraft." and replace underscores with spaces
        String readableName = block.replace("item.minecraft.", "").replace('_', ' ');
        // Capitalize the first letter of each word
        return Arrays.stream(readableName.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    @Override
    public @Nullable IElement getIcon(BlockAccessor accessor, IPluginConfig config, IElement currentIcon) {
        BlockEntity te = accessor.getBlockEntity();
        ItemStack stack = new ItemStack(te.getBlockState().getBlock().asItem());
        if (te.getLevel() != null) {
            CompoundTag blockEntityTag = te.saveWithoutMetadata(te.getLevel().registryAccess());
            stack.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(blockEntityTag));
        }
        return ItemStackElement.of(stack);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

}