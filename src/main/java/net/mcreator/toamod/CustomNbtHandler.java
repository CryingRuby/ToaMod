
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
		if (!(copyFrom.getItem() instanceof IToaReforgeable) || !(copyTo.getItem() instanceof IToaReforgeable) || !copyFrom.getOrCreateTag().has("Upgrades") || copyFrom.getOrCreateTag().get("Upgrades").isEmpty())
			return;

		CompoundTag nbtTo = new CompoundTag();
		CompoundTag nbtFrom = copyFrom.getOrCreateTag().get("Upgrades");
		if(nbtFrom.has("stars"))
			nbtTo.putInt("stars", nbtFrom.getInt("stars"));
		if(nbtFrom.has("reforge")){
			nbtTo.putString"reforge", (nbtFrom.get("reforge"));
			ToaReforgeHandler.applyReforgeToItem(copyTo, ReforgeType.getByName(nbtTo.getString("reforge")));
		}
		if(nbtFrom.has("stackable")){
			nbtTo.putInt("stackable", nbtFrom.get("stackable"));
			//apply stackable to item
		}
		if(nbtFrom.has("prestige")){
			nbtTo.putString("prestige", nbtFrom.getString("prestige"));
			//apply prestige to item
		}
		
			
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
