package com.awesomeshot5051.mobfarms.blocks.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.BlockBase;
import com.awesomeshot5051.mobfarms.blocks.ModBlocks;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.SheepFarmTileentity;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerBlockEntityData;
import com.awesomeshot5051.mobfarms.gui.OutputContainer;
import de.maxhenkel.corelib.blockentity.SimpleBlockEntityTicker;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SheepFarmBlock extends BlockBase implements EntityBlock {
    public static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);

    public SheepFarmBlock(Properties properties) {
        super(properties.mapColor(MapColor.METAL).strength(2.5F).sound(SoundType.METAL).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(COLOR, DyeColor.WHITE)); // Default to white
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR); // Register the COLOR property
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, components, tooltipFlag);
        SheepFarmTileentity trader = VillagerBlockEntityData.getAndStoreBlockEntity(stack, context.registries(), context.level(), () -> new SheepFarmTileentity(BlockPos.ZERO, ModBlocks.SHEEP_FARM.get().defaultBlockState()));
    }

    @Override
    protected InteractionResult useItemOn(ItemStack heldItem, BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        if (!(tileEntity instanceof SheepFarmTileentity farm)) {
            return super.useItemOn(heldItem, state, worldIn, pos, player, handIn, hit);
        }

        // Check if the held item is dye
        DyeColor dyeColor = getDyeColor(heldItem);
        if (dyeColor != null) {
            // Update the block state with the new color
            dyeBlock(state, worldIn, dyeColor, pos);
            return InteractionResult.SUCCESS;
        }

        // Open GUI for the output container
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.translatable(state.getBlock().getDescriptionId());
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
                return new OutputContainer(id, playerInventory, farm.getOutputInventory(), ContainerLevelAccess.create(worldIn, pos), ModBlocks.SHEEP_FARM::get);
            }
        });

        return InteractionResult.SUCCESS;
    }

    public void dyeBlock(BlockState state, Level worldIn, DyeColor dyeColor, BlockPos pos) {
        BlockState newState = state.setValue(COLOR, dyeColor);
        worldIn.setBlock(pos, newState, 3); // Update the block state with the new color
    }

    private DyeColor getDyeColor(ItemStack stack) {
        if (stack.isEmpty()) {
            return null; // Return null if the stack is empty
        }

        // Compare using equals() method
        if (stack.getItem().equals(Items.WHITE_DYE)) {
            return DyeColor.WHITE;
        } else if (stack.getItem().equals(Items.ORANGE_DYE)) {
            return DyeColor.ORANGE;
        } else if (stack.getItem().equals(Items.MAGENTA_DYE)) {
            return DyeColor.MAGENTA;
        } else if (stack.getItem().equals(Items.LIGHT_BLUE_DYE)) {
            return DyeColor.LIGHT_BLUE;
        } else if (stack.getItem().equals(Items.YELLOW_DYE)) {
            return DyeColor.YELLOW;
        } else if (stack.getItem().equals(Items.LIME_DYE)) {
            return DyeColor.LIME;
        } else if (stack.getItem().equals(Items.PINK_DYE)) {
            return DyeColor.PINK;
        } else if (stack.getItem().equals(Items.GRAY_DYE)) {
            return DyeColor.GRAY;
        } else if (stack.getItem().equals(Items.LIGHT_GRAY_DYE)) {
            return DyeColor.LIGHT_GRAY;
        } else if (stack.getItem().equals(Items.CYAN_DYE)) {
            return DyeColor.CYAN;
        } else if (stack.getItem().equals(Items.PURPLE_DYE)) {
            return DyeColor.PURPLE;
        } else if (stack.getItem().equals(Items.BLUE_DYE)) {
            return DyeColor.BLUE;
        } else if (stack.getItem().equals(Items.BROWN_DYE)) {
            return DyeColor.BROWN;
        } else if (stack.getItem().equals(Items.GREEN_DYE)) {
            return DyeColor.GREEN;
        } else if (stack.getItem().equals(Items.RED_DYE)) {
            return DyeColor.RED;
        } else if (stack.getItem().equals(Items.BLACK_DYE)) {
            return DyeColor.BLACK;
        }

        return null; // Return null if no match found
    }


    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level1, BlockState state, BlockEntityType<T> type) {
        return new SimpleBlockEntityTicker<>();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SheepFarmTileentity(blockPos, blockState);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1F;
    }
}
