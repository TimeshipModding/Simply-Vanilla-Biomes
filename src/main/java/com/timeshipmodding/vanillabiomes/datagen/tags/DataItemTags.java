package com.timeshipmodding.vanillabiomes.datagen.tags;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import com.timeshipmodding.vanillabiomes.content.infrastructure.tags.registries.ModBlockTags;
import com.timeshipmodding.vanillabiomes.content.infrastructure.tags.registries.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks.*;
import static com.timeshipmodding.vanillabiomes.content.item.registries.ModItems.*;

public class DataItemTags extends ItemTagsProvider {
    public DataItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, VanillaBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Minecraft tags
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ASPEN_LOG.get().asItem())
                .add(ASPEN_WOOD.get().asItem())
                .add(STRIPPED_ASPEN_LOG.asItem())
                .add(STRIPPED_ASPEN_WOOD.get().asItem());
        tag(ItemTags.BOATS)
                .add(ASPEN_BOAT.get().asItem());
        tag(ItemTags.CHEST_BOATS)
                .add(ASPEN_CHEST_BOAT.get().asItem());

        // Vanilla Biomes tags
        this.copy(ModBlockTags.ASPEN_LOGS, ModItemTags.ASPEN_LOGS);
    }
}