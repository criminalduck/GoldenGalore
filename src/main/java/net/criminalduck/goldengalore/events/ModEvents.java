package net.criminalduck.goldengalore.events;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.init.ModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoldenGaloreMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onArmorChange(LivingEquipmentChangeEvent pEvent) {
        if (!(pEvent.getEntity() instanceof Player player)) return;
        if (!player.level().isClientSide()) {
            if (isWearingFullGold(player)) {
                player.addEffect(new MobEffectInstance(ModMobEffects.GOLDEN_PROTECTION.get(), MobEffectInstance.INFINITE_DURATION, 0, false, false, true));
            } else {
                player.removeEffect(ModMobEffects.GOLDEN_PROTECTION.get());
            }
        }
    }

    public static boolean isWearingFullGold(Player pPlayer) {
        return isGoldArmor(pPlayer.getItemBySlot(EquipmentSlot.HEAD)) &&
                isGoldArmor(pPlayer.getItemBySlot(EquipmentSlot.CHEST)) &&
                isGoldArmor(pPlayer.getItemBySlot(EquipmentSlot.LEGS)) &&
                isGoldArmor(pPlayer.getItemBySlot(EquipmentSlot.FEET));
    }

    private static boolean isGoldArmor(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem armor && armor.getMaterial() == ArmorMaterials.GOLD;
    }
}
