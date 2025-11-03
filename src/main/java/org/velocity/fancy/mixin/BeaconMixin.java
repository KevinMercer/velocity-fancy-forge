package org.velocity.fancy.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import javax.annotation.Nullable;

@Mixin(BeaconBlockEntity.class)
public class BeaconMixin {

    @ModifyVariable(method = "applyEffects", at = @At(value = "STORE", ordinal = 0), ordinal = 0
    )
    private static double modifyBeaconRange(double d0, Level level, BlockPos pos, int beaconLevel, @Nullable Holder<MobEffect> primaryEffect, @Nullable Holder<MobEffect> secondaryEffect) {
        return beaconLevel * 24 + 32;
    }

}
