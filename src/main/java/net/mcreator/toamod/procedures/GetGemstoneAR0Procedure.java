package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class GetGemstoneAR0Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double bonusAR = 0;
		double rarity = 0;
		rarity = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity");
		bonusAR = 0;
		if (("Hardened").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			bonusAR = 25 + 25 * rarity;
		} else if (("Bulletproof").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			if (rarity <= 1) {
				bonusAR = 50 + 35 * rarity;
			} else if (rarity <= 3) {
				bonusAR = 60 * rarity + 5;
			} else {
				bonusAR = 125 * rarity - 225;
			}
		} else if (("Empowered").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			bonusAR = 5 + 5 * rarity;
		}
		return bonusAR;
	}
}
