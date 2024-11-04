
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class GemstonePearlItem extends Item {
	public GemstonePearlItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7r"));
		list.add(Component.literal("\u00A77Upgrades sword or staff into \u00A7oBalanced Sword/Staff\u00A7r\u00A77 and increases its \u00A7cAttack Damage\u00A77 and \u00A75Ability Power\u00A77.\u00A7r"));
		list.add(Component.literal("\u00A7r"));
		list.add(Component.literal("\u00A77Type: \u00A79Gemstone\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A7fCOMMAN\u00A7r"));
	}
}
