
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

import java.util.List;

public class DeathsDanceItem extends ToaWeapon {
	public DeathsDanceItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.LEGENDARY).str(130).cr(35).cd(170).dex(40);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Rarity: \u00A75Epic\u00A7r"));
		list.add(Component.literal("\u00A77Type: \u00A79Sword\u00A7r"));
	}
}
