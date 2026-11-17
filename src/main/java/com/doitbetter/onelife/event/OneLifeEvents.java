package com.doitbetter.onelife.event;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.minecraft.util.ActionResult;

public class OneLifeEvents {

    public static void register() {
        EntitySleepEvents.ALLOW_BED.register((entity, sleepingPos, state, vanillaResult) -> {
            return ActionResult.SUCCESS;
        });

        EntitySleepEvents.ALLOW_SLEEPING.register((player, sleepingPos) -> {
            return null;
        });

        EntitySleepEvents.ALLOW_RESETTING_TIME.register(player -> false);

        EntitySleepEvents.ALLOW_SLEEP_TIME.register((player, sleepingPos, vanillaResult) -> {
            return ActionResult.SUCCESS;
        });
    }
}
