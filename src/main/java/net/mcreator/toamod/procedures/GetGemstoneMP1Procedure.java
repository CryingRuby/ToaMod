package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class GetGemstoneMP1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double bonusAP = 0;
		double rarity = 0;
		rarity = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity");
		bonusAP = 0;
		if (("Magical").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 1) {
				bonusAP = 10 + 10 * rarity;
			} else if (rarity <= 4) {
				bonusAP = 20 * rarity - 5;
			} else {
				bonusAP = 100;
			}
		} else if (("Balanced").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			bonusAP = 10 + 10 * rarity;
		} else if (("Superior").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity == 0) {
				bonusAP = 5;
			} else if (rarity <= 3) {
				bonusAP = 4 + 3 * rarity;
			} else {
				bonusAP = 7 * rarity - 10;
			}
		} else if (("Miraculous").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 1) {
				bonusAP = 10 + 10 * rarity;
			} else if (rarity <= 4) {
				bonusAP = 15 * rarity - 5;
			} else {
				bonusAP = 75;
			}
		}
		return bonusAP;
	}
}
