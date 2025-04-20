package net.criminalduck.goldengalore.datagen.loot;

import net.criminalduck.goldengalore.init.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GOLDEN_SUGAR_BLOCK.get());
        this.dropSelf(ModBlocks.GOLD_BRICKS.get());
        this.dropSelf(ModBlocks.GOLD_CHISELED_BLOCK.get());
        this.dropSelf(ModBlocks.GOLD_PILLAR.get());
        this.dropSelf(ModBlocks.GOLD_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.GOLD_STAIRS.get());
        this.dropSelf(ModBlocks.GOLD_BRICK_WALL.get());
        this.dropSelf(ModBlocks.GOLD_WALL.get());
        this.dropSelf(ModBlocks.GOLD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.GOLD_BUTTON.get());

        this.add(ModBlocks.GOLD_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GOLD_BRICK_SLAB.get()));
        this.add(ModBlocks.GOLD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GOLD_SLAB.get()));
        this.add(ModBlocks.GOLD_DOOR.get(),
                block -> createDoorTable(ModBlocks.GOLD_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
