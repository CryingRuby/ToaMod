package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class RunePropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("rarity");
	}
}
