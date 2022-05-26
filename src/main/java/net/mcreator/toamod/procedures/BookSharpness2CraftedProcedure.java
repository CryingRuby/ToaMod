package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class BookSharpness2CraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("mdrequired", 20);
		itemstack.getOrCreateTag().putString("enchantment", "sharpness");
		itemstack.getOrCreateTag().putDouble("enchlvl", 2);
	}
}
