package com.awesomeshot5051.mobfarms.items.render;

import com.awesomeshot5051.mobfarms.blocks.tileentity.FakeWorldTileentity;
import com.awesomeshot5051.mobfarms.datacomponents.VillagerBlockEntityData;
import com.mojang.blaze3d.vertex.PoseStack;
import de.maxhenkel.corelib.client.ItemRenderer;
import de.maxhenkel.corelib.client.RendererProviders;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BlockItemRendererBase<T extends BlockEntityRenderer<U>, U extends FakeWorldTileentity> extends ItemRenderer {
   private final Function<BlockEntityRendererProvider.Context, T> rendererSupplier;
   
   private final Supplier<U> tileEntitySupplier;
   
   private T renderer;
   
   public BlockItemRendererBase(Function<BlockEntityRendererProvider.Context, T> rendererSupplier, Supplier<U> tileentitySupplier) {
/*  25 */     this.rendererSupplier = rendererSupplier;
/*  26 */     this.tileEntitySupplier = tileentitySupplier;
   }
   
   public void renderByItem(ItemStack itemStack, ItemDisplayContext displayContext, PoseStack matrixStack, MultiBufferSource buffer, int combinedLightIn, int combinedOverlayIn) {
/*  31 */     if (this.renderer == null)
/*  32 */       this.renderer = this.rendererSupplier.apply(RendererProviders.createBlockEntityRendererContext()); 
/*  34 */     Item item = itemStack.getItem();
/*  34 */     if (item instanceof BlockItem) {
/*  34 */       BlockItem blockItem = (BlockItem)item;
/*  35 */       this.minecraft.getBlockRenderer().renderSingleBlock(blockItem.getBlock().defaultBlockState(), matrixStack, buffer, combinedLightIn, combinedOverlayIn);
     } 
/*  37 */     U be = VillagerBlockEntityData.getAndStoreBlockEntity(itemStack, (HolderLookup.Provider)this.minecraft.level.registryAccess(), (Level)this.minecraft.level, this.tileEntitySupplier);
/*  38 */     this.renderer.render((BlockEntity)be, 0.0F, matrixStack, buffer, combinedLightIn, combinedOverlayIn);
   }
}
