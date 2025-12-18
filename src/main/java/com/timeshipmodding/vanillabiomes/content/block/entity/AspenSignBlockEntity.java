package com.timeshipmodding.vanillabiomes.content.block.entity;

import com.timeshipmodding.vanillabiomes.content.block.entity.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AspenSignBlockEntity extends SignBlockEntity {
    public AspenSignBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ASPEN_SIGN_BLOCKENTITY.get(), pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.ASPEN_SIGN_BLOCKENTITY.get();
    }
}