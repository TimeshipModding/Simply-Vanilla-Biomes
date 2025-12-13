package com.timeshipmodding.vanillabiomes.content.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.timeshipmodding.vanillabiomes.VanillaBiomes.MODID;

//import static com.timeshipmodding.villagecraft3essentials.VillageCraft3Essentials.MODID;
//import static com.timeshipmodding.villagecraft3essentials.content.block.registries.ModBlocks.*;
//import static com.timeshipmodding.villagecraft3essentials.content.item.registries.ModItems.*;

public class VanillaBiomesTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ESSENTIALS_TAB = CREATIVE_MODE_TABS.register("vanillabiomestab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.vanillabiomes.vanillabiomestab"))
            .icon(() -> new ItemStack(Blocks.BEACON))
            .displayItems((parameters, pOutput) -> {
            }).build());
}