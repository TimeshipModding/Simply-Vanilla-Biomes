package com.timeshipmodding.naturalbiomes.content.entity.client.renderers;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.timeshipmodding.naturalbiomes.NaturalBiomes;
import com.timeshipmodding.naturalbiomes.content.entity.AspenBoatEntity;
import com.timeshipmodding.naturalbiomes.content.entity.AspenChestBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class AspenBoatRenderer extends BoatRenderer {
    private final Map<AspenBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public AspenBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
        super(context, chestBoat);
        this.boatResources = Stream.of(AspenBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type,
                type -> Pair.of(ResourceLocation.fromNamespaceAndPath(NaturalBiomes.MODID, getTextureLocation(type, chestBoat)), this.createBoatModel(context, type, chestBoat))));
    }

    private static String getTextureLocation(AspenBoatEntity.Type type, boolean chestBoat) {
        return chestBoat ? "textures/entity/chest_boat/" + type.getName() + ".png" : "textures/entity/boat/" + type.getName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, AspenBoatEntity.Type type, boolean chestBoat) {
        ModelLayerLocation modellayerlocation = chestBoat ? AspenBoatRenderer.createChestBoatModelName(type) : AspenBoatRenderer.createBoatModelName(type);
        ModelPart modelpart = context.bakeLayer(modellayerlocation);
        return chestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    public static ModelLayerLocation createBoatModelName(AspenBoatEntity.Type type) {
        return createLocation("boat/" + type.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(AspenBoatEntity.Type type) {
        return createLocation("chest_boat/" + type.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String path, String model) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(NaturalBiomes.MODID, path), model);
    }

    public Pair<ResourceLocation, net.minecraft.client.model.ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(boat instanceof AspenBoatEntity aspenBoat) {
            return this.boatResources.get(aspenBoat.getModVariant());

        } else if(boat instanceof AspenChestBoatEntity aspenChestBoat) {
            return this.boatResources.get(aspenChestBoat.getBoatVariant());

        } else {
            return null;
        }
    }
}