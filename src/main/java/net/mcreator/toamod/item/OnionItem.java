
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.init.ToamodModTabs;

import java.util.List;

public class OnionItem extends Item {
	public OnionItem() {
		super(new Item.Properties().tab(ToamodModTabs.TAB_TOA_MOD_TAB).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f)

						.build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("\u00A77Rarity: \u00A7fComman\u00A7r"));
		list.add(new TextComponent("\u00A77Type: \u00A79Food\u00A7r"));
	}
}
