package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.armour_material.ModAmourMaterial;
import net.criminalduck.goldengalore.effect.GoldenFrenzyEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModRegisters {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoldenGaloreMod.MODID);

    public static final RegistryObject<Item> GOLDEN_WHEAT = ITEMS.register("golden_wheat",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_BREAD = ITEMS.register("golden_bread",
            () -> new Item(new Item.Properties().food(ModFoods.GOLDEN_BREAD.build())));

    public static final RegistryObject<Item> MIDAS_CROWN = ITEMS.register("midas_crown",
            () -> new ArmorItem(ModAmourMaterial.MIDAS_ARMOUR, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).fireResistant()));


    public static class ModFoods {
        // For effects : time(in ticks 1s = 20), level), probability(f)
        public static final FoodProperties.Builder GOLDEN_BREAD = new FoodProperties.Builder().nutrition(12).saturationMod(14.4f);
        public static final FoodProperties.Builder GOLDEN_MUSHROOM = new FoodProperties.Builder().nutrition(2).effect(new MobEffectInstance(MobEffects.CONFUSION, 60, 3), 1.0f);
        public static final FoodProperties.Builder GOLDEN_MUSHROOM_STEW = new FoodProperties.Builder().nutrition(6).saturationMod(8f).effect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 2), 1.0f);
        public static final FoodProperties.Builder GOLDEN_KELP = new FoodProperties.Builder().nutrition(3).saturationMod(1f);
        public static final FoodProperties.Builder GOLDEN_ROTTEN_FLESH = new FoodProperties.Builder().nutrition(6).saturationMod(2f).meat().effect(new MobEffectInstance(MobEffects.CONFUSION, 160, 2), 0.9f)
                .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 4), 0.9f).effect(new MobEffectInstance(MobEffects.POISON, 200, 2), 0.9f);
        public static final FoodProperties.Builder GOLDEN_MELON_SLICE = new FoodProperties.Builder().nutrition(4).saturationMod(2f);
        public static final FoodProperties.Builder GOLDEN_PORKCHOP = new FoodProperties.Builder().nutrition(10).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_BEEF = new FoodProperties.Builder().nutrition(11).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_CHICKEN = new FoodProperties.Builder().nutrition(8).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_MUTTON = new FoodProperties.Builder().nutrition(8).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_RABBIT = new FoodProperties.Builder().nutrition(7).saturationMod(3f);
        public static final FoodProperties.Builder GOLDEN_COD = new FoodProperties.Builder().nutrition(7).saturationMod(3f);
        public static final FoodProperties.Builder GOLDEN_SALMON = new FoodProperties.Builder().nutrition(7).saturationMod(3f);
        public static final FoodProperties.Builder GOLDEN_COOKIE = new FoodProperties.Builder().nutrition(12).saturationMod(16f).effect(new MobEffectInstance(MobEffects.ABSORPTION, 800, 1), 1.0f)
                .effect(new MobEffectInstance(MobEffects.REGENERATION, 140, 2), 1.0f).alwaysEat();
        public static final FoodProperties.Builder GOD_COOKIE = new FoodProperties.Builder().nutrition(12).saturationMod(16f).effect(new MobEffectInstance(MobEffects.ABSORPTION, 1600, 2), 1.0f)
                .effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 2), 1.0f).alwaysEat();
        public static final FoodProperties.Builder GOLDEN_POTATO = new FoodProperties.Builder().nutrition(6).saturationMod(3f);
        public static final FoodProperties.Builder GOLDEN_PUMPKIN_PIE = new FoodProperties.Builder().nutrition(10).saturationMod(4f).effect(new MobEffectInstance(MobEffects.ABSORPTION, 160, 2),1.0f );
        public static final FoodProperties.Builder GOLDEN_BEETROOT = new FoodProperties.Builder().nutrition(3).saturationMod(1f);
        public static final FoodProperties.Builder GOLDEN_BERRIES = new FoodProperties.Builder().nutrition(4).saturationMod(2f);
        public static final FoodProperties.Builder GOLDEN_SUGAR = new FoodProperties.Builder().nutrition(1).effect(new MobEffectInstance(MobEffects.JUMP, 200, 3), 1.0f)
                .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 2), 1.0f);
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoldenGaloreMod.MODID);

    public static final RegistryObject<CreativeModeTab> GOLDENGALORE_TAB = CREATIVE_MODE_TABS.register("goldengalore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(GOLDEN_BREAD.get()))
                    .title(Component.translatable("creativetab.goldengalore_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(GOLDEN_BREAD.get());
                        output.accept(GOLDEN_WHEAT.get());
                        output.accept(MIDAS_CROWN.get());
                    })
                    .build());

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GoldenGaloreMod.MODID);

    public static final RegistryObject<MobEffect> GOLDEN_FRENZY = MOB_EFFECTS.register("golden_frenzy",
            () -> new GoldenFrenzyEffect(MobEffectCategory.NEUTRAL, Color.ORANGE.getRGB()));
                    // .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(GoldenGaloreMod.MODID, "golden_frenzy"), -0.15f, AttributeModifier.Operation.MULTIPLY_TOTAL));
}
