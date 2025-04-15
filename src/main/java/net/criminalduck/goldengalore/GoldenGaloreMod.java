package net.criminalduck.goldengalore;

import com.mojang.logging.LogUtils;
import net.criminalduck.goldengalore.client.render.CrownRenderer;
import net.criminalduck.goldengalore.events.ModEvents;
import net.criminalduck.goldengalore.init.ModBlocks;
import net.criminalduck.goldengalore.init.ModCreativeTabs;
import net.criminalduck.goldengalore.init.ModItems;
import net.criminalduck.goldengalore.init.ModMobEffects;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.type.capability.ICurio;

@Mod(GoldenGaloreMod.MODID)
public class GoldenGaloreMod
{
    public static final String MODID = "goldengalore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GoldenGaloreMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModMobEffects.MOB_EFFECTS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
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
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MIDAS_CROWN);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.GOLDEN_SUGAR_BLOCK);
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
            CuriosRendererRegistry.register(ModItems.MIDAS_CROWN.get(), CrownRenderer::new);
        }
    }
}
