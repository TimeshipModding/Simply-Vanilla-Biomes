package com.timeshipmodding.vanillabiomes.datagen;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataItemModels extends ItemModelProvider {
    public DataItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VanillaBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}