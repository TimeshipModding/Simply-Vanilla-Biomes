package com.timeshipmodding.naturalbiomes.content.block;

import com.timeshipmodding.naturalbiomes.content.block.entity.AspenHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AspenHangingSignBlock extends CeilingHangingSignBlock {
    public AspenHangingSignBlock(WoodType type, Properties properties) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AspenHangingSignBlockEntity(pos, state);
    }
}