
package net.mcreator.toamod.item;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

public class IllfangsCutlassItem extends ToaWeapon {
	public IllfangsCutlassItem() {
		this.toaProperties = new ToaProperties("Sword", ToaRarity.LEGENDARY).str(1);
	}
}
