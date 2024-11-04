package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class GetGemstoneAD2Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double bonusAD = 0;
		double rarity = 0;
		rarity = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity");
		bonusAD = 0;
		if (("Strong").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			bonusAD = 5 + 10 * rarity;
		} else if (("Forceful").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 1) {
				bonusAD = 5 + 5 * rarity;
			} else {
				bonusAD = 5 * rarity;
			}
		} else if (("Balanced").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 1) {
				bonusAD = 5 + 5 * rarity;
			} else {
				bonusAD = 10 * rarity - 5;
			}
		} else if (("Superior").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 2) {
				bonusAD = 2 + 2 * rarity;
			} else {
				bonusAD = 4 * rarity - 3;
			}
		} else if (("Empowered").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 2) {
				bonusAD = 5 + 5 * rarity;
			} else if (rarity <= 4) {
				bonusAD = 8 * rarity - 2;
			} else {
				bonusAD = 40;
			}
		}
		return bonusAD;
	}
}
