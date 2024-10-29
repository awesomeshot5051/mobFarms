package com.awesomeshot5051.mobfarms.events;

import com.awesomeshot5051.mobfarms.blocks.BlockBase;
import com.awesomeshot5051.mobfarms.blocks.DyeDispenseItemBehavior;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class BlockEvents {

    public BlockEvents() {
        registerDispenserBehaviors();
    }

    private void registerDispenserBehaviors() {
        // Register the dye behavior for all dye items
        for (var dyeItem : new Item[]{Items.WHITE_DYE, Items.ORANGE_DYE, Items.MAGENTA_DYE,
                Items.LIGHT_BLUE_DYE, Items.YELLOW_DYE, Items.LIME_DYE,
                Items.PINK_DYE, Items.GRAY_DYE, Items.LIGHT_GRAY_DYE,
                Items.CYAN_DYE, Items.PURPLE_DYE, Items.BLUE_DYE,
                Items.BROWN_DYE, Items.GREEN_DYE, Items.RED_DYE,
                Items.BLACK_DYE}) {
            DispenserBlock.registerBehavior(dyeItem, new DyeDispenseItemBehavior());
        }
    }

    @SubscribeEvent
    public void onBlockClick(PlayerInteractEvent.RightClickBlock event) {
        BlockState state = event.getLevel().getBlockState(event.getPos());
        if (!(state.getBlock() instanceof BlockBase block)) {
            return;
        }

        if (block.overrideClick(state, event.getLevel(), event.getPos(), event.getEntity(), event.getHand())) {
            event.setUseBlock(TriState.TRUE);
        }
    }
}
