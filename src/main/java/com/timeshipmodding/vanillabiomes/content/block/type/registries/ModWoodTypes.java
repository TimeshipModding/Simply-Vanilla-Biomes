package com.timeshipmodding.vanillabiomes.content.block.type.registries;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class ModWoodTypes {
    public static final WoodType ASPEN = register(new WoodType(
            "vanillabiomes:aspen",
            ModBlockSetTypes.ASPEN,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN));

}