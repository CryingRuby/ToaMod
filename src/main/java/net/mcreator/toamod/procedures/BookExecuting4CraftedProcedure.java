package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class BookExecuting4CraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("mdrequired", 145);
		itemstack.getOrCreateTag().putString("enchantment", "executing");
		itemstack.getOrCreateTag().putDouble("enchlvl", 4);
	}
}
