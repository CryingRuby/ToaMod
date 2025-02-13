package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;

public class ReforgeGemstonePropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		itemstack.grow(0);
		net.mcreator.toamod.ReforgeType reforge = net.mcreator.toamod.ReforgeType.getByName(itemstack.getOrCreateTag().getString("reforge"));
		//System.out.println("reforge:"+reforge+", return:" +((reforge == null)? 0 : reforge.getID()));
		return (reforge == null) ? 0 : reforge.getID();
	}
}
