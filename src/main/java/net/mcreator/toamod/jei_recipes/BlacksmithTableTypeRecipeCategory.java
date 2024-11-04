
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

public class BlacksmithTableTypeRecipeCategory implements IRecipeCategory<BlacksmithTableTypeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("toamod", "blacksmith_table_type");
	public final static ResourceLocation TEXTURE = new ResourceLocation("toamod", "textures/screens/blacksmith_table_jei_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public BlacksmithTableTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 155, 80);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.SMITHING_TABLE.asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<BlacksmithTableTypeRecipe> getRecipeType() {
		return ToamodModJeiPlugin.BlacksmithTableType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Blacksmith Table Type");
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
	public void setRecipe(IRecipeLayoutBuilder builder, BlacksmithTableTypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.OUTPUT, 122, 32).addItemStack(recipe.getResultItem(null));
		for(int i = 0; i < 3; i++){
			for(int u = 0; u < 3; u++){
				builder.addSlot(RecipeIngredientRole.INPUT, 14 + 18 * u, 14 + 18 * i).addIngredients(recipe.getIngredients().get(3*i+u));

			}
		}
	}
}
