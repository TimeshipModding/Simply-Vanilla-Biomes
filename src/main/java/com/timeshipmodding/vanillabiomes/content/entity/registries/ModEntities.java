package com.timeshipmodding.vanillabiomes.content.entity.registries;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import com.timeshipmodding.vanillabiomes.content.entity.AspenBoatEntity;
import com.timeshipmodding.vanillabiomes.content.entity.AspenChestBoatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, VanillaBiomes.MODID);

    public static final Supplier<EntityType<AspenBoatEntity>> ASPEN_BOAT = ENTITY_TYPES.register("aspen_boat", () -> EntityType.Builder.<AspenBoatEntity>of(AspenBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("aspen_boat"));
    public static final Supplier<EntityType<AspenChestBoatEntity>> ASPEN_CHEST_BOAT = ENTITY_TYPES.register("aspen_chest_boat", () -> EntityType.Builder.<AspenChestBoatEntity>of(AspenChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("aspen_chest_boat"));
}