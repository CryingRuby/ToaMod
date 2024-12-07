
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

import java.util.List;

public class DragonSlayerItem extends ToaWeapon {
	public DragonSlayerItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.MYTHIC).str(400).cr(-25).cd(515)._int(-75);
	}

}
