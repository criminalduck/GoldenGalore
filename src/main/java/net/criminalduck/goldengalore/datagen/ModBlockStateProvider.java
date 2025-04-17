package net.criminalduck.goldengalore.datagen;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GoldenGaloreMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GOLDEN_SUGAR_BLOCK);
        blockWithItem(ModBlocks.GOLD_BRICKS);

        axisBlock((RotatedPillarBlock) ModBlocks.GOLD_CHISELED_BLOCK.get(), modLoc("block/gold_block_chiseled"));
        stairsBlock((StairBlock) ModBlocks.GOLD_BRICK_STAIRS.get(), blockTexture(ModBlocks.GOLD_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.GOLD_STAIRS.get(), blockTexture(Blocks.GOLD_BLOCK));
        slabBlock((SlabBlock) ModBlocks.GOLD_BRICK_SLAB.get(), blockTexture(ModBlocks.GOLD_BRICKS.get()), blockTexture(ModBlocks.GOLD_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.GOLD_SLAB.get(), blockTexture(Blocks.GOLD_BLOCK), blockTexture(Blocks.GOLD_BLOCK));

        buttonBlock((ButtonBlock) ModBlocks.GOLD_BUTTON.get(), blockTexture(Blocks.GOLD_BLOCK));
        wallBlock((WallBlock) ModBlocks.GOLD_BRICK_WALL.get(), blockTexture(ModBlocks.GOLD_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.GOLD_WALL.get(), blockTexture(Blocks.GOLD_BLOCK));
        doorBlockWithRenderType((DoorBlock) ModBlocks.GOLD_DOOR.get(), modLoc("block/gold_door_bottom"), modLoc("block/gold_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.GOLD_TRAPDOOR.get(), modLoc("block/gold_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
