package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoldenGaloreMod.MODID);

    public static final RegistryObject<CreativeModeTab> GOLDENGALORE_TAB = CREATIVE_MODE_TABS.register("goldengalore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOLDEN_BREAD.get()))
                    .title(Component.translatable("creativetab.goldengalore_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GOLDEN_BREAD.get());
                        output.accept(ModItems.GOLDEN_WHEAT.get());
                        output.accept(ModItems.GOLDEN_POTATO.get());
                        output.accept(ModItems.GOLDEN_BEETROOT.get());
                        output.accept(ModItems.GOLDEN_SUGAR.get());
                        output.accept(ModBlocks.GOLDEN_SUGAR_BLOCK.get());
                        output.accept(ModItems.MIDAS_CROWN.get());
                    })
                    .build());
}
