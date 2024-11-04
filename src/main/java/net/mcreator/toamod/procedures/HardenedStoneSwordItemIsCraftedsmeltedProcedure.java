package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class HardenedStoneSwordItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("rarity", "comman");
		itemstack.getOrCreateTag().putBoolean("hasAbility", false);
	}
}
