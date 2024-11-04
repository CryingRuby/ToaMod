
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class MythicRuneScrollItem extends Item {
	public MythicRuneScrollItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Use in \u00A7bMagic Crafter \u00A77to upgrade a \u00A76Legendary Rune\u00A77 into a \u00A7cMythic Rune \u00A77(only once per rune type).\u00A7r"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77Type: \u00A79Special\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A7cMYTHIC\u00A7r"));
	}
}
