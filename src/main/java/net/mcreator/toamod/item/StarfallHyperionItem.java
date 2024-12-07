
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

public class StarfallHyperionItem extends ToaWeapon {
	public StarfallHyperionItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.MYTHIC).str(120)._int(185).cr(10).cd(85).element(ToaElement.HOLY, 210);
	}
}
