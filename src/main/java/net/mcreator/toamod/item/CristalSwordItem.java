
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

import java.util.List;

public class CristalSwordItem extends ToaWeapon {
	public CristalSwordItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.RARE).str(1);
	}
	
}
