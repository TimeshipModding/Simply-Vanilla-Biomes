package com.timeshipmodding.vanillabiomes.content.infrastructure.tags.registries;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static TagKey<Item> ASPEN_LOGS = createTag("aspen_logs");

    private static TagKey<Item> createTag(String name) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(VanillaBiomes.MODID, name));
    }
}