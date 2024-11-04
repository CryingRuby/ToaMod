
package net.mcreator.toamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class StatIconMRItem extends Item {
	public StatIconMRItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
