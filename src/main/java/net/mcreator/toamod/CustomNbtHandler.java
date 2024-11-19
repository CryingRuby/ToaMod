
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
		if (!(copyFrom.getItem() instanceof IToaReforgeable) || !(copyTo.getItem() instanceof IToaReforgeable) || copyFrom.getOrCreateTag().getCompound("Upgrades").isEmpty())
			return;

		CompoundTag nbtTo = new CompoundTag();
		CompoundTag nbtFrom = copyFrom.getOrCreateTag().getCompound("Upgrades");
		if (nbtFrom.getInt("stars") != 0)
			nbtTo.putInt("stars", nbtFrom.getInt("stars"));
		if (!nbtFrom.getString("reforge").isEmpty()) {
			nbtTo.putString("reforge", nbtFrom.getString("reforge"));
			ReforgeType.getByName(nbtTo.getString("reforge")).applyReforgeToItem(copyTo);
		}
		/*
		if (nbtFrom.getInt("stackable") > 0) {
			nbtTo.putInt("stackable", nbtFrom.get("stackable"));
			//apply stackable to item
		}
		if (nbtFrom.gteString("prestige").isEmpty()) {
			nbtTo.putString("prestige", nbtFrom.getString("prestige"));
			//apply prestige to item
		}*/

		copyTo.getOrCreateTag().put("Upgrades", nbtTo);
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
