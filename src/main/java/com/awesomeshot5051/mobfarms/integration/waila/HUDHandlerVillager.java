package com.awesomeshot5051.mobfarms.integration.waila;

import com.awesomeshot5051.mobfarms.Main;
import com.awesomeshot5051.mobfarms.blocks.tileentity.VillagerTileentity;
import com.awesomeshot5051.mobfarms.entity.EasyVillagerEntity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.impl.ui.ItemStackElement;

public class HUDHandlerVillager implements IBlockComponentProvider {

    public static final HUDHandlerVillager INSTANCE = new HUDHandlerVillager();

    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Main.MODID, "villager");

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof VillagerTileentity blockEntity) {
            EasyVillagerEntity villager = blockEntity.getVillagerEntity();
            if (villager != null) {
                iTooltip.add(villager.getAdvancedName());
            }
        }
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