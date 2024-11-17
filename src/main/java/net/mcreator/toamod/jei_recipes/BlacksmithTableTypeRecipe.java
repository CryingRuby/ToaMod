package net.mcreator.toamod.jei_recipes;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.SimpleContainer;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.NonNullList;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class BlacksmithTableTypeRecipe implements Recipe<SimpleContainer> {
	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;
	private final boolean hasNbt;
	private final int copyNbtFromSlot;

	public BlacksmithTableTypeRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, boolean hasNbt, int copyNbtFromSlot) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
		this.hasNbt = hasNbt;
		this.copyNbtFromSlot = copyNbtFromSlot;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		System.out.println("called match func");
		if (pLevel.isClientSide()) {
			System.out.println("level is clientside -> end match");
			return false;
		}
		System.out.println("---------match-func-----FOR ITEM: "+output.getItem()+"-------");
		System.out.println("	---------------------------Recipe Items------------------");
		for(int i = 0; i < recipeItems.size(); i++){
			System.out.println("		Slot: "+i+" - "/*+recipeItems.get(i).getItems()[0].getItem()*/);
		}
		System.out.println("	----------------------------------------------------------");
		for (int i = 0; i < recipeItems.size(); i++) {
			if (recipeItems.get(i).isEmpty()) {
				System.out.println("Slot: "+i+", Got: "+pContainer.getItem(i+1).getItem() +" should be AIR / Empty");
				if (pContainer.getItem(i+1).getItem() != Items.AIR){
					System.out.println("	was NOT Air -> return false");
					return false;
				}
			} else{
				System.out.println("Slot: "+i+", Got: "+pContainer.getItem(i+1).getItem()+" should be "/*+recipeItems.get(i).getItems()[0].getItem()*/);
				if (!recipeItems.get(i).test(pContainer.getItem(i+1))){
					System.out.println("Did NOT match -> return false");
					return false;
				}

			}
				
		}
		System.out.println("-------------------------------------");
		return true;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, RegistryAccess access) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess access) {
		return output.copy();
	}

	public ItemStack getResultItem(){
		return output.copy();
	}

	public boolean getHasNbt(){
		return this.hasNbt;
	}

	public int getCopyNbtFromSlot(){
		return this.copyNbtFromSlot;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	public static class Type implements RecipeType<BlacksmithTableTypeRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "blacksmith_table_type";
	}

	public static class Serializer implements RecipeSerializer<BlacksmithTableTypeRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation("toamod", "blacksmith_table_type");

		@Override
		public BlacksmithTableTypeRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			JsonArray tempPattern = GsonHelper.getAsJsonArray(pSerializedRecipe, "pattern");
			boolean _hasNbt = pSerializedRecipe.has("has_nbt") ? pSerializedRecipe.get("has_nbt").getAsBoolean() : false;
			int _copyNbtFromSlot = pSerializedRecipe.has("nbt_copy") ? pSerializedRecipe.get("nbt_copy").getAsInt() : -1;
			String pattern = "";
			for (int i = 0; i < tempPattern.size(); i++) {
				pattern += tempPattern.get(i).getAsString();
			}
			NonNullList<Ingredient> inputs = NonNullList.withSize(9, Ingredient.EMPTY);
			int itemIndex = 0;
			for (int i = 0; i < inputs.size(); i++) {
				if (pattern.charAt(i) == ' ')
					continue;
				inputs.set(i, Ingredient.fromJson(ingredients.get(itemIndex)));
				itemIndex++;
			}
			return new BlacksmithTableTypeRecipe(pRecipeId, output, inputs, _hasNbt, _copyNbtFromSlot);
		}

		@Override
		public @Nullable BlacksmithTableTypeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(buf));
			}
			ItemStack output = buf.readItem();
			return new BlacksmithTableTypeRecipe(id, output, inputs, buf.readBoolean(), buf.readInt());
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, BlacksmithTableTypeRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				ing.toNetwork(buf);
			}
			buf.writeItemStack(recipe.getResultItem(null), false);
			buf.writeBoolean(recipe.getHasNbt());
			buf.writeInt(recipe.getCopyNbtFromSlot());
		}
	}
}
