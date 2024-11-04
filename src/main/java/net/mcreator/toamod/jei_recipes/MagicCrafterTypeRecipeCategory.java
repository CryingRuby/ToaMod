
package net.mcreator.toamod.jei_recipes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.init.ToamodModJeiPlugin;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class MagicCrafterTypeRecipeCategory implements IRecipeCategory<MagicCrafterTypeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("toamod", "magic_crafter_type");
	public final static ResourceLocation TEXTURE = new ResourceLocation("toamod", "textures/screens/magic_crafter_jei_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public MagicCrafterTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 155, 80);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.ENCHANTING_TABLE.asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<MagicCrafterTypeRecipe> getRecipeType() {
		return ToamodModJeiPlugin.MagicCrafterType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Magic Crafter Type");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MagicCrafterTypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.OUTPUT, 141, 31).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.INPUT, 42, 4).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 24, 13).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 60, 13).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 15, 31).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 42, 31).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 69, 31).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 24, 49).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 60, 49).addIngredients(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.INPUT, 42, 58).addIngredients(recipe.getIngredients().get(9));
	}
}
