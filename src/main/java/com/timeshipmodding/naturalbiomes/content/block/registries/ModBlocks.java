package com.timeshipmodding.naturalbiomes.content.block.registries;

import com.timeshipmodding.naturalbiomes.NaturalBiomes;
import com.timeshipmodding.naturalbiomes.content.block.*;
import com.timeshipmodding.naturalbiomes.content.block.type.registries.ModBlockSetTypes;
import com.timeshipmodding.naturalbiomes.content.block.type.registries.ModWoodTypes;
import com.timeshipmodding.naturalbiomes.content.item.registries.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NaturalBiomes.MODID);

    // registerBlock
    public static final DeferredBlock<Block> ASPEN_LOG = registerBlock("aspen_log", () -> new AspenRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_WOOD = registerBlock("aspen_wood", () -> new AspenRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_LOG = registerBlock("stripped_aspen_log", () -> new AspenRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ASPEN_WOOD = registerBlock("stripped_aspen_wood", () -> new AspenRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_PLANKS = registerBlock("aspen_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_STAIRS = registerBlock("aspen_stairs", () -> new StairBlock(ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_SLAB = registerBlock("aspen_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_FENCE = registerBlock("aspen_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_FENCE_GATE = registerBlock("aspen_fence_gate", () -> new FenceGateBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_DOOR = registerBlock("aspen_door", () -> new DoorBlock(ModBlockSetTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).sound(SoundType.CHERRY_WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> ASPEN_TRAPDOOR = registerBlock("aspen_trapdoor", () -> new TrapDoorBlock(ModBlockSetTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).sound(SoundType.CHERRY_WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> ASPEN_PRESSURE_PLATE = registerBlock("aspen_pressure_plate", () -> new PressurePlateBlock(ModBlockSetTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_BUTTON = registerBlock("aspen_button", () -> new ButtonBlock(ModBlockSetTypes.ASPEN, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).sound(SoundType.CHERRY_WOOD).noCollission().ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_LEAVES = registerBlock("aspen_leaves", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).ignitedByLava()));

    // BLOCKS.register
    public static final DeferredBlock<Block> ASPEN_SIGN = BLOCKS.register("aspen_sign", () -> new AspenStandingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_WALL_SIGN = BLOCKS.register("aspen_wall_sign", () -> new AspenWallSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_HANGING_SIGN = BLOCKS.register("aspen_hanging_sign", () -> new AspenHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ASPEN_WALL_HANGING_SIGN = BLOCKS.register("aspen_wall_hanging_sign", () -> new AspenWallHangingSignBlock(ModWoodTypes.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    // Register Methods
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}