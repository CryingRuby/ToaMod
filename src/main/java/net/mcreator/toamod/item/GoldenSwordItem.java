
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

import java.util.List;

public class GoldenSwordItem extends ToaWeapon {
	public GoldenSwordItem() {
		this.toaProperties = new ToaProperties("Sword", ToaRarity.UNCOMMAN).str(30).cd(10);
	}
}
