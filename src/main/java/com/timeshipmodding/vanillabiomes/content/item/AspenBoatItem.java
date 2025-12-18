package com.timeshipmodding.vanillabiomes.content.item;

import com.timeshipmodding.vanillabiomes.content.entity.AspenBoatEntity;
import com.timeshipmodding.vanillabiomes.content.entity.AspenChestBoatEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class AspenBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final AspenBoatEntity.Type type;
    private final boolean hasChest;

    public AspenBoatItem(boolean hasChest, AspenBoatEntity.Type type, Item.Properties properties) {
        super(properties);
        this.hasChest = hasChest;
        this.type = type;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        HitResult result = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);

        if (result.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(stack);

        } else {
            Vec3 vec3 = player.getViewVector(1.0F);
            List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);

            if (!list.isEmpty()) {
                Vec3 vec31 = player.getEyePosition();

                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());

                    if (aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(stack);
                    }
                }
            }

            if (result.getType() == HitResult.Type.BLOCK) {
                Boat boat = this.getBoat(level, result);

                if(boat instanceof AspenChestBoatEntity chestBoat) {
                    chestBoat.setVariant(this.type);

                } else if(boat instanceof AspenBoatEntity) {
                    ((AspenBoatEntity)boat).setVariant(this.type);
                }

                boat.setYRot(player.getYRot());

                if (!level.noCollision(boat, boat.getBoundingBox())) {
                    return InteractionResultHolder.fail(stack);

                } else {
                    if (!level.isClientSide) {
                        level.addFreshEntity(boat);
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, result.getLocation());

                        if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
                }

            } else {
                return InteractionResultHolder.pass(stack);
            }
        }
    }

    private Boat getBoat(Level level, HitResult result) {
        return (this.hasChest ? new AspenChestBoatEntity(level, result.getLocation().x, result.getLocation().y, result.getLocation().z) :
                new AspenBoatEntity(level, result.getLocation().x, result.getLocation().y, result.getLocation().z));
    }
}