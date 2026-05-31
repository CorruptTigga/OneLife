package com.doitbetter.onelife.mixin.dimension;

import com.doitbetter.onelife.util.OneLifeLogger;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

@Mixin(NetherPortal.class)
public class MixinNetherPortal {

    @Shadow @Final private BlockPos lowerCorner;

    @Inject(
            method = "createPortal",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onelife$preventPortalCreation(WorldAccess world, CallbackInfo ci) {
        OneLifeLogger.logAndIntercept(
                "NetherPortal",
                "Portal creation blocked at " + this.lowerCorner,
                true
        );

        world.getPlayers().forEach(player -> {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                double dx = serverPlayer.getX() - lowerCorner.getX();
                double dy = serverPlayer.getY() - lowerCorner.getY();
                double dz = serverPlayer.getZ() - lowerCorner.getZ();
                if (dx * dx + dy * dy + dz * dz < 16 * 16) {
                    serverPlayer.sendMessage(
                            Text.translatable("onelife.dimension.nether_locked"),
                            true
                    );
                }
            }
        });

        ci.cancel();
    }
}