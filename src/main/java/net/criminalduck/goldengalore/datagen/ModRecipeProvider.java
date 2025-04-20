package net.criminalduck.goldengalore.datagen;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.init.ModBlocks;
import net.criminalduck.goldengalore.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pConsumer) {
        // FOODS
        threeByThreePacker(pConsumer, RecipeCategory.MISC, ModBlocks.GOLDEN_SUGAR_BLOCK.get(), ModItems.GOLDEN_SUGAR.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOLDEN_SUGAR.get(), 9)
                        .requires(ModBlocks.GOLDEN_SUGAR_BLOCK.get())
                        .unlockedBy(getHasName(ModBlocks.GOLDEN_SUGAR_BLOCK.get()), has(ModBlocks.GOLDEN_SUGAR_BLOCK.get()))
                        .save(pConsumer, new ResourceLocation(GoldenGaloreMod.MODID, "golden_sugar_unpack"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOLDEN_SUGAR.get())
                .requires(Items.GOLD_NUGGET, 1)
                .requires(Items.SUGAR, 1)
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(pConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_BREAD.get())
                .pattern("SSS")
                .define('S', ModItems.GOLDEN_WHEAT.get())
                .unlockedBy(getHasName(ModItems.GOLDEN_WHEAT.get()), has(ModItems.GOLDEN_WHEAT.get()))
                .save(pConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOLDEN_WHEAT.get())
                .requires(Items.GOLD_NUGGET, 2)
                .requires(Items.WHEAT, 1)
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(pConsumer);

        goldFood(Items.POTATO, ModItems.GOLDEN_POTATO.get());
        goldFood(Items.BEETROOT, ModItems.GOLDEN_BEETROOT.get());
        goldFood(Items.SPIDER_EYE, ModItems.GOLDEN_SPIDER_EYE.get());
        goldFood(Items.RABBIT_FOOT, ModItems.GOLDEN_RABBITS_FOOT.get());
        goldFood(Items.GHAST_TEAR, ModItems.GOLDEN_GHAST_TEAR.get());

        // ITEMS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SOLID_GOLD_BUCKET.get())
                .requires(Blocks.GOLD_BLOCK, 1)
                .requires(Items.BUCKET, 1)
                .unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET))
                .unlockedBy(getHasName(Blocks.GOLD_BLOCK), has(Blocks.GOLD_BLOCK))
                .save(pConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.GOLD_BLOCK)
                .requires(ModItems.SOLID_GOLD_BUCKET.get(), 1)
                .unlockedBy(getHasName(ModItems.SOLID_GOLD_BUCKET.get()), has(ModItems.SOLID_GOLD_BUCKET.get()))
                .save(pConsumer, new ResourceLocation(GoldenGaloreMod.MODID, "solid_gold_bucket_unpack"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.GOLD_BLOCK)
                .requires(ModItems.MOLTEN_GOLD_BUCKET.get(), 1)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .unlockedBy(getHasName(ModItems.MOLTEN_GOLD_BUCKET.get()), has(ModItems.MOLTEN_GOLD_BUCKET.get()))
                .save(pConsumer, new ResourceLocation(GoldenGaloreMod.MODID, "molten_gold_bucket_cooling"));

        oreSmelting(pConsumer, List.of(ModItems.SOLID_GOLD_BUCKET.get()), RecipeCategory.MISC, ModItems.MOLTEN_GOLD_BUCKET.get(), 0.0f, 200, "misc");
        oreBlasting(pConsumer, List.of(ModItems.SOLID_GOLD_BUCKET.get()), RecipeCategory.MISC, ModItems.MOLTEN_GOLD_BUCKET.get(), 0.0f, 100, "misc");

        // BLOCKS - CRAFTING
        twoByTwoPacker(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICKS.get(), Items.GOLD_BLOCK);
        twoByTwoPacker(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_CHISELED_BLOCK.get(), ModBlocks.GOLD_BRICKS.get());
        twoByTwoPacker(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_PILLAR.get(), ModBlocks.GOLD_CHISELED_BLOCK.get());
        stair(pConsumer, ModBlocks.GOLD_BRICK_STAIRS.get(), ModBlocks.GOLD_BRICKS.get());
        stair(pConsumer, ModBlocks.GOLD_STAIRS.get(), Blocks.GOLD_BLOCK);
        slab(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_SLAB.get(), ModBlocks.GOLD_BRICKS.get());
        slab(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_SLAB.get(), Blocks.GOLD_BLOCK);
        wall(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_WALL.get(), ModBlocks.GOLD_BRICKS.get());
        wall(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_WALL.get(), Blocks.GOLD_BLOCK);
        door(pConsumer, ModBlocks.GOLD_DOOR.get(), Items.GOLD_INGOT);
        trapdoor(pConsumer, ModBlocks.GOLD_TRAPDOOR.get(), Items.GOLD_INGOT);
        button(pConsumer, ModBlocks.GOLD_BUTTON.get(), Items.GOLD_INGOT);

        // BLOCKS - STONECUTTER
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICKS.get(), Blocks.GOLD_BLOCK);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_CHISELED_BLOCK.get(), ModBlocks.GOLD_BRICKS.get());
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_CHISELED_BLOCK.get(), Blocks.GOLD_BLOCK);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_PILLAR.get(), ModBlocks.GOLD_BRICKS.get());
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_PILLAR.get(), Blocks.GOLD_BLOCK);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_STAIRS.get(), ModBlocks.GOLD_BRICKS.get());
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_STAIRS.get(), Blocks.GOLD_BLOCK);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_SLAB.get(),  ModBlocks.GOLD_BRICKS.get(), 2);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_SLAB.get(),  Blocks.GOLD_BLOCK, 2);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_WALL.get(), ModBlocks.GOLD_BRICKS.get());
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_WALL.get(), Blocks.GOLD_BLOCK);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_WALL.get(), Blocks.GOLD_BLOCK);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_SLAB.get(),  Blocks.GOLD_BLOCK, 2);
        stonecutterRecipe(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICK_STAIRS.get(), Blocks.GOLD_BLOCK);
    }

    protected static void stonecutterRecipe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
        stonecutterRecipe(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
    }

    protected static void stonecutterRecipe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount) {
        SingleItemRecipeBuilder var10000 = SingleItemRecipeBuilder.stonecutting(Ingredient.of(new ItemLike[]{pMaterial}), pCategory, pResult, pResultCount).unlockedBy(getHasName(pMaterial), has(pMaterial));
        String var10002 = getConversionRecipeName(pResult, pMaterial);
        var10000.save(pFinishedRecipeConsumer, new ResourceLocation(GoldenGaloreMod.MODID, var10002 + "_stonecutting"));
    }

    protected static void stair(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pStair, ItemLike pMaterial) {
        stairBuilder(pStair, Ingredient.of(new ItemLike[]{pMaterial})).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }
    protected static void door(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pStair, ItemLike pMaterial) {
        doorBuilder(pStair, Ingredient.of(new ItemLike[]{pMaterial})).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }
    protected static void trapdoor(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pStair, ItemLike pMaterial) {
        trapdoorBuilder(pStair, Ingredient.of(new ItemLike[]{pMaterial})).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }
    protected static void button(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pStair, ItemLike pMaterial) {
        buttonBuilder(pStair, Ingredient.of(new ItemLike[]{pMaterial})).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }


    protected static void goldFood(ItemLike pFoodInput, ItemLike pFoodOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pFoodOutput)
                .pattern("SSS")
                .pattern("SXS")
                .pattern("SSS")
                .define('S', Items.GOLD_NUGGET)
                .define('X', pFoodInput)
                .unlockedBy(getHasName(pFoodInput), has(pFoodInput));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, GoldenGaloreMod.MODID + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
