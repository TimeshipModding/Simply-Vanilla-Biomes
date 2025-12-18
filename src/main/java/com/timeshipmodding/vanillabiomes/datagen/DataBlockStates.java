package com.timeshipmodding.vanillabiomes.datagen;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks.*;

public class DataBlockStates extends BlockStateProvider {
    public DataBlockStates(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VanillaBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Block with Item
        blockWithItem(ASPEN_PLANKS);

        // Aspen Block Set
        logBlock(((RotatedPillarBlock) ASPEN_LOG.get()));
        logBlock(((RotatedPillarBlock) STRIPPED_ASPEN_LOG.get()));
        axisBlock(((RotatedPillarBlock) ASPEN_WOOD.get()), blockTexture(ASPEN_LOG.get()), blockTexture(ASPEN_LOG.get()));
        axisBlock(((RotatedPillarBlock) STRIPPED_ASPEN_WOOD.get()), blockTexture(STRIPPED_ASPEN_LOG.get()), blockTexture(STRIPPED_ASPEN_LOG.get()));
        stairsBlock(((StairBlock) ASPEN_STAIRS.get()), blockTexture(ASPEN_PLANKS.get()));
        slabBlock(((SlabBlock) ASPEN_SLAB.get()), blockTexture(ASPEN_PLANKS.get()), blockTexture(ASPEN_PLANKS.get()));
        fenceBlock(((FenceBlock) ASPEN_FENCE.get()), blockTexture(ASPEN_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ASPEN_FENCE_GATE.get()), blockTexture(ASPEN_PLANKS.get()));
        doorBlock((DoorBlock) ASPEN_DOOR.get(), modLoc("block/aspen_door_bottom"), modLoc("block/aspen_door_top"));
        trapdoorBlock(((TrapDoorBlock) ASPEN_TRAPDOOR.get()), modLoc("block/aspen_trapdoor"), true);
        pressurePlateBlock(((PressurePlateBlock) ASPEN_PRESSURE_PLATE.get()), blockTexture(ASPEN_PLANKS.get()));
        buttonBlock(((ButtonBlock) ASPEN_BUTTON.get()), blockTexture(ASPEN_PLANKS.get()));
        leavesBlock(ASPEN_LEAVES);
        signBlock((StandingSignBlock) ASPEN_SIGN.get(), (WallSignBlock) ASPEN_WALL_SIGN.get(), blockTexture(ASPEN_PLANKS.get()));
        hangingSignBlock((CeilingHangingSignBlock) ASPEN_HANGING_SIGN.get(), (WallHangingSignBlock) ASPEN_WALL_HANGING_SIGN.get(), blockTexture(ASPEN_PLANKS.get()));

        // Block Item
        blockItem(ASPEN_LOG);
        blockItem(ASPEN_WOOD);
        blockItem(STRIPPED_ASPEN_LOG);
        blockItem(STRIPPED_ASPEN_WOOD);
        blockItem(ASPEN_STAIRS);
        blockItem(ASPEN_FENCE_GATE);
        blockItem(ASPEN_TRAPDOOR, "_bottom");
        blockItem(ASPEN_SLAB);
        blockItem(ASPEN_PRESSURE_PLATE);
    }

    // Generate Methods
    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("vanillabiomes:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("vanillabiomes:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }
}