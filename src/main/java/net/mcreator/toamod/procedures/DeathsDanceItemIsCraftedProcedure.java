package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class DeathsDanceItemIsCraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("rarity", "epic");
		itemstack.getOrCreateTag().putBoolean("hasAbility", false);
	}
}
