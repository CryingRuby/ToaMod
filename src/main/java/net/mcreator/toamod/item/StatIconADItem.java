
package net.mcreator.toamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class StatIconADItem extends Item {
	public StatIconADItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
