package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class DwarfsHymnTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("cooldown") > 0) {
			itemstack.getOrCreateTag().putDouble("cooldown", (itemstack.getOrCreateTag().getDouble("cooldown") - 1));
			itemstack.setDamageValue((int) Math.ceil(itemstack.getOrCreateTag().getDouble("cooldown") / 240));
		}
	}
}
