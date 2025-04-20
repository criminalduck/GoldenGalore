package net.criminalduck.goldengalore.content.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CrownItem extends ArmorItem {
    MobEffect constantEffect;
    MobEffect randomEffect;
    int[] timerBounds;

    public CrownItem(ArmorMaterial pMaterial, Type pType, Properties pProperties, MobEffect pConstantEffect, MobEffect pRandomEffect, int[] pTimerBounds) {
        super(pMaterial, pType, pProperties);
        constantEffect = pConstantEffect;
        randomEffect = pRandomEffect;
        timerBounds = new int[] {pTimerBounds[0] * 60 * 20, pTimerBounds[0] * 60 * 20};
    }

    @Override
    public void onInventoryTick(ItemStack pStack, Level pLevel, Player pPlayer, int pSlotIndex, int pSelectedIndex) {
        super.onInventoryTick(pStack, pLevel, pPlayer, pSlotIndex, pSelectedIndex);
        if (!pLevel.isClientSide) return;

        if (pPlayer.getItemBySlot(EquipmentSlot.HEAD).getItem() != this) {
            handleUnequip(pPlayer);
            return;
        }

        effectAdd(pPlayer, constantEffect, false);

        handleMidasEffect(pPlayer);
    }

    void handleUnequip(Player pPlayer) {
        effectRemove(pPlayer, constantEffect);
        effectRemove(pPlayer, randomEffect);
        if (pPlayer.getPersistentData().contains("midas_timer"))
            pPlayer.getPersistentData().remove("midas_timer");
    }

    void handleMidasEffect(Player pPlayer) {
        CompoundTag tag = pPlayer.getPersistentData();
        CompoundTag data = initialiseData(pPlayer, tag);
        if (data == null) return;

        int ticks = data.getInt("MidasTimer");
        int target = data.getInt("MidasTargetTime");

        if (target == 0) {
            // target = 60 + pPlayer.getRandom().nextInt(541);
            target = timerBounds[0] + pPlayer.getRandom().nextInt(timerBounds[1] - timerBounds[0] + 1);
            data.putInt("MidasTargetTime", target);
            data.putInt("MidasTimer", 0);
            tag.put("midas_timer", data);
            return;
        }

        ticks++;
        data.putInt("MidasTimer", ticks);
        tag.put("midas_timer", data);

        if (ticks >= target) {
            effectAdd(pPlayer, randomEffect, true);
        }
    }

    CompoundTag initialiseData(Player pPlayer, CompoundTag tag) {
        if (tag.contains("midas_timer")) {
            CompoundTag data = tag.getCompound("midas_timer");
            createData(pPlayer, tag, data);
            return data;
        }
        return null;
    }

    void createData(Player pPlayer, CompoundTag tag, CompoundTag data) {
        int target = timerBounds[0] + pPlayer.getRandom().nextInt(timerBounds[1] - timerBounds[0] + 1);
        data.putInt("MidasTargetTime", target);
        data.putInt("MidasTimer", 0);
        tag.put("midas_timer", data);
    }

    void effectRemove(Player pPlayer, MobEffect pEffectId) {
        if (pPlayer.hasEffect(pEffectId))
            pPlayer.removeEffect(pEffectId);
    }

    void effectAdd(Player pPlayer, MobEffect pEffectId, boolean pVisible) {
        if (!pPlayer.hasEffect(pEffectId))
            pPlayer.addEffect(new MobEffectInstance(pEffectId, MobEffectInstance.INFINITE_DURATION, 0, false, pVisible, true));

    }
}
