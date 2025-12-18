package com.timeshipmodding.vanillabiomes.event;

import com.timeshipmodding.vanillabiomes.VanillaBiomes;
import com.timeshipmodding.vanillabiomes.content.block.entity.registries.ModBlockEntities;
import com.timeshipmodding.vanillabiomes.content.entity.client.registries.ModModelLayers;
import com.timeshipmodding.vanillabiomes.content.entity.client.renderers.AspenBoatRenderer;
import com.timeshipmodding.vanillabiomes.content.entity.registries.ModEntities;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = VanillaBiomes.MODID, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.ASPEN_SIGN_BLOCKENTITY.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.ASPEN_HANGING_SIGN_BLOCKENTITY.get(), HangingSignRenderer::new);
        event.registerEntityRenderer(ModEntities.ASPEN_BOAT.get(), context -> new AspenBoatRenderer(context, false));
        event.registerEntityRenderer(ModEntities.ASPEN_CHEST_BOAT.get(), context -> new AspenBoatRenderer(context, true));
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ASPEN_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.ASPEN_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }
}