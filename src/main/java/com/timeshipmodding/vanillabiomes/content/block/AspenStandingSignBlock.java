package com.timeshipmodding.vanillabiomes.content.block;

import com.timeshipmodding.vanillabiomes.content.block.entity.AspenSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AspenStandingSignBlock extends StandingSignBlock {
    public AspenStandingSignBlock(WoodType type,Properties properties) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AspenSignBlockEntity(pos, state);
    }
}