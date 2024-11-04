package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class GetGemstoneMANA1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double bonusMana = 0;
		double rarity = 0;
		rarity = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity");
		bonusMana = 0;
		if (("Wise").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 1) {
				bonusMana = 20 + 15 * rarity;
			} else if (rarity <= 3) {
				bonusMana = 5 + 25 * rarity;
			} else {
				bonusMana = 40 * rarity - 50;
			}
		} else if (("Superior").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			bonusMana = 5 + 5 * rarity;
		}
		return bonusMana;
	}
}
