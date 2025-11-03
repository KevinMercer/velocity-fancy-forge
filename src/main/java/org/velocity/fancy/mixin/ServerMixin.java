package org.velocity.fancy.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.velocity.fancy.VelocityFancy;

@Mixin(MinecraftServer.class)
public class ServerMixin {

    @Inject(method = "runServer", at = {@At(value = "HEAD")})
    public void init(CallbackInfo ci) {
        VelocityFancy.LOGGER.info("hello mod!");
    }

}
