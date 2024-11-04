
package net.mcreator.toamod.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.toamod.jei_recipes.MagicCrafterTypeRecipeCategory;
import net.mcreator.toamod.jei_recipes.MagicCrafterTypeRecipe;
import net.mcreator.toamod.jei_recipes.BlacksmithTableTypeRecipeCategory;
import net.mcreator.toamod.jei_recipes.BlacksmithTableTypeRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class ToamodModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<BlacksmithTableTypeRecipe> BlacksmithTableType_Type = new mezz.jei.api.recipe.RecipeType<>(BlacksmithTableTypeRecipeCategory.UID, BlacksmithTableTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<MagicCrafterTypeRecipe> MagicCrafterType_Type = new mezz.jei.api.recipe.RecipeType<>(MagicCrafterTypeRecipeCategory.UID, MagicCrafterTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("toamod:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new BlacksmithTableTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MagicCrafterTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<BlacksmithTableTypeRecipe> BlacksmithTableTypeRecipes = recipeManager.getAllRecipesFor(BlacksmithTableTypeRecipe.Type.INSTANCE);
		registration.addRecipes(BlacksmithTableType_Type, BlacksmithTableTypeRecipes);
		List<MagicCrafterTypeRecipe> MagicCrafterTypeRecipes = recipeManager.getAllRecipesFor(MagicCrafterTypeRecipe.Type.INSTANCE);
		registration.addRecipes(MagicCrafterType_Type, MagicCrafterTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ToamodModBlocks.BLACKSMITH_TABLE.get().asItem()), BlacksmithTableType_Type);
		registration.addRecipeCatalyst(new ItemStack(ToamodModBlocks.MAGIC_CRAFTER.get().asItem()), MagicCrafterType_Type);
	}
}
