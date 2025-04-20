package net.criminalduck.goldengalore.datagen;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GoldenGaloreMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.GOLDEN_SUGAR_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                    ModBlocks.GOLDEN_SUGAR_BLOCK.get(),
                    ModBlocks.GOLD_CHISELED_BLOCK.get(),
                    ModBlocks.GOLD_PILLAR.get(),
                    ModBlocks.GOLD_BRICK_STAIRS.get(),
                    ModBlocks.GOLD_STAIRS.get(),
                    ModBlocks.GOLD_BRICK_SLAB.get(),
                    ModBlocks.GOLD_SLAB.get(),
                    ModBlocks.GOLD_BRICK_WALL.get(),
                    ModBlocks.GOLD_WALL.get(),
                    ModBlocks.GOLD_DOOR.get(),
                    ModBlocks.GOLD_TRAPDOOR.get(),
                    ModBlocks.GOLD_BUTTON.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                    ModBlocks.GOLDEN_SUGAR_BLOCK.get(),
                    ModBlocks.GOLD_CHISELED_BLOCK.get(),
                    ModBlocks.GOLD_PILLAR.get(),
                    ModBlocks.GOLD_BRICK_STAIRS.get(),
                    ModBlocks.GOLD_STAIRS.get(),
                    ModBlocks.GOLD_BRICK_SLAB.get(),
                    ModBlocks.GOLD_SLAB.get(),
                    ModBlocks.GOLD_BRICK_WALL.get(),
                    ModBlocks.GOLD_WALL.get(),
                    ModBlocks.GOLD_DOOR.get(),
                    ModBlocks.GOLD_TRAPDOOR.get(),
                    ModBlocks.GOLD_BUTTON.get()
                );

        this.tag(BlockTags.WALLS)
                .add(
                    ModBlocks.GOLD_BRICK_WALL.get(),
                    ModBlocks.GOLD_WALL.get()
                );
    }
}
