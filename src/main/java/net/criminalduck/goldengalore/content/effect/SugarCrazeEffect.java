package net.criminalduck.goldengalore.content.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class SugarCrazeEffect extends MobEffect {

    public SugarCrazeEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);

        this.addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                "d55837e0-3ee6-47bd-ae5a-78a60f1c2288",
                0.4f,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );
        this.addAttributeModifier(Attributes.ATTACK_SPEED,
                "c5d70ff6-6120-4b26-9680-23006a351403",
                0.5f,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );
    }

    @Override
    public void addAttributeModifiers(LivingEntity pEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.addAttributeModifiers(pEntity, pAttributeMap, pAmplifier);
        if (!pEntity.level().isClientSide()) {
            pEntity.setAbsorptionAmount(pEntity.getAbsorptionAmount() + (float)(2 * (pAmplifier + 1)));
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity pEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pEntity, pAttributeMap, pAmplifier);
        if (!pEntity.level().isClientSide()) {
            pEntity.setAbsorptionAmount(pEntity.getAbsorptionAmount() - (float)(2 * (pAmplifier + 1)));
            pEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60 * (pAmplifier + 1), (pAmplifier < 5) ? 0 : 2));
            pEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20 * pAmplifier, (pAmplifier < 5) ? 0 : 2));
        }
    }
}
