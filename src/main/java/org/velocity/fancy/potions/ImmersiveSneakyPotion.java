package org.velocity.fancy.potions;


import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

public class ImmersiveSneakyPotion {


    public ImmersiveSneakyPotion() {

    }

    @SubscribeEvent
    public void immersiveSneaky(LivingEvent.LivingVisibilityEvent visibilityEvent) {
        if (visibilityEvent.getEntity() instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.hasEffect(MobEffects.INVISIBILITY)) {
                visibilityEvent.modifyVisibility(0.0);
            }
        }
    }

}
