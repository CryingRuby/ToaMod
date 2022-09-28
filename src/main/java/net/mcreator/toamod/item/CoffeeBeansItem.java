
package net.mcreator.toamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.mcreator.toamod.init.ToamodModTabs;

public class CoffeeBeansItem extends Item {
	public CoffeeBeansItem() {
		super(new Item.Properties().tab(ToamodModTabs.TAB_TOA_MOD_TAB).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f)

						.build()));
	}
}
