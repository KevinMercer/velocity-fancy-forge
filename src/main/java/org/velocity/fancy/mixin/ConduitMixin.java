package org.velocity.fancy.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ConduitBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;
import java.util.Optional;

@Mixin(ConduitBlockEntity.class)
public class ConduitMixin {

    @ModifyVariable(method = "applyEffects", at = @At(value = "STORE"), ordinal = 1)
    private static int modifyConduitRange(int j, Level level, BlockPos pos, List<BlockPos> positions) {
        int size = Optional.ofNullable(positions).map(List::size).orElse(0);
        return size / 7 * 32;
    }

}
