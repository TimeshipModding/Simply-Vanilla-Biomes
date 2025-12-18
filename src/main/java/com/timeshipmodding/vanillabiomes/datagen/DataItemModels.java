package com.timeshipmodding.vanillabiomes.datagen;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import com.timeshipmodding.vanillabiomes.content.item.registries.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks.*;
import static com.timeshipmodding.vanillabiomes.content.item.registries.ModItems.*;

public class DataItemModels extends ItemModelProvider {
    public DataItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VanillaBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Fence Item
        fenceItem(ASPEN_FENCE, ASPEN_PLANKS);

        // Button Item
        buttonItem(ASPEN_BUTTON, ASPEN_PLANKS);

        // Sign Item
        basicItem(ASPEN_DOOR.asItem());
        basicItem(ModItems.ASPEN_SIGN.get());
        basicItem(ModItems.ASPEN_HANGING_SIGN.get());
        basicItem(ASPEN_BOAT.get());
        basicItem(ASPEN_CHEST_BOAT.get());
    }

    // Generate Methods
    public void fenceItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(VanillaBiomes.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }


    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(VanillaBiomes.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
}