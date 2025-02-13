
package net.mcreator.toamod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ReforgeGemstoneItem extends Item {
	public ReforgeGemstoneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
