
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.procedures.EnchantableBookActivatedProcedure;
import net.mcreator.toamod.procedures.BookSharpness9CraftedProcedure;

import java.util.List;

public class BookSharpness9Item extends Item {
	public BookSharpness9Item() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).rarity(Rarity.COMMON));
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
		list.add(new TextComponent("\u00A77Rarity: \u00A7fComman"));
		list.add(new TextComponent("\u00A77Type: \u00A79Enchantment Book\u00A7r"));
		list.add(new TextComponent("\u00A77Sharpness IX\u00A7r"));
		list.add(new TextComponent("\u00A77Right Click to activate enchantment with \u00A7b175 magic dust\u00A77.\u00A7r"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		EnchantableBookActivatedProcedure.execute(entity, itemstack);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		EnchantableBookActivatedProcedure.execute(context.getPlayer(), context.getItemInHand());
		return retval;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		BookSharpness9CraftedProcedure.execute(itemstack);
	}
}
