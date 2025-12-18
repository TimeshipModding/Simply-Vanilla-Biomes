package com.timeshipmodding.vanillabiomes.datagen;

import com.timeshipmodding.vanillabiomes.content.infrastructure.tags.registries.ModItemTags;
import com.timeshipmodding.vanillabiomes.content.item.registries.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

import static com.timeshipmodding.vanillabiomes.content.block.registries.ModBlocks.*;
import static com.timeshipmodding.vanillabiomes.content.item.registries.ModItems.*;

public class DataRecipes extends RecipeProvider implements IConditionBuilder {
    public DataRecipes(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(packOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Aspen Block and Item Set
        planksFromLogs(recipeOutput, ASPEN_PLANKS, ModItemTags.ASPEN_LOGS, 4);
        woodFromLogs(recipeOutput, ASPEN_WOOD, ASPEN_LOG);
        woodFromLogs(recipeOutput, STRIPPED_ASPEN_WOOD, STRIPPED_ASPEN_LOG);
        stairBuilder(ASPEN_STAIRS, Ingredient.of(ASPEN_PLANKS)).unlockedBy(getHasName(ASPEN_PLANKS), has(ASPEN_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ASPEN_SLAB.get(), ASPEN_PLANKS.get());
        fenceBuilder(ASPEN_FENCE, Ingredient.of(ASPEN_PLANKS)).unlockedBy(getHasName(ASPEN_PLANKS), has(ASPEN_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ASPEN_FENCE_GATE, Ingredient.of(ASPEN_PLANKS)).unlockedBy(getHasName(ASPEN_PLANKS), has(ASPEN_PLANKS)).save(recipeOutput);
        doorBuilder(ASPEN_DOOR, Ingredient.of(ASPEN_PLANKS)).unlockedBy(getHasName(ASPEN_PLANKS), has(ASPEN_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ASPEN_TRAPDOOR, Ingredient.of(ASPEN_PLANKS)).unlockedBy(getHasName(ASPEN_PLANKS), has(ASPEN_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, ASPEN_PRESSURE_PLATE, ASPEN_PLANKS);
        buttonBuilder(ASPEN_BUTTON, Ingredient.of(ASPEN_PLANKS)).unlockedBy(getHasName(ASPEN_PLANKS), has(ASPEN_PLANKS)).save(recipeOutput);
        signBuilder(ModItems.ASPEN_SIGN, Ingredient.of(ASPEN_PLANKS)).unlockedBy(getHasName(ASPEN_PLANKS), has(ASPEN_PLANKS)).save(recipeOutput);
        hangingSign(recipeOutput, ModItems.ASPEN_HANGING_SIGN, ASPEN_PLANKS);
        woodenBoat(recipeOutput, ASPEN_BOAT, ASPEN_PLANKS);
        chestBoat(recipeOutput, ASPEN_CHEST_BOAT, ASPEN_BOAT);
    }
}