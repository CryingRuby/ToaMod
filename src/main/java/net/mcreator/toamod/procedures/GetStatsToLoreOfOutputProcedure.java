package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;
import java.util.Map;

public class GetStatsToLoreOfOutputProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		boolean gemDecimal = false;
		boolean gemApplied = false;
		double i = 0;
		double tempGemValue = 0;
		String tempStatTxt = "";
		String tempStatGem = "";
		String tempStatRune = "";
		String statType = "";
		String tempEnchs = "";
		String statsToLore = "";
		i = 0;
		for (int index0 = 0; index0 < 13; index0++) {
			tempStatGem = "";
			gemDecimal = false;
			gemApplied = false;
			if (i == 0) {
				statType = "AD";
				if (0 < GetGemstoneAD0Procedure.execute(entity)) {
					gemApplied = true;
					if (0 == GetGemstoneAD0Procedure.execute(entity) - Math.floor(GetGemstoneAD0Procedure.execute(entity))) {
						gemDecimal = true;
						tempGemValue = GetGemstoneAD0Procedure.execute(entity);
					}
				}
			} else if (i == 1) {
				statType = "MP";
				if (0 < GetGemstoneMP0Procedure.execute(entity)) {
					gemApplied = true;
					if (0 == GetGemstoneMP0Procedure.execute(entity) - Math.floor(GetGemstoneMP0Procedure.execute(entity))) {
						gemDecimal = true;
						tempGemValue = GetGemstoneMP0Procedure.execute(entity);
					}
				}
			} else if (i == 2) {
				statType = "AR";
				if (0 < GetGemstoneAR0Procedure.execute(entity)) {
					gemApplied = true;
					if (0 == GetGemstoneAR0Procedure.execute(entity) - Math.floor(GetGemstoneAR0Procedure.execute(entity))) {
						gemDecimal = true;
						tempGemValue = GetGemstoneAR0Procedure.execute(entity);
					}
				}
			} else if (i == 3) {
				statType = "MR";
				if (0 < GetGemstoneMR0Procedure.execute(entity)) {
					gemApplied = true;
					if (0 == GetGemstoneMR0Procedure.execute(entity) - Math.floor(GetGemstoneMR0Procedure.execute(entity))) {
						gemDecimal = true;
						tempGemValue = GetGemstoneMR0Procedure.execute(entity);
					}
				}
			} else if (i == 4) {
				statType = "CR";
				if (0 < GetGemstoneCR0Procedure.execute(entity)) {
					gemApplied = true;
					if (0 == GetGemstoneCR0Procedure.execute(entity) - Math.floor(GetGemstoneCR0Procedure.execute(entity))) {
						gemDecimal = true;
						tempGemValue = GetGemstoneCR0Procedure.execute(entity);
					}
				}
			} else if (i == 5) {
				statType = "CD";
				if (0 < GetGemstoneCD0Procedure.execute(entity)) {
					gemApplied = true;
					if (0 == GetGemstoneCD0Procedure.execute(entity) - Math.floor(GetGemstoneCD0Procedure.execute(entity))) {
						gemDecimal = true;
						tempGemValue = GetGemstoneCD0Procedure.execute(entity);
					}
				}
			} else if (i == 6) {
				statType = "MANA";
				if (0 < GetGemstoneMANA0Procedure.execute(entity)) {
					gemApplied = true;
					if (0 == GetGemstoneMANA0Procedure.execute(entity) - Math.floor(GetGemstoneMANA0Procedure.execute(entity))) {
						gemDecimal = true;
						tempGemValue = GetGemstoneMANA0Procedure.execute(entity);
					}
				}
			} else if (i == 7) {
				statType = "MF";
			} else if (i == 8) {
				statType = "MINF";
			} else if (i == 9) {
				statType = "ComWIS";
			} else if (i == 10) {
				statType = "MinWIS";
			} else if (i == 11) {
				statType = "MagWIS";
			} else {
				statType = "CookWIS";
			}
			if (gemApplied) {
				if (gemDecimal) {
					tempStatGem = " \u00A76[" + new java.text.DecimalFormat("##").format(tempGemValue) + "]\u00A7r";
				} else {
					tempStatGem = " \u00A76]" + tempGemValue + "]\u00A7r";
				}
			}
			if (0 < (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble(statType)) {
				if (0 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble(statType)
						- Math.floor((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble(statType))) {
					tempStatTxt = new java.text.DecimalFormat("##").format(
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble(statType));
				} else {
					tempStatTxt = new java.text.DecimalFormat("##.##").format(
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble(statType));
				}
				if ("CR,CD".contains(statType)) {
					tempStatTxt = tempStatTxt + "%";
				}
				if ((statType).equals(
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("runeType"))) {
					if (0 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("runeValue")
							- Math.floor((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("runeValue"))) {
						tempStatRune = " \u00A7d(" + (new java.text.DecimalFormat("##")
								.format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
										.getDouble("runeValue")))
								+ ")\u00A7r";
					} else {
						tempStatRune = " \u00A7d(" + (new java.text.DecimalFormat("##.##")
								.format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
										.getDouble("runeValue")))
								+ ")\u00A7r";
					}
				} else {
					tempStatRune = "";
				}
				statsToLore = statsToLore + "" + "'{\"text\":\"\u00A77" + Component.translatable(("stat." + (statType).toLowerCase())).getString() + ": \u00A7c+" + tempStatTxt + tempStatGem + tempStatRune + "\"}',";
			}
			i = i + 1;
		}
		if (!("").equals(statsToLore)) {
			if (!(("Artefact")
					.equals((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("type")))) {
				statsToLore = "'{\"text\":\"\"}'," + "" + statsToLore;
			}
			statsToLore = statsToLore + "" + "'{\"text\":\"\"}',";
		}
		return statsToLore;
	}
}
