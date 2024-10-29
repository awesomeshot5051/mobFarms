/*   0 */ package com.awesomeshot5051.mobfarms.blocks.tileentity;
/*   0 */ 
/*   0 */ import net.minecraft.core.BlockPos;
/*   0 */ import net.minecraft.core.HolderLookup;
/*   0 */ import net.minecraft.nbt.CompoundTag;
/*   0 */ import net.minecraft.network.protocol.Packet;
/*   0 */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*   0 */ import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
/*   0 */ import net.minecraft.server.level.ServerChunkCache;
/*   0 */ import net.minecraft.server.level.ServerLevel;
/*   0 */ import net.minecraft.server.level.ServerPlayer;
/*   0 */ import net.minecraft.world.level.Level;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntity;
/*   0 */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*   0 */ import net.minecraft.world.level.block.state.BlockState;
/*   0 */ import net.minecraft.world.level.chunk.ChunkSource;
/*   0 */ import net.minecraft.world.level.chunk.LevelChunk;
/*   0 */ 
/*   0 */ public class SyncableTileentity extends BlockEntity {
/*   0 */   public SyncableTileentity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
/*  20 */     super(type, pos, state);
/*   0 */   }
/*   0 */   
/*   0 */   public void sync() {
/*  24 */     Level level = this.level;
/*  24 */     if (level instanceof ServerLevel) {
/*  24 */       ServerLevel serverLevel = (ServerLevel)level;
/*  25 */       LevelChunk chunk = serverLevel.getChunkAt(getBlockPos());
/*  26 */       ChunkSource chunkSource = chunk.getLevel().getChunkSource();
/*  26 */       if (chunkSource instanceof ServerChunkCache) {
/*  26 */         ServerChunkCache chunkCache = (ServerChunkCache)chunkSource;
/*  27 */         chunkCache.chunkMap.getPlayers(chunk.getPos(), false).forEach(this::syncContents);
/*   0 */       } 
/*   0 */     } 
/*   0 */   }
/*   0 */   
/*   0 */   public void syncContents(ServerPlayer player) {
/*  33 */     player.connection.send(getUpdatePacket());
/*   0 */   }
/*   0 */   
/*   0 */   public Packet<ClientGamePacketListener> getUpdatePacket() {
/*  38 */     return (Packet<ClientGamePacketListener>)ClientboundBlockEntityDataPacket.create(this);
/*   0 */   }
/*   0 */   
/*   0 */   public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
/*  43 */     CompoundTag updateTag = new CompoundTag();
/*  44 */     saveAdditional(updateTag, provider);
/*  45 */     return updateTag;
/*   0 */   }
/*   0 */ }
