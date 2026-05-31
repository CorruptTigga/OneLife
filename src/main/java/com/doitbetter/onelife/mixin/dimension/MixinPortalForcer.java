package com.doitbetter.onelife.mixin.dimension;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockLocating;
import net.minecraft.world.dimension.PortalForcer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PortalForcer.class)
public class MixinPortalForcer {

    /**
     * Prevents the server from searching for or creating a destination portal
     * on the other side of a Nether transition. Returns empty so the teleport
     * never completes even if a portal entity somehow exists in the world.
     */
    @Inject(method = "createPortal", at = @At("HEAD"), cancellable = true)
    private void onelife$preventPortalDestination(BlockPos pos, Direction.Axis axis, CallbackInfoReturnable<Optional<BlockLocating.Rectangle>> cir) {
        cir.setReturnValue(Optional.empty());
    }
}
