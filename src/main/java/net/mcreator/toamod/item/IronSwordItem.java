
package net.mcreator.toamod.item;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.RuneSlot;

public class IronSwordItem extends ToaWeapon {
	public IronSwordItem() {
		this.toaProperties = new ToaProperties("Sword", ToaRarity.COMMON).str(15);
	}
}
