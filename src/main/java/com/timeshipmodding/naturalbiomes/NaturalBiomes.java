package com.timeshipmodding.naturalbiomes;

import com.timeshipmodding.naturalbiomes.content.block.entity.registries.ModBlockEntities;
import com.timeshipmodding.naturalbiomes.content.block.registries.ModBlocks;
import com.timeshipmodding.naturalbiomes.content.creativetab.NaturalBiomesTab;
import com.timeshipmodding.naturalbiomes.content.entity.registries.ModEntities;
import com.timeshipmodding.naturalbiomes.content.item.registries.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

@Mod(NaturalBiomes.MODID)
public class NaturalBiomes {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "naturalbiomes";

    public NaturalBiomes(IEventBus modEventBus) {
        // Register registry classes
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Register creative mode tab
        NaturalBiomesTab.CREATIVE_MODE_TABS.register(modEventBus);
    }
}