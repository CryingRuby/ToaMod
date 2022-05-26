
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ScrollBerserkItem extends Item {
	public ScrollBerserkItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("\u00A77Rarity:\u00A75Epic\u00A7r"));
		list.add(new TextComponent("\u00A77Type: \u00A79Scroll\u00A7r"));
		list.add(new TextComponent("\u00A76Ability: \u00A77Increases your damage by 2 and armor by 5 for 5s (30s Cooldown)\u00A7r"));
	}
}
