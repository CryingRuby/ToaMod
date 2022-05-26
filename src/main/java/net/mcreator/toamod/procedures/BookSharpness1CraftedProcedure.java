package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class BookSharpness1CraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("mdrequired", 10);
		itemstack.getOrCreateTag().putString("enchantment", "sharpness");
		itemstack.getOrCreateTag().putDouble("enchlvl", 1);
	}
}
