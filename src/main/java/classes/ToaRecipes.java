package classes;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;

import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.ToaItems;

import java.util.function.Supplier;
import java.util.Map;
import java.util.ArrayList;

public class ToaRecipes {
	private ToaRecipes() {
	}

	//All Weapons/Armors are created at Blacksmith (->ToaItemTrees-class)
	//Bsp for later:
	public static final ToaRecipes.Recipe PESTO_GOBLIN_OMLETTE = new Recipe(1, ToaItems.PESTO_GOBLIN_OMLETTE, createComponentsAround(new ItemStack(ToamodModItems.GOBLIN_OMLETTE.get(), 1), new ItemStack(ToamodModItems.GOBLIN_EGG.get(), 1)));

	private static class Recipe {
		private final int Form; //0 -> custom, 1 -> around, 2 -> cross, 3 -> vertical line, 4 -> horizontal line
		private final ItemStack Item;
		private final ItemStack[] Components;

		private Recipe(int form, ItemStack item, ItemStack[] components) {
			this.Form = form;
			this.Item = item;
			this.Components = components;
		}
	}

	private static class RecipeFormTree {

		private final int ID; //if Leaf: ID equals FormID | if non-Leaf: ID equals (-negative-)PathMethod-ID
		private final RecipeFormTree Left;
		private final RecipeFormTree Right;

		private RecipeFormTree(int id, RecipeFormTree left, RecipeFormTree right) {//Two ways possible (I think only 1 is needed in whole tree)
			this.ID = id;
			this.Left = left;
			this.Right = right;
		}

		private RecipeFormTree(int id, String treePos, RecipeFormTree one) { //Only one way possible; treePos -> left|right depending where the NON-CUSTOM Tree is
			this.ID = id;

			if (treePos.equals("left")) {
				this.Left = one;
				this.Right = null;
			} else {
				this.Right = one;
				this.Left = null;
			}
		}

		private RecipeFormTree(int id) { //Leaf -> actual Form-ID
			this.ID = id;
			this.Left = null;
			this.Right = null;
		}

		private boolean isLeaf() {
			return (this.Left == null && this.Right == null);
		}

		private RecipeFormTree getNext(Item saved, Item newItem) {
			switch (this.ID) {
				case -2 :
					return pathXItemAir(saved, newItem);
				case -1 :
					return pathXAir(newItem);
				default :
					return new RecipeFormTree(this.ID);
			}
		}

		private RecipeFormTree pathXAir(Item newItem) { //ID -1
			//depending on treePos given in Constructor -> Right OR Left is null -> before return test if Path is null --true?--> return custom-Form
			if (newItem == null)
				return (this.Right == null) ? new RecipeFormTree(0) : this.Right;
			return (this.Left == null) ? new RecipeFormTree(0) : this.Left;
		}

		private RecipeFormTree pathXItemAir(Item saved, Item newItem) { //ID -2
			if (saved == newItem)
				return this.Left;
			return (this.Right == null) ? new RecipeFormTree(0) : this.Right;
		}
	}

	//----------------------FormTree Construction-----------------------------------
	private static final RecipeFormTree FormTree = new RecipeFormTree(-1, //both
			new RecipeFormTree(-2, "left",
					new RecipeFormTree(-2, "left", new RecipeFormTree(-2, "left", new RecipeFormTree(-1, "left", new RecipeFormTree(-2, "left", new RecipeFormTree(-2, "left", new RecipeFormTree(-2, "left", new RecipeFormTree(1)))))))), //=> 8x1-Form
			new RecipeFormTree(-1, "left", new RecipeFormTree(-1, "right",
					new RecipeFormTree(-2, "left", new RecipeFormTree(-1, "left", new RecipeFormTree(-2, "left", new RecipeFormTree(-1, "right", new RecipeFormTree(-2, "left", new RecipeFormTree(-1, "right", new RecipeFormTree(2)))))))))); //=> 4x1-Form
	//-------------------------------------------------------------------------------
	//fully custom -> 9x any Item

	private static ItemStack[] createComponents(ItemStack c0, ItemStack c1, ItemStack c2, ItemStack c3, ItemStack c4, ItemStack c5, ItemStack c6, ItemStack c7, ItemStack c8) {
		ItemStack[] components = new ItemStack[9];
		components[0] = c0;
		components[1] = c1;
		components[2] = c2;
		components[3] = c3;
		components[4] = c4;
		components[5] = c5;
		components[6] = c6;
		components[7] = c7;
		components[8] = c8;
		return components;
	}

	//1x middle, 8x around
	private static ItemStack[] createComponentsAround(ItemStack middle, ItemStack around) {
		return createComponents(around, around, around, around, middle, around, around, around, around);
	}

