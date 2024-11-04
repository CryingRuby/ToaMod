
package net.mcreator.toamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class StatIconMFItem extends Item {
	public StatIconMFItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
