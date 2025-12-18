package com.timeshipmodding.vanillabiomes.content.block;

import com.timeshipmodding.vanillabiomes.content.block.entity.AspenHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AspenWallHangingSignBlock extends WallHangingSignBlock {
    public AspenWallHangingSignBlock(WoodType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AspenHangingSignBlockEntity(pos, state);
    }
}