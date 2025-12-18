package com.timeshipmodding.vanillabiomes.content.block.entity.registries;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import com.timeshipmodding.vanillabiomes.content.block.entity.AspenHangingSignBlockEntity;
import com.timeshipmodding.vanillabiomes.content.block.entity.AspenSignBlockEntity;
import com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, VanillaBiomes.MODID);

    public static final Supplier<BlockEntityType<AspenSignBlockEntity>> ASPEN_SIGN_BLOCKENTITY =
            BLOCK_ENTITIES.register("aspen_sign_blockentity", () -> BlockEntityType.Builder.of(
                    AspenSignBlockEntity::new, ModBlocks.ASPEN_SIGN.get(), ModBlocks.ASPEN_WALL_SIGN.get()
            ).build(null));

    public static final Supplier<BlockEntityType<AspenHangingSignBlockEntity>> ASPEN_HANGING_SIGN_BLOCKENTITY =
            BLOCK_ENTITIES.register("aspen_hanging_sign_blockentity", () -> BlockEntityType.Builder.of(
                    AspenHangingSignBlockEntity::new, ModBlocks.ASPEN_HANGING_SIGN.get(), ModBlocks.ASPEN_WALL_HANGING_SIGN.get()
            ).build(null));
}