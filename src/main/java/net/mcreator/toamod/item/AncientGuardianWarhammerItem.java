
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.RuneSlot;

import java.util.List;

public class AncientGuardianWarhammerItem extends ToaWeapon {
	public AncientGuardianWarhammerItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.ANCIENT).str(new float[]{800, 15}).dex(-25);
		runeSlots = new RuneSlot[3];
	}
}
