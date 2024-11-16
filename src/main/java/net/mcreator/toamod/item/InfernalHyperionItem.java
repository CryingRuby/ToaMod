
package net.mcreator.toamod.item;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaElement;

public class InfernalHyperionItem extends ToaWeapon {
	public InfernalHyperionItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.ANCIENT).str(50).cr(15).cd(100)._int(490).element(ToaElement.FIRE, 685);
	}
}
