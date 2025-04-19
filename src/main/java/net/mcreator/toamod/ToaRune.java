package net.mcreator.toamod;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public abstract class ToaRune extends Item {
	public ToaRune() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}

	public RuneType runeType;
}
