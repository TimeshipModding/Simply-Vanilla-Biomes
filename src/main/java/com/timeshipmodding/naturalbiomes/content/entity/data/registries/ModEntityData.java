package com.timeshipmodding.naturalbiomes.content.entity.data.registries;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.vehicle.Boat;

public class ModEntityData {
    public static final EntityDataAccessor<Integer> ASPEN_BOAT_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);
}