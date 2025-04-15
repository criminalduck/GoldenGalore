package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.block.GoldEmitterBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, GoldenGaloreMod.MODID);

    public static final RegistryObject<Block> GOLDEN_SUGAR_BLOCK = registerBlock("golden_sugar_block",
            () -> new GoldEmitterBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)
                    .strength(0.5f, 0.5f)), new Item.Properties().food(ModItems.ModFoods.GOLDEN_SUGAR_BLOCK.build()));

    public static <T extends Block> RegistryObject<T> registerBlock(String pName, Supplier<T> pBlock, Item.Properties iProperties) {
        RegistryObject<T> block = BLOCKS.register(pName, pBlock);
        ModItems.ITEMS.register(pName, () -> new BlockItem(block.get(), iProperties));
        return block;
    }
}
