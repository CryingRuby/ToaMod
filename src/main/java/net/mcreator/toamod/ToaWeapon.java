package net.mcreator.toamod;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public abstract class ToaWeapon extends ToaReforgeable {
	public ToaWeapon() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
