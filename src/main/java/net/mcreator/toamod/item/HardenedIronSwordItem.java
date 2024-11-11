
package net.mcreator.toamod.item;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

public class HardenedIronSwordItem extends ToaWeapon {
	public HardenedIronSwordItem() {
		this.toaProperties = new ToaProperties("Sword", ToaRarity.COMMAN).str(25);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Type: \u00A79Sword\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A7fCOMMAN\u00A7r"));
	}

}
