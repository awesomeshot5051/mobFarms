package com.awesomeshot5051.mobfarms.blocks.passiveMobs;

import com.awesomeshot5051.mobfarms.blocks.*;
import com.awesomeshot5051.mobfarms.blocks.tileentity.passiveMobs.*;
import com.awesomeshot5051.mobfarms.datacomponents.*;
import com.awesomeshot5051.mobfarms.enums.*;
import com.awesomeshot5051.mobfarms.gui.*;
import com.awesomeshot5051.mobfarms.items.render.passiveMobs.*;
import de.maxhenkel.corelib.block.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.client.*;
import net.minecraft.*;
import net.minecraft.client.gui.screens.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.nbt.*;
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
import java.util.stream.*;

import static net.minecraft.world.item.BlockItem.*;

public class ChickenFarmBlock extends BlockBase implements EntityBlock, IItemBlock {
    public static final EnumProperty<SwordType> SWORD_TYPE = EnumProperty.create("sword_type", SwordType.class);

    public ChickenFarmBlock() {
        super(Properties.of().mapColor(MapColor.METAL).strength(2.5F).sound(SoundType.METAL).noOcclusion()); // Adjusted for creeper farm
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);

        // Get the block entity
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ChickenFarmTileentity farmTileEntity) {
            // Check for the pick type in the item stack
            ItemContainerContents swordType = stack.get(ModDataComponents.SWORD_TYPE);
            if (swordType != null) {
                farmTileEntity.swordType = swordType.getStackInSlot(0);
//                DeepslateCoalOreFarmRenderer.setStaticFarmstack(swordType.getStackInSlot(0));
                // Ensure the tile entity is marked as changed and synced
                farmTileEntity.setChanged();
                CompoundTag compoundTag = new CompoundTag();

                compoundTag.putString("id", BuiltInRegistries.ITEM.getKey(farmTileEntity.swordType.getItem()).toString()); // Save the item ID
                compoundTag.putInt("count", farmTileEntity.swordType.getCount()); // Save the count
                setBlockEntityData(stack, blockEntity.getType(), compoundTag);
                updateCustomBlockEntityTag(level, placer instanceof Player ? (Player) placer : null, pos, swordType.getStackInSlot(0));
                level.sendBlockUpdated(pos, state, state, 3);
            }
        }
    }


    @Override
    public Item toItem() {
        return new CustomRendererBlockItem(this, new Item.Properties()) {
            @OnlyIn(Dist.CLIENT)
            @Override
            public ItemRenderer createItemRenderer() {
                return new ChickenFarmItemRenderer(); // Custom creeper farm renderer
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
        ChickenFarmTileentity trader = VillagerBlockEntityData.getAndStoreBlockEntity(stack, context.registries(), context.level(), () -> new ChickenFarmTileentity(BlockPos.ZERO, ModBlocks.CHICKEN_FARM.get().defaultBlockState()));
        // Removed villager-related tooltip information
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        if (!(tileEntity instanceof ChickenFarmTileentity farm)) { // Check for CreeperFarmTileentity
            return super.useItemOn(heldItem, state, worldIn, pos, player, handIn, hit);
        }

        // Directly open the container without villager checks
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.translatable(state.getBlock().getDescriptionId());
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
                return new OutputContainer(id, playerInventory, farm.getOutputInventory(), ContainerLevelAccess.create(worldIn, pos), ModBlocks.CHICKEN_FARM::get); // Adjust for creeper farm
            }
        });
        return ItemInteractionResult.SUCCESS;
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


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ChickenFarmTileentity(blockPos, blockState); // Spawn CreeperFarmTileentity
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
