
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaWeapon;

import java.util.List;

public class ScaldrisHyperionItem extends ToaWeapon {
	public ScaldrisHyperionItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.MYTHIC).str(275).dex(30).cr(50).cd(425).lifesteal(35);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Type: \u00A79Sword\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A73RARE\u00A7r"));
	}
}
