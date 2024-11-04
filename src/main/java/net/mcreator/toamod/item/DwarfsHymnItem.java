
package net.mcreator.toamod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.procedures.DwarfsHymnUsedProcedure;
import net.mcreator.toamod.procedures.DwarfsHymnTickProcedure;

import java.util.List;

public class DwarfsHymnItem extends Item {
	public DwarfsHymnItem() {
		super(new Item.Properties().durability(100).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77Right Click to gain \u00A73HASTE I \u00A77for 15 minutes.\u00A7r"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77Type: \u00A79Special\u00A7r"));
		list.add(Component.literal("\u00A77Rarity: \u00A76LEGENDARY\u00A7r"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		DwarfsHymnUsedProcedure.execute(entity, ar.getObject());
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		DwarfsHymnTickProcedure.execute(itemstack);
	}
}
