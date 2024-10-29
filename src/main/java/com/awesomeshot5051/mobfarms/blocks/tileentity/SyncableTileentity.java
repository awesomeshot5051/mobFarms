package com.awesomeshot5051.mobfarms.blocks.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.chunk.LevelChunk;

public class SyncableTileentity extends BlockEntity {
   public SyncableTileentity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
/*  20 */     super(type, pos, state);
   }
   
   public void sync() {
/*  24 */     Level level = this.level;
/*  24 */     if (level instanceof ServerLevel) {
/*  24 */       ServerLevel serverLevel = (ServerLevel)level;
/*  25 */       LevelChunk chunk = serverLevel.getChunkAt(getBlockPos());
/*  26 */       ChunkSource chunkSource = chunk.getLevel().getChunkSource();
/*  26 */       if (chunkSource instanceof ServerChunkCache) {
/*  26 */         ServerChunkCache chunkCache = (ServerChunkCache)chunkSource;
/*  27 */         chunkCache.chunkMap.getPlayers(chunk.getPos(), false).forEach(this::syncContents);
       } 
     } 
   }
   
   public void syncContents(ServerPlayer player) {
/*  33 */     player.connection.send(getUpdatePacket());
   }
   
   public Packet<ClientGamePacketListener> getUpdatePacket() {
/*  38 */     return (Packet<ClientGamePacketListener>)ClientboundBlockEntityDataPacket.create(this);
   }
   
   public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
/*  43 */     CompoundTag updateTag = new CompoundTag();
/*  44 */     saveAdditional(updateTag, provider);
/*  45 */     return updateTag;
   }
}
