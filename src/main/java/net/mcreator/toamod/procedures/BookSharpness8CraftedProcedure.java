package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class BookSharpness8CraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("mdrequired", 150);
		itemstack.getOrCreateTag().putString("enchantment", "sharpness");
		itemstack.getOrCreateTag().putDouble("enchlvl", 8);
	}
}
