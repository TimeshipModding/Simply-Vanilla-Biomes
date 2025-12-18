package com.timeshipmodding.vanillabiomes.content.infrastructure.tags.registries;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> ASPEN_LOGS = createTag("aspen_logs");

    private static TagKey<Block> createTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(VanillaBiomes.MODID, name));
    }
}