
package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public class CustomNbtHandler {
	public CustomNbtHandler() {
	}

	/**
	 * copies all upgrades like enchantments, reforge, stars, etc...
	 * @param item the upgrades get copied from
	 * @param item the upgrades get copied to
	 */
	public static void copyUpgrades(ItemStack copyFrom, ItemStack copyTo) {
		if (!(copyFrom.getItem() instanceof IToaReforgeable) || !(copyTo.getItem() instanceof IToaReforgeable))
			return;

		
	}

	/**
	 * 
	 */
	public static void applyItemBaseStats(ItemStack item) {
		if (!(item.getItem() instanceof ToaWeapon))
			return;
		ToaProperties prop = ((ToaWeapon) item.getItem()).toaProperties;
		prop.addBaseInfoToNbt(item.getOrCreateTag());
		item.getOrCreateTag().put("Stats", prop.statsToNbt());
	}
}
