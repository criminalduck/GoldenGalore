package net.criminalduck.goldengalore.datagen;

import net.criminalduck.goldengalore.GoldenGaloreMod;
import net.criminalduck.goldengalore.init.ModBlocks;
import net.criminalduck.goldengalore.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pConsumer) {
        threeByThreePacker(pConsumer, RecipeCategory.MISC, ModBlocks.GOLDEN_SUGAR_BLOCK.get(), ModItems.GOLDEN_SUGAR.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GOLDEN_SUGAR.get(), 9)
                        .requires(ModBlocks.GOLDEN_SUGAR_BLOCK.get())
                        .unlockedBy(getHasName(ModBlocks.GOLDEN_SUGAR_BLOCK.get()), has(ModBlocks.GOLDEN_SUGAR_BLOCK.get()))
                        .save(pConsumer, "golden_sugar_unpack");

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

        twoByTwoPacker(pConsumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BRICKS.get(), Items.GOLD_BLOCK);

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
