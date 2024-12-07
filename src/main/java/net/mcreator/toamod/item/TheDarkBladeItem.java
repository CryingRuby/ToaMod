
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaElement;

import java.util.List;

public class TheDarkBladeItem extends ToaWeapon {
	public TheDarkBladeItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.LEGENDARY).str(80).cr(45).cd(395).element(ToaElement.UNHOLY, 60).lifesteal(12.5f);
	}
}
