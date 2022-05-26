package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.toamod.init.ToamodModEnchantments;

public class FlameSwordItemIsCraftedProcedure {
	public static void execute(ItemStack itemstack) {
		(itemstack).enchant(ToamodModEnchantments.IGNITE.get(), 1);
		itemstack.getOrCreateTag().putString("rarity", "epic");
		itemstack.getOrCreateTag().putBoolean("hasAbility", (false));
	}
}
