
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

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Rarity: \u00A76Legendary\u00A7r"));
		list.add(Component.literal("\u00A77Type: \u00A79Sword\u00A7r"));
	}
}
