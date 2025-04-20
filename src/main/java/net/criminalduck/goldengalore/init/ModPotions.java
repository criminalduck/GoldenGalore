package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, GoldenGaloreMod.MODID);

    public static final RegistryObject<Potion> GOLDEN_FRENZY_POTION = POTIONS.register("gg_golden_frenzy_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.GOLDEN_FRENZY.get(), 1800, 0)));
    public static final RegistryObject<Potion> GOLDEN_CORRUPTION_POTION = POTIONS.register("gg_golden_corruption_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.GOLDEN_CORRUPTION.get(), 1800, 0)));
    public static final RegistryObject<Potion> SUGAR_CRAZE_POTION = POTIONS.register("gg_sugar_craze_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.SUGAR_CRAZE.get(), 400, 0)));
    public static final RegistryObject<Potion> MIDAS_TOUCH_POTION = POTIONS.register("gg_midas_touch_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.MIDAS_TOUCH.get(), 900, 0)));
}
