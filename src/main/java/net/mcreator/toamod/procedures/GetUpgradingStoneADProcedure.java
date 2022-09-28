package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;
import java.util.Map;

public class GetUpgradingStoneADProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double bonusAD = 0;
		double rarity = 0;
		rarity = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity");
		bonusAD = 0;
		if (("Strong").equals((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("upgradingType"))) {
			bonusAD = 1 + 2 * rarity;
		} else if (("Forceful").equals((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("upgradingType"))) {
			if (rarity <= 1) {
				bonusAD = 1 + rarity;
			} else {
				bonusAD = rarity;
			}
		} else if (("Balanced").equals((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("upgradingType"))) {
			if (rarity <= 1) {
				bonusAD = 1 + rarity;
			} else {
				bonusAD = 2 * rarity - 1;
			}
		} else if (("Superior").equals((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("upgradingType"))) {
			if (rarity <= 1) {
				bonusAD = 0.5 + 0.5 * rarity;
			} else if (rarity > 1 && rarity <= 3) {
				bonusAD = rarity - 1;
			} else {
				bonusAD = 1.5 + 1 * (rarity - 3);
			}
		} else if (("Empowered").equals((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("upgradingType"))) {
			if (rarity <= 2) {
				bonusAD = 1 + rarity;
			} else {
				bonusAD = 3.5 + 1.5 * (rarity - 2);
			}
		}
		return bonusAD;
	}
}
