
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class GemstoneTanzaniteItem extends Item {
	public GemstoneTanzaniteItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7r"));
		list.add(Component.literal("\u00A77Upgrades item into \u00A7oWise Item\u00A7r\u00A77 and increases its \u00A79Max Mana\u00A77.\u00A7r"));
		list.add(Component.literal("\u00A7r"));
		list.add(Component.literal("\u00A77Type: \u00A79Gemstone\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A7fCOMMAN\u00A7r"));
	}
}
