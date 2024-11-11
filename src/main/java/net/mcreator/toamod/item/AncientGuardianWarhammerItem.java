
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.ToaRarity;
import net.mcreator.toamod.ToaProperties;

import java.util.List;

public class AncientGuardianWarhammerItem extends SwordItem {
	public AncientGuardianWarhammerItem() {
		toaProperties = new ToaProperties("Sword", ToaRarity.ANCIENT).str(new float[]{800, 15}).dex(-25);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Rarity: \u00A7cMythic\u00A7r"));
		list.add(Component.literal("\u00A77Type: \u00A79Sword\u00A7r"));
	}
}
