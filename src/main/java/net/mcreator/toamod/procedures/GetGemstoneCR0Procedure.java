package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class GetGemstoneCR0Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double bonusCR = 0;
		double rarity = 0;
		rarity = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity");
		bonusCR = 0;
		if (("Forceful").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 2) {
				bonusCR = 2 + 3 * rarity;
			} else {
				bonusCR = 5 * rarity - 3;
			}
		} else if (("Superior").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 2) {
				bonusCR = 1 + rarity;
			} else if (rarity == 3) {
				bonusCR = 5;
			} else {
				bonusCR = 2 * rarity - 2;
			}
		} else if (("Empowered")
				.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))
				|| ("Miraculous").equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("gemstoneType"))) {
			if (rarity == 0) {
				bonusCR = 1;
			} else {
				bonusCR = 2 * rarity;
			}
		}
		return bonusCR;
	}
}
