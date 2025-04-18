package net.criminalduck.goldengalore.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

public class GoldDustEmitterBlock extends Block {
    public GoldDustEmitterBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (random.nextFloat() < 0.5f) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + random.nextDouble();

            level.addParticle(
                    new DustParticleOptions(new Vector3f(1.0f, 0.84f, 0.0f), 1.0f),
                    x, y, z,
                    0.0, 0.01, 0.0
            );
        }
    }
}
