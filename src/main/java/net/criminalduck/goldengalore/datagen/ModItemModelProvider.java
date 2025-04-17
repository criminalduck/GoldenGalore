package net.criminalduck.goldengalore.datagen;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.init.ModBlocks;
import net.criminalduck.goldengalore.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GoldenGaloreMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GOLDEN_WHEAT);
        simpleItem(ModItems.GOLDEN_BREAD);
        simpleItem(ModItems.GOLDEN_SUGAR);
        simpleItem(ModItems.GOLDEN_POTATO);
        simpleItem(ModItems.GOLDEN_BEETROOT);

        itemBlockItem(ModBlocks.GOLD_DOOR);
        simpleBlockItem(ModBlocks.GOLD_BRICK_STAIRS);
        simpleBlockItem(ModBlocks.GOLD_STAIRS);
        simpleBlockItem(ModBlocks.GOLD_BRICK_SLAB);
        simpleBlockItem(ModBlocks.GOLD_SLAB);
        simpleBlockItem(ModBlocks.GOLD_CHISELED_BLOCK);

        trapdoorItem(ModBlocks.GOLD_TRAPDOOR);
        buttonItem(ModBlocks.GOLD_BUTTON, Blocks.GOLD_BLOCK);
        wallItem(ModBlocks.GOLD_BRICK_WALL, ModBlocks.GOLD_BRICKS);
        wallItem(ModBlocks.GOLD_WALL, Blocks.GOLD_BLOCK);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), "item/generated")
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder itemBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    public void simpleBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(GoldenGaloreMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void buttonItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", mcLoc("block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", mcLoc("block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }
}
