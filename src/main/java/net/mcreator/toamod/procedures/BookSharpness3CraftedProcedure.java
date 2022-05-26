package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class BookSharpness3CraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("mdrequired", 35);
		itemstack.getOrCreateTag().putString("enchantment", "sharpness");
		itemstack.getOrCreateTag().putDouble("enchlvl", 3);
	}
}
