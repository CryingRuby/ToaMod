package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class AncientGuardianWarhammerItemIsCraftedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("rarity", "mythic");
		itemstack.getOrCreateTag().putBoolean("hasAbility", false);
	}
}