	//1x middle, 4x directly next to middle -> cross
	private static ItemStack[] createComponentsCross(ItemStack middle, ItemStack cross) {
		return createComponents(new ItemStack(Items.AIR), cross, new ItemStack(Items.AIR), cross, middle, cross, new ItemStack(Items.AIR), cross, new ItemStack(Items.AIR));
	}

	//1x middle, 1x above, 1x below
	private static ItemStack[] createComponentsVertical(ItemStack middle, ItemStack above, ItemStack below) {
		return createComponents(new ItemStack(Items.AIR), above, new ItemStack(Items.AIR), new ItemStack(Items.AIR), middle, new ItemStack(Items.AIR), new ItemStack(Items.AIR), below, new ItemStack(Items.AIR));
	}

	//1x middle, 1x left, 1x right
	private static ItemStack[] createComponentsHorizontal(ItemStack middle, ItemStack left, ItemStack right) {
		return createComponents(new ItemStack(Items.AIR), new ItemStack(Items.AIR), new ItemStack(Items.AIR), left, middle, right, new ItemStack(Items.AIR), new ItemStack(Items.AIR), new ItemStack(Items.AIR));
	}

	//serach function: check for Form -> check for matching item in each slot ----if a Recipe matches--> check for required amount of items in each slots
	public static ItemStack getCraftingResult(Player player, int maxSlots) {
		ArrayList<ItemStack> craftingSlots = new ArrayList<>();
		int form = 0; //default: custom
		Item formItem = null; //null until first item is found
		for (int i = 0; i < maxSlots; i++) {
			craftingSlots.add((player.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(i)).getItem() : ItemStack.EMPTY)); //because getting Item from slot is to complicated for multuiple calls(lots of class-instance-checks)
			//take item from craftingSlots and move in FormTree correspondingly until valid-Form at the end OR custom-Form
			RecipeFormTree currForm = FormTree.getNext(formItem, craftingSlots.get(i).getItem());
			if (i == (maxSlots - 1) || currForm.ID == 0)
				form = currForm.ID;
		}
		ArrayList<ToaRecipes.Recipe> searchList = searchRecipesWithForm(/*actuall: player.CUSTOM_TOA_VARIABLES.unlockedRecipes ...etc... (delete the empty array->)*/ new ArrayList<ToaRecipes.Recipe>(), form);
		if (searchList.isEmpty())
			return new ItemStack(Items.AIR); //if no Recipe found with fitting form -> no valid Recipe (result: AIR)
		for (int i = 0; i < craftingSlots.size(); i++) {
			searchList = searchItemPosition(searchList, craftingSlots.get(i).getItem());
			if (searchList.isEmpty())
				return new ItemStack(Items.AIR); //if no Recipe is found in searchRecipesWithForm or from current searchItemPosition -> no valid Recipe (result: AIR)
		}
		//At this point there is a valid Recipe (or more than one -> that would mean there are (by Item-Position; not amounts) 2 identical Recipes -> won't happen)
		//Check required item amounts
		//=> 3rd shrinking
		for (int i = 0; i < searchList.get(0).Components.length; i++) {
			if (craftingSlots.get(i).getCount() < searchList.get(0).Components[i].getCount()) {
				return new ItemStack(Items.AIR); //required item amount isn't reached (result: AIR)
			}
		}
		return searchList.get(0).Item;
	}

	//searches all unlocked Recipes with the given form //=> 1st shrinking
	private static ArrayList<ToaRecipes.Recipe> searchRecipesWithForm(ArrayList<ToaRecipes.Recipe> unlocked, int form) {
		ArrayList<ToaRecipes.Recipe> result = new ArrayList<>();
		for (int i = 0; i < unlocked.size(); i++) {
			if (unlocked.get(i).Form == form)
				result.add(unlocked.get(i));
		}
		return result;
	}

	//searches all unlocked, form-fitting Recipes with fitting Item-Positions //=> 2nd shrinking
	private static ArrayList<ToaRecipes.Recipe> searchItemPosition(ArrayList<ToaRecipes.Recipe> searchIn, Item item) {
		ArrayList<ToaRecipes.Recipe> result = new ArrayList<>();
		for (int i = 0; i < searchIn.size(); i++) {
			boolean matches = true;
			for (int u = 0; u < searchIn.get(i).Components.length; u++) {
				if (item != searchIn.get(i).Components[u].getItem()) { //if 1 Item doesn't match -> whole Recipe doesn't match
					matches = false;
					break;
				}
			}
			if (matches)
				result.add(searchIn.get(i));
		}
		return result;
	}
}
