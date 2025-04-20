package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoldenGaloreMod.MODID);

    public static final RegistryObject<CreativeModeTab> GOLDENGALORE_TAB = CREATIVE_MODE_TABS.register("goldengalore_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GOLDEN_BREAD.get()))
                    .title(Component.translatable("creativetab.goldengalore_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.GOLD_CHISELED_BLOCK.get());
                        output.accept(ModBlocks.GOLD_PILLAR.get());
                        output.accept(ModBlocks.GOLD_BRICKS.get());
                        output.accept(ModBlocks.GOLD_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GOLD_STAIRS.get());
                        output.accept(ModBlocks.GOLD_BRICK_SLAB.get());
                        output.accept(ModBlocks.GOLD_SLAB.get());
                        output.accept(ModBlocks.GOLD_BRICK_WALL.get());
                        output.accept(ModBlocks.GOLD_WALL.get());
                        output.accept(ModBlocks.GOLD_DOOR.get());
                        output.accept(ModBlocks.GOLD_TRAPDOOR.get());
                        output.accept(ModBlocks.GOLD_BUTTON.get());
                        output.accept(ModItems.GOLDEN_BREAD.get());
                        output.accept(ModItems.GOLDEN_WHEAT.get());
                        output.accept(ModItems.GOLDEN_POTATO.get());
                        output.accept(ModItems.GOLDEN_BEETROOT.get());
                        output.accept(ModItems.GOLDEN_SUGAR.get());
                        output.accept(ModBlocks.GOLDEN_SUGAR_BLOCK.get());
                        output.accept(ModItems.GOLDEN_RABBITS_FOOT.get());
                        output.accept(ModItems.GOLDEN_SPIDER_EYE.get());
                        output.accept(ModItems.GOLDEN_GHAST_TEAR.get());
                        output.accept(ModItems.SOLID_GOLD_BUCKET.get());
                        output.accept(ModItems.MOLTEN_GOLD_BUCKET.get());
                        output.accept(ModItems.MIDAS_CROWN.get());
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), ModPotions.SUGAR_CRAZE_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), ModPotions.GOLDEN_FRENZY_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), ModPotions.GOLDEN_CORRUPTION_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), ModPotions.MIDAS_TOUCH_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.SUGAR_CRAZE_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.SUGAR_CRAZE_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.SUGAR_CRAZE_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.GOLDEN_FRENZY_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.GOLDEN_FRENZY_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.GOLDEN_FRENZY_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.GOLDEN_CORRUPTION_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.GOLDEN_CORRUPTION_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.GOLDEN_CORRUPTION_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.MIDAS_TOUCH_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.MIDAS_TOUCH_POTION.get()));
                        output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.MIDAS_TOUCH_POTION.get()));
                    })
                    .build());
}
