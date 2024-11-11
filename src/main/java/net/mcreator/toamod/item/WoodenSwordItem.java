
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

import java.util.List;

public class WoodenSwordItem extends ToaWeapon {
	public WoodenSwordItem() {
		this.toaProperties = new ToaProperties("Sword", ToaRarity.COMMAN).str(5);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Type: \u00A79Sword\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A7fCOMMAN\u00A7r"));
	}
}
