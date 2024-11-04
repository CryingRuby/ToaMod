package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class GetGemstoneCD2Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double bonusCD = 0;
		double rarity = 0;
		rarity = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity");
		bonusCD = 0;
		if (("Forceful").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity == 0) {
				bonusCD = 7;
			} else if (rarity <= 3) {
				bonusCD = 5 + 10 * rarity;
			} else {
				bonusCD = 15 * rarity - 10;
			}
		} else if (("Superior").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 2) {
				bonusCD = 4 + 4 * rarity;
			} else if (rarity <= 4) {
				bonusCD = 6 * rarity - 1;
			} else {
				bonusCD = 30;
			}
		} else if (("Empowered")
				.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))
				|| ("Miraculous").equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("gemstoneType"))) {
			if (rarity <= 2) {
				bonusCD = 4 + 2 * rarity;
			} else if (rarity <= 4) {
				bonusCD = 4 * rarity - 1;
			} else {
				bonusCD = 20;
			}
		}
		return bonusCD;
	}
}
