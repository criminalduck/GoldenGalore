package net.criminalduck.goldengalore;

import com.mojang.logging.LogUtils;
import net.criminalduck.goldengalore.events.ModEvents;
import net.criminalduck.goldengalore.init.*;
import net.criminalduck.goldengalore.util.ModBrewingRecipe;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GoldenGaloreMod.MODID)
public class GoldenGaloreMod
{
    public static final String MODID = "goldengalore";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GoldenGaloreMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModMobEffects.MOB_EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        ModFluidTypes.FLUID_TYPES.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                    Potions.AWKWARD, ModItems.GOLDEN_RABBITS_FOOT.get(),  ModPotions.GOLDEN_FRENZY_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                    Potions.AWKWARD, ModItems.GOLDEN_SPIDER_EYE.get(),  ModPotions.GOLDEN_CORRUPTION_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                    Potions.AWKWARD, ModItems.GOLDEN_SUGAR.get(),  ModPotions.SUGAR_CRAZE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(
                    Potions.AWKWARD, ModItems.GOLDEN_GHAST_TEAR.get(),  ModPotions.MIDAS_TOUCH_POTION.get()));
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.GOLDEN_BREAD);
            event.accept(ModItems.GOLDEN_SUGAR);
            event.accept(ModBlocks.GOLDEN_SUGAR_BLOCK);
            event.accept(ModItems.GOLDEN_POTATO);
            event.accept(ModItems.GOLDEN_BEETROOT);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.GOLDEN_WHEAT);
            event.accept(ModItems.GOLDEN_SUGAR);
            event.accept(ModItems.GOLDEN_SPIDER_EYE);
            event.accept(ModItems.GOLDEN_RABBITS_FOOT);
            event.accept(ModItems.GOLDEN_GHAST_TEAR);
            event.accept(ModItems.SOLID_GOLD_BUCKET);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MIDAS_CROWN);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.GOLDEN_SUGAR_BLOCK);
            event.accept(ModBlocks.GOLD_CHISELED_BLOCK);
            event.accept(ModBlocks.GOLD_PILLAR);
            event.accept(ModBlocks.GOLD_BRICKS);
            event.accept(ModBlocks.GOLD_BRICKS);
            event.accept(ModBlocks.GOLD_CHISELED_BLOCK);
            event.accept(ModBlocks.GOLD_BRICK_STAIRS);
            event.accept(ModBlocks.GOLD_STAIRS);
            event.accept(ModBlocks.GOLD_BRICK_SLAB);
            event.accept(ModBlocks.GOLD_SLAB);
            event.accept(ModBlocks.GOLD_BRICK_WALL);
            event.accept(ModBlocks.GOLD_WALL);
            event.accept(ModBlocks.GOLD_DOOR);
            event.accept(ModBlocks.GOLD_TRAPDOOR);
            event.accept(ModBlocks.GOLD_BUTTON);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MOLTEN_GOLD_BUCKET);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            if (ModList.get().isLoaded("curios")) {
                try {
                    Class.forName("net.criminalduck.goldengalore.compat.CuriosCompat")
                            .getMethod("registerCurioRenderers")
                            .invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
