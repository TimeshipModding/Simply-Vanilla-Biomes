package com.timeshipmodding.vanillabiomes.datagen.loot;

import com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks;
import com.timeshipmodding.vanillabiomes.content.item.registries.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Set;

import static com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks.*;

public class DataBlockLootTables extends BlockLootSubProvider {
    public DataBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        // Drop Self
        dropSelf(ASPEN_LOG.get());
        dropSelf(ASPEN_WOOD.get());
        dropSelf(STRIPPED_ASPEN_LOG.get());
        dropSelf(STRIPPED_ASPEN_WOOD.get());
        dropSelf(ASPEN_PLANKS.get());
        dropSelf(ASPEN_STAIRS.get());
        dropSelf(ASPEN_FENCE.get());
        dropSelf(ASPEN_FENCE_GATE.get());
        dropSelf(ASPEN_PRESSURE_PLATE.get());
        dropSelf(ASPEN_BUTTON.get());
        dropSelf(ASPEN_TRAPDOOR.get());

        // Drop Other
        dropOther(ASPEN_SIGN.get(), ModItems.ASPEN_SIGN.get());
        dropOther(ASPEN_WALL_SIGN.get(), ModItems.ASPEN_SIGN.get());
        dropOther(ASPEN_HANGING_SIGN.get(), ModItems.ASPEN_HANGING_SIGN.get());
        dropOther(ASPEN_WALL_HANGING_SIGN.get(), ModItems.ASPEN_HANGING_SIGN.get());

        // Slab Drops
        add(ASPEN_SLAB.get(), block -> createSlabItemTable(ASPEN_SLAB.get()));

        // Door Drops
        this.add(ASPEN_DOOR.get(), block -> createDoorTable(ASPEN_DOOR.get()));

        // Leaves Drops
        add(ASPEN_LEAVES.get(), block -> createLeavesDrops(block, Blocks.OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
    }

    // Generate Methods
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}