package com.timeshipmodding.naturalbiomes.datagen.tags;

import com.timeshipmodding.naturalbiomes.NaturalBiomes;
import com.timeshipmodding.naturalbiomes.content.infrastructure.tags.registries.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.timeshipmodding.naturalbiomes.content.block.registries.ModBlocks.*;

public class DataBlockTags extends BlockTagsProvider {
    public DataBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NaturalBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Minecraft tags
        tag(BlockTags.LOGS_THAT_BURN)
                .add(ASPEN_LOG.get())
                .add(ASPEN_WOOD.get())
                .add(STRIPPED_ASPEN_LOG.get())
                .add(STRIPPED_ASPEN_WOOD.get());
        tag(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(ASPEN_LOG.get());
        tag(BlockTags.PLANKS)
                .add(ASPEN_PLANKS.get());
        tag(BlockTags.WOODEN_STAIRS)
                .add(ASPEN_STAIRS.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(ASPEN_SLAB.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(ASPEN_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ASPEN_FENCE_GATE.get());
        tag(BlockTags.WOODEN_DOORS)
                .add(ASPEN_DOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ASPEN_TRAPDOOR.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ASPEN_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS)
                .add(ASPEN_BUTTON.get());
        tag(BlockTags.LEAVES)
                .add(ASPEN_LEAVES.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ASPEN_LEAVES.get());
        tag(BlockTags.STANDING_SIGNS)
                .add(ASPEN_SIGN.get());
        tag(BlockTags.WALL_SIGNS)
                .add(ASPEN_WALL_SIGN.get());
        tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ASPEN_HANGING_SIGN.get());
        tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ASPEN_WALL_HANGING_SIGN.get());

        // Vanilla Biomes tags
        tag(ModBlockTags.ASPEN_LOGS)
                .add(ASPEN_LOG.get())
                .add(ASPEN_WOOD.get())
                .add(STRIPPED_ASPEN_LOG.get())
                .add(STRIPPED_ASPEN_WOOD.get());
    }
}