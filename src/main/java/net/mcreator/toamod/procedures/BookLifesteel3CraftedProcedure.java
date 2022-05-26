package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class BookLifesteel3CraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("mdrequired", 225);
		itemstack.getOrCreateTag().putString("enchantment", "lifesteel");
		itemstack.getOrCreateTag().putDouble("enchlvl", 3);
	}
}
