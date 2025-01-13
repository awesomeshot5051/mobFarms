package com.awesomeshot5051.mobfarms.blocks.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.awesomeshot5051.mobfarms.gui.*;
import com.awesomeshot5051.mobfarms.items.render.passiveMobs.*;
import de.maxhenkel.corelib.block.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.client.*;
import net.minecraft.core.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;
import net.neoforged.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

import static net.minecraft.world.item.BlockItem.*;

public class SheepFarmBlock extends BlockBase implements EntityBlock, IItemBlock {
    public static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);

    public SheepFarmBlock() {
        super(Properties.of().mapColor(MapColor.METAL).strength(2.5F).sound(SoundType.METAL).noOcclusion());
        this.registerDefaultState(this.defaultBlockState().setValue(COLOR, DyeColor.WHITE)); // Default to white
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR); // Register the COLOR property
    }


    @Override
    public Item toItem() {
        return new CustomRendererBlockItem(this, new Item.Properties()) {
            @OnlyIn(Dist.CLIENT)
            @Override
            public ItemRenderer createItemRenderer() {
                return new SheepFarmItemRenderer();
            }
        };
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, components, tooltipFlag);
        if (Screen.hasShiftDown()) {
            if (stack.has(ModDataComponents.SWORD_TYPE)) {
                ItemStack axeType = ItemContainerContents.fromItems(Collections.singletonList(Objects.requireNonNull(stack.get(ModDataComponents.SWORD_TYPE)).getStackInSlot(0))).copyOne();
                components.add(Component.literal("This farm has a " + convertToReadableName(axeType.getItem().getDefaultInstance().getDescriptionId()) + " on it.")
                        .withStyle(ChatFormatting.RED));
            }
        } else {
            components.add(Component.literal("Hold §4Shift§r to see tool").withStyle(ChatFormatting.YELLOW));
        }
        SheepFarmTileentity trader = VillagerBlockEntityData.getAndStoreBlockEntity(stack, context.registries(), context.level(), () -> new SheepFarmTileentity(BlockPos.ZERO, ModBlocks.SHEEP_FARM.get().defaultBlockState()));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        if (!(tileEntity instanceof SheepFarmTileentity farm)) {
            return super.useItemOn(heldItem, state, worldIn, pos, player, handIn, hit);
        }

        // Check if the held item is dye
        DyeColor dyeColor = getDyeColor(heldItem);
        if (dyeColor != null) {
            // Update the block state with the new color
            dyeBlock(state, worldIn, dyeColor, pos);
            return ItemInteractionResult.SUCCESS;
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

        return ItemInteractionResult.SUCCESS;
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
        return new SimpleBlockEntityTicker<>(); // Keeps default behavior
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
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SheepFarmTileentity farmTileEntity) {
            ItemContainerContents swordType = stack.get(ModDataComponents.SWORD_TYPE);
            if (swordType != null) {
                farmTileEntity.swordType = swordType.getStackInSlot(0);
                farmTileEntity.setChanged();
                updateCustomBlockEntityTag(level, placer instanceof Player ? (Player) placer : null, pos, swordType.getStackInSlot(0));
                level.sendBlockUpdated(pos, state, state, 3);
            }
        }
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
