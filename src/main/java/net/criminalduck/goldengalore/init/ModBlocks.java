package net.criminalduck.goldengalore.init;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.content.block.DustEmitterBlock;
import net.criminalduck.goldengalore.content.fluid.MoltenFluid;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, GoldenGaloreMod.MODID);

    public static final RegistryObject<Block> GOLDEN_SUGAR_BLOCK = registerBlock("golden_sugar_block",
            () -> new DustEmitterBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND).mapColor(MapColor.GOLD), new Vector3f(1.0f, 0.82f, 0.2f)),
                    new Item.Properties().food(ModItems.ModFoods.GOLDEN_SUGAR_BLOCK));

    public static final RegistryObject<Block> GOLD_BRICKS = registerBlock("gold_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> GOLD_BRICK_STAIRS = registerBlock("gold_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GOLD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> GOLD_BRICK_SLAB = registerBlock("gold_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> GOLD_STAIRS = registerBlock("gold_stairs",
            () -> new StairBlock(() -> ModBlocks.GOLD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> GOLD_SLAB = registerBlock("gold_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> GOLD_CHISELED_BLOCK = registerBlock("chiseled_gold_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> GOLD_PILLAR = registerBlock("gold_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());

    public static final RegistryObject<Block> GOLD_BRICK_WALL = registerBlock("gold_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> GOLD_WALL = registerBlock("gold_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL)), new Item.Properties());

    public static final RegistryObject<Block> GOLD_DOOR = registerBlock("gold_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL).noOcclusion(), BlockSetType.IRON), new Item.Properties());
    public static final RegistryObject<Block> GOLD_TRAPDOOR = registerBlock("gold_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.METAL).noOcclusion(), BlockSetType.IRON), new Item.Properties());

    public static final RegistryObject<Block> GOLD_BUTTON = registerBlock("gold_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.METAL), BlockSetType.IRON, 10, true), new Item.Properties());

    // FLUID BLOCKS
    public static final RegistryObject<LiquidBlock> MOLTEN_GOLD_BLOCK = BLOCKS.register("molten_gold_block",
            () -> new MoltenFluid(ModFluids.SOURCE_MOLTEN_GOLD, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));

    public static <T extends Block> RegistryObject<T> registerBlock(String pName, Supplier<T> pBlock, Item.Properties iProperties) {
        RegistryObject<T> block = BLOCKS.register(pName, pBlock);
        ModItems.ITEMS.register(pName, () -> new BlockItem(block.get(), iProperties));
        return block;
    }
}
