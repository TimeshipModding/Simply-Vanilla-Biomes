package com.timeshipmodding.vanillabiomes.content.creativetab;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import com.timeshipmodding.vanillabiomes.content.item.registries.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks.*;
import static com.timeshipmodding.vanillabiomes.content.item.registries.ModItems.*;

public class VanillaBiomesTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VanillaBiomes.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ESSENTIALS_TAB = CREATIVE_MODE_TABS.register("vanillabiomestab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.vanillabiomes.vanillabiomestab"))
            .icon(() -> new ItemStack(ASPEN_LEAVES))
            .displayItems((parameters, output) -> {
                output.accept(ASPEN_LOG);
                output.accept(ASPEN_WOOD);
                output.accept(STRIPPED_ASPEN_LOG);
                output.accept(STRIPPED_ASPEN_WOOD);
                output.accept(ASPEN_PLANKS);
                output.accept(ASPEN_STAIRS);
                output.accept(ASPEN_SLAB);
                output.accept(ASPEN_FENCE);
                output.accept(ASPEN_FENCE_GATE);
                output.accept(ASPEN_DOOR);
                output.accept(ASPEN_TRAPDOOR);
                output.accept(ASPEN_PRESSURE_PLATE);
                output.accept(ASPEN_BUTTON);
                output.accept(ASPEN_LEAVES);
                output.accept(ModItems.ASPEN_SIGN);
                output.accept(ModItems.ASPEN_HANGING_SIGN);
                output.accept(ASPEN_BOAT);
                output.accept(ASPEN_CHEST_BOAT);
            }).build());
}