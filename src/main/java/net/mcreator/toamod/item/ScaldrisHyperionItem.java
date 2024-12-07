
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

import java.util.List;

public class ScaldrisHyperionItem extends ToaWeapon {
	public ScaldrisHyperionItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.MYTHIC).str(275).dex(30).cr(50).cd(425).lifesteal(35);
	}

}
