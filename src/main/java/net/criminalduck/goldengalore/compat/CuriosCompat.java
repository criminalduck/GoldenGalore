package net.criminalduck.goldengalore.compat;

import net.criminalduck.goldengalore.init.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import net.criminalduck.goldengalore.client.render.CrownRenderer;

import java.lang.reflect.Constructor;

public class CuriosCompat {

    @SuppressWarnings("unchecked")
    public static Item createCrown(ArmorMaterial pArmourMaterial, ArmorItem.Type pArmourType, Item.Properties pProperties, MobEffect pConstantEffect, MobEffect pRandomEffect, int[] pTimerBounds) {
        try {
            Class<?> clazz = Class.forName("net.criminalduck.goldengalore.content.item.CrownCurioItem");
            Constructor<?> ctor = clazz.getConstructor(ArmorMaterial.class, ArmorItem.Type.class, Item.Properties.class, MobEffect.class, MobEffect.class, int[].class);
            return (Item) ctor.newInstance(pArmourMaterial, pArmourType, pProperties, pConstantEffect, pRandomEffect, pTimerBounds);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create Curio-compatible Crown", e);
        }
    }

    public static void registerCurioRenderers() {
        CuriosRendererRegistry.register(ModItems.MIDAS_CROWN.get(), CrownRenderer::new);
    }
}
