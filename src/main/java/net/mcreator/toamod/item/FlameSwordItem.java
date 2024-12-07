
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

public class FlameSwordItem extends ToaWeapon {
	public FlameSwordItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.EPIC).str(25).cr(7.5f).cd(35)._int(105).element(ToaElement.FIRE, 160);
	}

}
