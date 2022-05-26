package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class TheDarkBladeItemIsCraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("rarity", "legendary");
		itemstack.getOrCreateTag().putBoolean("hasAbility", (false));
	}
}
