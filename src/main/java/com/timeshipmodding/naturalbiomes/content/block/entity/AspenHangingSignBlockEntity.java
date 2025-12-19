package com.timeshipmodding.naturalbiomes.content.block.entity;

import com.timeshipmodding.naturalbiomes.content.block.entity.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AspenHangingSignBlockEntity extends HangingSignBlockEntity {
    public AspenHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.ASPEN_HANGING_SIGN_BLOCKENTITY.get();
    }
}