package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class IronSwordItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("rarity", "uncomman");
		itemstack.getOrCreateTag().putBoolean("hasAbility", (false));
	}
}
