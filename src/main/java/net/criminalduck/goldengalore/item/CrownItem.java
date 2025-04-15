package net.criminalduck.goldengalore.item;

import net.criminalduck.goldengalore.init.ModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CrownItem extends ArmorItem implements ICurioItem {
    private static MobEffect effect;

    public CrownItem(ArmorMaterial pMaterial, Type pType, Properties pProperties, MobEffect pMobEffect) {
        super(pMaterial, pType, pProperties);
        effect = pMobEffect;
    }

    // Armour Handling
    @Override
    public void onArmorTick(ItemStack pStack, Level pLevel, Player pPlayer) {
        if (!pLevel.isClientSide) {
            if (pPlayer.getItemBySlot(EquipmentSlot.HEAD).getItem() == this) {
                pPlayer.addEffect(new MobEffectInstance(effect, MobEffectInstance.INFINITE_DURATION, 0, false, false, true));
            } else {
                pPlayer.removeEffect(effect);
            }
        }
    }

    // Curio Handling
    @Override
    public void onEquip(String pIdentifier, int pIndex, LivingEntity pLivingEntity, ItemStack pStack) {
        if (!pLivingEntity.level().isClientSide) {
            pLivingEntity.addEffect(new MobEffectInstance(effect, MobEffectInstance.INFINITE_DURATION, 0, false, false, true));
        }
    }
    @Override
    public void onUnequip(String pIdentifier, int pIndex, LivingEntity pLivingEntity, ItemStack pStack) {
        if (!pLivingEntity.level().isClientSide) {
            pLivingEntity.removeEffect(effect);
        }
    }
}
