package net.criminalduck.goldengalore.content.item;

import net.criminalduck.goldengalore.init.ModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GoldFood extends Item {
    private static int[] chances;

    public GoldFood(Properties pProperties, int[] pChances) {
        super(pProperties);
        chances = pChances;
    }

    public GoldFood(Properties pProperties) {
        super(pProperties);
        chances = new int[] {5, 3, 1, 1};
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntity) {
        if (!pLevel.isClientSide) {
            int result = weightedRoll(pLevel, chances[0], chances[1], chances[2], chances[3]);
            switch (result) {
                case 0 -> pEntity.addEffect(new MobEffectInstance(ModMobEffects.GOLDEN_FRENZY.get(), 600, 0));
                case 1 -> pEntity.addEffect(new MobEffectInstance(ModMobEffects.GOLDEN_CORRUPTION.get(), 600, 0));
                case 2 -> {}
            }
        }
        return super.finishUsingItem(pStack, pLevel, pEntity);
    }

    private static int weightedRoll(Level pLevel, int pTotal, int... pChances) {
        int roll = pLevel.random.nextInt(pTotal);
        int cumulative = 0;

        for (int i = 0; i < pChances.length; i++) {
            cumulative += pChances[i];
            if (roll < cumulative) return i;
        }
        return -1;
    }
}
