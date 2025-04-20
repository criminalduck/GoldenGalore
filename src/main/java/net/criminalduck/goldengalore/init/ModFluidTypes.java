package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.content.fluid.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GoldenGaloreMod.MODID);

    public static final RegistryObject<FluidType> MOLTEN_GOLD_FLUID_TYPE = FLUID_TYPES.register("molten_gold_fluid",
            () -> new BaseFluidType(
                    new ResourceLocation("goldengalore:block/molten_gold_still"),
                    new ResourceLocation("goldengalore:block/molten_gold_flow"),
                    new ResourceLocation("goldengalore:misc/molten_gold_overlay"),
                    0xFFD700, // 0xE6BE00
                    new Vector3f(0.85f, 0.65f, 0.1f), // dark:0.902f, 0.745f, 0.0f light:1.0f, 0.843f, 0.0f
                    FluidType.Properties.create().lightLevel(8).density(1000).viscosity(600).temperature(1300).canConvertToSource(false).supportsBoating(false)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.LAVA_EXTINGUISH)
                            .canDrown(false).canHydrate(false)
            )
    );
}
