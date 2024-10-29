/*   0 */ package com.awesomeshot5051.mobfarms.items.render;
/*   0 */ 
/*   0 */ import com.awesomeshot5051.mobfarms.blocks.tileentity.FakeWorldTileentity;
/*   0 */ import com.awesomeshot5051.mobfarms.datacomponents.VillagerBlockEntityData;
/*   0 */ import com.mojang.blaze3d.vertex.PoseStack;
/*   0 */ import de.maxhenkel.corelib.client.ItemRenderer;
/*   0 */ import de.maxhenkel.corelib.client.RendererProviders;
/*   0 */ import java.util.function.Function;
/*   0 */ import java.util.function.Supplier;
/*   0 */ import net.minecraft.client.renderer.MultiBufferSource;
/*   0 */ import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
/*   0 */ import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
/*   0 */ import net.minecraft.core.HolderLookup;
/*   0 */ import net.minecraft.world.item.BlockItem;
/*   0 */ import net.minecraft.world.item.Item;
/*   0 */ import net.minecraft.world.item.ItemDisplayContext;
/*   0 */ import net.minecraft.world.item.ItemStack;
/*   0 */ import net.minecraft.world.level.Level;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntity;
/*   0 */ 
/*   0 */ public class BlockItemRendererBase<T extends BlockEntityRenderer<U>, U extends FakeWorldTileentity> extends ItemRenderer {
/*   0 */   private final Function<BlockEntityRendererProvider.Context, T> rendererSupplier;
/*   0 */   
/*   0 */   private final Supplier<U> tileEntitySupplier;
/*   0 */   
/*   0 */   private T renderer;
/*   0 */   
/*   0 */   public BlockItemRendererBase(Function<BlockEntityRendererProvider.Context, T> rendererSupplier, Supplier<U> tileentitySupplier) {
/*  25 */     this.rendererSupplier = rendererSupplier;
/*  26 */     this.tileEntitySupplier = tileentitySupplier;
/*   0 */   }
/*   0 */   
/*   0 */   public void renderByItem(ItemStack itemStack, ItemDisplayContext displayContext, PoseStack matrixStack, MultiBufferSource buffer, int combinedLightIn, int combinedOverlayIn) {
/*  31 */     if (this.renderer == null)
/*  32 */       this.renderer = this.rendererSupplier.apply(RendererProviders.createBlockEntityRendererContext()); 
/*  34 */     Item item = itemStack.getItem();
/*  34 */     if (item instanceof BlockItem) {
/*  34 */       BlockItem blockItem = (BlockItem)item;
/*  35 */       this.minecraft.getBlockRenderer().renderSingleBlock(blockItem.getBlock().defaultBlockState(), matrixStack, buffer, combinedLightIn, combinedOverlayIn);
/*   0 */     } 
/*  37 */     U be = VillagerBlockEntityData.getAndStoreBlockEntity(itemStack, (HolderLookup.Provider)this.minecraft.level.registryAccess(), (Level)this.minecraft.level, this.tileEntitySupplier);
/*  38 */     this.renderer.render((BlockEntity)be, 0.0F, matrixStack, buffer, combinedLightIn, combinedOverlayIn);
/*   0 */   }
/*   0 */ }
