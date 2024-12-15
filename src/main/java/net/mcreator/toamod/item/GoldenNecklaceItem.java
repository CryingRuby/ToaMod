
package net.mcreator.toamod.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.toamod.ToaReforgeable;
import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

public class GoldenNecklaceItem extends ToaReforgeable implements ICurioItem {
	public GoldenNecklaceItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
		this.toaProperties = (new ToaProperties("Equipment", ToaRarity.UNCOMMON)).str(5).mf(1);

	}
}
