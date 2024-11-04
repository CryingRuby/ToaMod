package net.mcreator.toamod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class SlotsToRecipeStringProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String recipeString = "";
		double i = 0;
		recipeString = "";
		i = 1;
		for (int index0 = 0; index0 < 9; index0++) {
			if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
				recipeString = recipeString + ""
						+ ((ForgeRegistries.ITEMS
								.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) i)).getItem() : ItemStack.EMPTY).getItem()).toString())
								.replace("toamod:", ""));
			} else {
				recipeString = recipeString + "air";
			}
			if (i < 9) {
				recipeString = recipeString + ",";
			}
			i = i + 1;
		}
		recipeString = recipeString + ";";
		return recipeString;
	}
}
