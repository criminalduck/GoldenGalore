package net.criminalduck.goldengalore.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class GoldenProtectionEffect extends MobEffect {

    public GoldenProtectionEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);

        this.addAttributeModifier(
                Attributes.ARMOR,
                "8a4d8360-39b7-49e7-8ac6-9759b9f966b5",
                4,
                AttributeModifier.Operation.ADDITION
        );
        this.addAttributeModifier(
                Attributes.KNOCKBACK_RESISTANCE,
                "7618edbd-4ae5-4074-82dc-07f0dd89729e",
                0.1f,
                AttributeModifier.Operation.ADDITION
        );
        this.addAttributeModifier(
            Attributes.MAX_HEALTH,
                "27992de1-b866-4999-8a8b-7b4595dec725",
                4.0F,
                AttributeModifier.Operation.ADDITION
        );
    }

    @Override
    public void addAttributeModifiers(LivingEntity pEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.addAttributeModifiers(pEntity, pAttributeMap, pAmplifier);
        if (!pEntity.level().isClientSide()) {
            pEntity.setAbsorptionAmount(pEntity.getAbsorptionAmount() + (float)(4 * (pAmplifier + 1)));
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity pEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pEntity, pAttributeMap, pAmplifier);
        if (!pEntity.level().isClientSide()) {
            pEntity.setAbsorptionAmount(pEntity.getAbsorptionAmount() - (float)(4 * (pAmplifier + 1)));
        }
    }
}
