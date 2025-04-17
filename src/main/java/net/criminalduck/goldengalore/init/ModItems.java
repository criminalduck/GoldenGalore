package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.item.CrownItem;
import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.armour_material.MidasArmourMaterial;
import net.criminalduck.goldengalore.item.PotatoItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoldenGaloreMod.MODID);

    public static final RegistryObject<Item> GOLDEN_WHEAT = ITEMS.register("golden_wheat",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDEN_BREAD = ITEMS.register("golden_bread",
            () -> new Item(new Item.Properties().food(ModFoods.GOLDEN_BREAD)));
    public static final RegistryObject<Item> GOLDEN_SUGAR = ITEMS.register("golden_sugar",
            () -> new Item(new Item.Properties().food(ModFoods.GOLDEN_SUGAR)));
    public static final RegistryObject<Item> GOLDEN_POTATO = ITEMS.register("golden_potato",
            () -> new PotatoItem(new Item.Properties().food(ModFoods.GOLDEN_POTATO)));
    public static final RegistryObject<Item> GOLDEN_BEETROOT = ITEMS.register("golden_beetroot",
            () -> new Item(new Item.Properties().food(ModFoods.GOLDEN_BEETROOT)));

    // ARMOUR
    public static final RegistryObject<Item> MIDAS_CROWN = ITEMS.register("midas_crown",
            () -> new CrownItem(MidasArmourMaterial.MIDAS_ARMOUR, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).fireResistant(), ModMobEffects.GOLDEN_PROTECTION.get()));


    // FOODS Properties
    public static class ModFoods {
        public static final FoodProperties GOLDEN_BREAD = new FoodProperties.Builder().nutrition(12).saturationMod(14.4f).build();
        public static final FoodProperties GOLDEN_SUGAR = new FoodProperties.Builder().nutrition(1).fast().effect(() -> new MobEffectInstance(ModMobEffects.SUGAR_CRAZE.get(), 200, 0), 1f).build();
        public static final FoodProperties GOLDEN_SUGAR_BLOCK = new FoodProperties.Builder().nutrition(1).effect(() -> new MobEffectInstance(ModMobEffects.SUGAR_CRAZE.get(), 800, 9), 1f).build();
        public static final FoodProperties GOLDEN_POTATO = new FoodProperties.Builder().nutrition(6).saturationMod(3f).build();
        public static final FoodProperties GOLDEN_BEETROOT = new FoodProperties.Builder().nutrition(3).saturationMod(1f).build();

        // not in use
        public static final FoodProperties.Builder GOLDEN_MUSHROOM = new FoodProperties.Builder().nutrition(2).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 60, 3), 1.0f);
        public static final FoodProperties.Builder GOLDEN_MUSHROOM_STEW = new FoodProperties.Builder().nutrition(6).saturationMod(8f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 100, 2), 1.0f);
        public static final FoodProperties.Builder GOLDEN_KELP = new FoodProperties.Builder().nutrition(3).saturationMod(1f);
        public static final FoodProperties.Builder GOLDEN_ROTTEN_FLESH = new FoodProperties.Builder().nutrition(6).saturationMod(2f).meat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 160, 2), 0.9f)
                .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 4), 0.9f).effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 2), 0.9f);
        public static final FoodProperties.Builder GOLDEN_MELON_SLICE = new FoodProperties.Builder().nutrition(4).saturationMod(2f);
        public static final FoodProperties.Builder GOLDEN_PORKCHOP = new FoodProperties.Builder().nutrition(10).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_BEEF = new FoodProperties.Builder().nutrition(11).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_CHICKEN = new FoodProperties.Builder().nutrition(8).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_MUTTON = new FoodProperties.Builder().nutrition(8).saturationMod(4f);
        public static final FoodProperties.Builder GOLDEN_RABBIT = new FoodProperties.Builder().nutrition(7).saturationMod(3f);
        public static final FoodProperties.Builder GOLDEN_COD = new FoodProperties.Builder().nutrition(7).saturationMod(3f);
        public static final FoodProperties.Builder GOLDEN_SALMON = new FoodProperties.Builder().nutrition(7).saturationMod(3f);
        public static final FoodProperties.Builder GOLDEN_COOKIE = new FoodProperties.Builder().nutrition(12).saturationMod(16f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 800, 1), 1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 140, 2), 1.0f).alwaysEat();
        public static final FoodProperties.Builder GOD_COOKIE = new FoodProperties.Builder().nutrition(12).saturationMod(16f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1600, 2), 1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 2), 1.0f).alwaysEat();
        public static final FoodProperties.Builder GOLDEN_PUMPKIN_PIE = new FoodProperties.Builder().nutrition(10).saturationMod(4f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 160, 2),1.0f );
        public static final FoodProperties.Builder GOLDEN_BERRIES = new FoodProperties.Builder().nutrition(4).saturationMod(2f);
    }
}
