package net.criminalduck.goldengalore.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

public class DustEmitterBlock extends Block {
    private static Vector3f colour;

    public DustEmitterBlock(Properties pProperties, Vector3f pRGB) {
        super(pProperties);
        colour = pRGB;
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
                    new DustParticleOptions(colour, 1.0f),
                    x, y, z,
                    0.0, 0.01, 0.0
            );
        }
    }
}
