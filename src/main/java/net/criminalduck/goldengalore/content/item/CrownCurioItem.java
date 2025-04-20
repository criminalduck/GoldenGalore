package net.criminalduck.goldengalore.content.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CrownCurioItem extends CrownItem implements ICurioItem {
    public CrownCurioItem(ArmorMaterial pMaterial, Type pType, Properties pProperties, MobEffect pConstantEffect, MobEffect pRandomEffect, int[] pTimerBounds) {
        super(pMaterial, pType, pProperties, pConstantEffect, pRandomEffect, pTimerBounds);
    }

    @Override
    public void onEquip(SlotContext pSlotContext, ItemStack pPrevStack, ItemStack pStack) {
        if (!(pSlotContext.entity() instanceof Player player) || player.level().isClientSide) return;

        effectAdd(player, constantEffect, false);

        CompoundTag tag = player.getPersistentData();
        if (!tag.contains("midas_timer")) {
            createData(player, tag, tag.getCompound("midas_timer"));
        }
    }

    @Override
    public void onUnequip(SlotContext pSlotContext, ItemStack pPrevStack, ItemStack pStack) {
        if (!(pSlotContext.entity() instanceof Player player) || player.level().isClientSide) return;
        handleUnequip(player);
    }

    @Override
    public void curioTick(SlotContext pSlotContext, ItemStack pStack) {
        if (!(pSlotContext.entity() instanceof Player player) || player.level().isClientSide) return;
        effectAdd(player, constantEffect, false);
        handleMidasEffect(player);
    }
}
