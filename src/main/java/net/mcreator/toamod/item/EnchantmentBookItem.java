
package net.mcreator.toamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EnchantmentBookItem extends Item {
	public EnchantmentBookItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
