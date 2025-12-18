package com.timeshipmodding.vanillabiomes;

import com.timeshipmodding.vanillabiomes.content.block.entity.registries.ModBlockEntities;
import com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks;
import com.timeshipmodding.vanillabiomes.content.creativetab.VanillaBiomesTab;
import com.timeshipmodding.vanillabiomes.content.entity.registries.ModEntities;
import com.timeshipmodding.vanillabiomes.content.item.registries.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

@Mod(VanillaBiomes.MODID)
public class VanillaBiomes {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "vanillabiomes";

    public VanillaBiomes(IEventBus modEventBus) {
        // Register registry classes
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Register creative mode tab
        VanillaBiomesTab.CREATIVE_MODE_TABS.register(modEventBus);
    }
}