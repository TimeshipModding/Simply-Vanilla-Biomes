package com.timeshipmodding.naturalbiomes.content.item.registries;

import com.timeshipmodding.naturalbiomes.NaturalBiomes;
import com.timeshipmodding.naturalbiomes.content.block.registries.ModBlocks;
import com.timeshipmodding.naturalbiomes.content.entity.AspenBoatEntity;
import com.timeshipmodding.naturalbiomes.content.item.AspenBoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NaturalBiomes.MODID);

    // ITEMS.register
    public static final DeferredItem<Item> ASPEN_SIGN = ITEMS.register("aspen_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.ASPEN_SIGN.get(), ModBlocks.ASPEN_WALL_SIGN.get()));
    public static final DeferredItem<Item> ASPEN_HANGING_SIGN = ITEMS.register("aspen_hanging_sign", () -> new HangingSignItem(ModBlocks.ASPEN_HANGING_SIGN.get(), ModBlocks.ASPEN_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> ASPEN_BOAT = ITEMS.register("aspen_boat", () -> new AspenBoatItem(false, AspenBoatEntity.Type.ASPEN, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ASPEN_CHEST_BOAT = ITEMS.register("aspen_chest_boat", () -> new AspenBoatItem(true, AspenBoatEntity.Type.ASPEN, new Item.Properties().stacksTo(1)));
}