
package net.mcreator.toamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RuneEpicItem extends Item {
	public RuneEpicItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
