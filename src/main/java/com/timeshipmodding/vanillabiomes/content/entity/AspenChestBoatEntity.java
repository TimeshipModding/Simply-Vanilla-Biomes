package com.timeshipmodding.vanillabiomes.content.entity;

import com.timeshipmodding.vanillabiomes.content.entity.data.registries.ModEntityData;
import com.timeshipmodding.vanillabiomes.content.entity.registries.ModEntities;
import com.timeshipmodding.vanillabiomes.content.item.registries.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class AspenChestBoatEntity extends ChestBoat {
    public AspenChestBoatEntity(EntityType<? extends ChestBoat> entityType, Level level) {
        super(entityType, level);
    }

    public AspenChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ModEntities.ASPEN_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch (getBoatVariant()) {
            case ASPEN -> ModItems.ASPEN_CHEST_BOAT.get();
        };
    }

    public void setVariant(AspenBoatEntity.Type variant) {
        this.entityData.set(ModEntityData.ASPEN_BOAT_TYPE, variant.ordinal());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ModEntityData.ASPEN_BOAT_TYPE, AspenBoatEntity.Type.ASPEN.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("type", this.getBoatVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("type", 8)) {
            this.setVariant(AspenBoatEntity.Type.byName(tag.getString("type")));
        }
    }

    public AspenBoatEntity.Type getBoatVariant() {
        return AspenBoatEntity.Type.byId(this.entityData.get(ModEntityData.ASPEN_BOAT_TYPE));
    }
}