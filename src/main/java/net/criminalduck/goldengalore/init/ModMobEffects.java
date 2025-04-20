package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.content.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GoldenGaloreMod.MODID);

    public static final RegistryObject<MobEffect> GOLDEN_FRENZY = MOB_EFFECTS.register("golden_frenzy_effect",
            () -> new GoldenFrenzyEffect(MobEffectCategory.BENEFICIAL, Color.ORANGE.getRGB()));

    public static final RegistryObject<MobEffect> GOLDEN_CORRUPTION = MOB_EFFECTS.register("golden_corruption_effect",
            () -> new GoldenCorruptionEffect(MobEffectCategory.HARMFUL, Color.ORANGE.getRGB()));

    public static final RegistryObject<MobEffect> SUGAR_CRAZE = MOB_EFFECTS.register("sugar_craze_effect",
            () -> new SugarCrazeEffect(MobEffectCategory.BENEFICIAL, Color.CYAN.getRGB()));

    public static final RegistryObject<MobEffect> GOLDEN_PROTECTION = MOB_EFFECTS.register("golden_protection_effect",
            () -> new GoldenProtectionEffect(MobEffectCategory.BENEFICIAL, Color.ORANGE.getRGB()));

    public static final RegistryObject<MobEffect> MIDAS_TOUCH = MOB_EFFECTS.register("midas_touch_effect",
            () -> new MidasTouchEffect(MobEffectCategory.NEUTRAL, Color.ORANGE.getRGB()));
}
