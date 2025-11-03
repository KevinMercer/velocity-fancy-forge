package org.velocity.fancy.potions;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nonnull;

public class ImmersiveSneakyPotion {

    @SubscribeEvent()
    public void immersiveSneaky(LivingEvent.LivingVisibilityEvent visibilityEvent) {
        if (visibilityEvent.getEntity() instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.hasEffect(MobEffects.INVISIBILITY)) {
                visibilityEvent.modifyVisibility(0.0);
            }
        }
    }

    @SubscribeEvent
    public void loseSight(LivingChangeTargetEvent livingChangeTargetEvent) {
        if (livingChangeTargetEvent.getEntity() instanceof Monster monster && !(monster instanceof Warden) && livingChangeTargetEvent.getNewTarget() instanceof ServerPlayer serverPlayer && serverPlayer.hasEffect(MobEffects.INVISIBILITY)) {
            if (checkUnequipped(serverPlayer)) {
                livingChangeTargetEvent.setCanceled(true);
            }
        }
    }

    private boolean checkUnequipped(@Nonnull ServerPlayer serverPlayer) {
        // 快速检查主手和副手
        if (!serverPlayer.getMainHandItem().isEmpty() || !serverPlayer.getOffhandItem().isEmpty()) {
            return false;
        }

        // 检查盔甲槽
        for (ItemStack armor : serverPlayer.getArmorSlots()) {
            if (!armor.isEmpty()) {
                return false;
            }
        }

        return true;
    }

}
