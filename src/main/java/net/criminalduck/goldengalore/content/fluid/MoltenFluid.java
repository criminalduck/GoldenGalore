package net.criminalduck.goldengalore.content.fluid;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class MoltenFluid extends LiquidBlock {
    public MoltenFluid(Supplier<? extends FlowingFluid> fluid, BlockBehaviour.Properties properties) {
        super(fluid, properties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pLevel.isClientSide) return;
        if (!pEntity.fireImmune()) {
            pEntity.setSecondsOnFire(5);
            if (!(pEntity instanceof LivingEntity)) {
                CompoundTag tag = pEntity.getPersistentData();
                if (!tag.getBoolean("burn_molten_gold")) {
                    tag.putBoolean("burn_molten_gold", true);
                    GoldenGaloreMod.LOGGER.info("playing sound");
                    pLevel.playSound(null, pPos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 0.4f, 2.0f);
                }
            }
        }
    }
}