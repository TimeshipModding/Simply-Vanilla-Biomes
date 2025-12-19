package com.timeshipmodding.naturalbiomes.event;

import com.timeshipmodding.naturalbiomes.datagen.DataBlockStates;
import com.timeshipmodding.naturalbiomes.datagen.DataItemModels;
import com.timeshipmodding.naturalbiomes.datagen.DataRecipes;
import com.timeshipmodding.naturalbiomes.datagen.loot.DataBlockLootTables;
import com.timeshipmodding.naturalbiomes.datagen.tags.DataBlockTags;
import com.timeshipmodding.naturalbiomes.datagen.tags.DataItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = "naturalbiomes")
public class DataGenerationEvent {
    @SubscribeEvent
    public static void gatherdata(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new DataRecipes(packOutput, lookupProvider));
        //generator.addProvider(event.includeServer(), new DataWorldgenAndDatapack(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(DataBlockLootTables::new, LootContextParamSets.BLOCK)), lookupProvider));

        BlockTagsProvider blockTagsProvider = new DataBlockTags(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new DataItemTags(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new DataBlockStates(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new DataItemModels(packOutput, existingFileHelper));
    }
}