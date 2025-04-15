package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.effect.GoldenFrenzyEffect;
import net.criminalduck.goldengalore.effect.GoldenProtectionEffect;
import net.criminalduck.goldengalore.effect.SugarCrazeEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GoldenGaloreMod.MODID);

    public static final RegistryObject<MobEffect> GOLDEN_FRENZY = MOB_EFFECTS.register("golden_frenzy",
            () -> new GoldenFrenzyEffect(MobEffectCategory.NEUTRAL, Color.ORANGE.getRGB()));

    public static final RegistryObject<MobEffect> SUGAR_CRAZE = MOB_EFFECTS.register("sugar_craze",
            () -> new SugarCrazeEffect(MobEffectCategory.BENEFICIAL, Color.CYAN.getRGB()));

    public static final RegistryObject<MobEffect> GOLDEN_PROTECTION = MOB_EFFECTS.register("golden_protection",
            () -> new GoldenProtectionEffect(MobEffectCategory.BENEFICIAL, Color.ORANGE.getRGB()));
}
