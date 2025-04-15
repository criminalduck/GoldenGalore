package net.criminalduck.goldengalore.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class GoldenFrenzyEffect extends MobEffect {

    public GoldenFrenzyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);

        this.addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                "61e97eac-4b19-4c2c-98a9-83cb5270eb3b",
                -0.15f,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        /*
        if(pLivingEntity.verticalCollisionBelow) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 2));
        }

         */
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
