
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class GoldenKeyItem extends Item {
	public GoldenKeyItem() {
		super(new Item.Properties().stacksTo(4).rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7r"));
		list.add(Component.literal("\u00A77Used to open a Golden Chest\u00A7r"));
		list.add(Component.literal("\u00A7r"));
		list.add(Component.literal("\u00A77Type: \u00A79Special\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A76LEGANDARY\u00A7r"));
	}
}
