package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class BookExecuting5CraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("mdrequired", 185);
		itemstack.getOrCreateTag().putString("enchantment", "executing");
		itemstack.getOrCreateTag().putDouble("enchlvl", 5);
	}
}
