package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class CristalSwordItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("rarity", "rare");
		itemstack.getOrCreateTag().putBoolean("hasAbility", false);
	}
}
