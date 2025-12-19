package com.timeshipmodding.naturalbiomes.content.entity;

import com.timeshipmodding.naturalbiomes.content.block.registries.ModBlocks;
import com.timeshipmodding.naturalbiomes.content.entity.data.registries.ModEntityData;
import com.timeshipmodding.naturalbiomes.content.entity.registries.ModEntities;
import com.timeshipmodding.naturalbiomes.content.item.registries.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class AspenBoatEntity extends Boat {
    public AspenBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public AspenBoatEntity(Level level, double pX, double pY, double pZ) {
        this(ModEntities.ASPEN_BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case ASPEN -> ModItems.ASPEN_BOAT.get();
        };
    }

    public void setVariant(Type variant) {
        this.entityData.set(ModEntityData.ASPEN_BOAT_TYPE, variant.ordinal());
    }

    public Type getModVariant() {
        return Type.byId(this.entityData.get(ModEntityData.ASPEN_BOAT_TYPE));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ModEntityData.ASPEN_BOAT_TYPE, Type.ASPEN.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putString("type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.contains("type", 8)) {
            this.setVariant(Type.byName(tag.getString("type")));
        }
    }

    public static enum Type implements StringRepresentable {
        ASPEN(ModBlocks.ASPEN_PLANKS.get(), "aspen");

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<AspenBoatEntity.Type> CODEC = StringRepresentable.fromEnum(AspenBoatEntity.Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static AspenBoatEntity.Type byId(int id) {
            return BY_ID.apply(id);
        }

        public static AspenBoatEntity.Type byName(String name) {
            return CODEC.byName(name, ASPEN);
        }
    }
}