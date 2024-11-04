package net.mcreator.toamod.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.init.ToamodModEnchantments;

import java.util.function.Supplier;
import java.util.Map;

public class GetEnchantsToLoreTxtOutputProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String enchants = "";
		String tempEnchLvlPrefix = "";
		String enchName = "";
		String enchLvlRoman = "";
		boolean existingEnch = false;
		double i = 0;
		double enchAmounts = 0;
		existingEnch = false;
		enchants = "'{\"text\":\"";
		enchAmounts = 0;
		i = 0;
		for (int index0 = 0; index0 < 14; index0++) {
			if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 0) {
				if (10 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (7 < (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.sharpness").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 1) {
				if (6 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (5 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.executing").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 2) {
				if (4 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get())) {
					tempEnchLvlPrefix = " \u00A76";
				} else if (3 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.lifesteal").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.CRITICAL.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 3) {
				if (7 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (6 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.critical").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 4) {
				if (4 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (3 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.manaflow").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 5) {
				if (4 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (3 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.scavenger").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.POWERFUL.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 6) {
				if (10 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (8 <= (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.powerful").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.FORTUNE.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 12) {
				if (5 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (4 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.fortune").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.PROTECTION.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 8) {
				if (6 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (5 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.protection").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 9) {
				if (6 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (5 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.magicshield").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SPIKES.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 10) {
				if (6 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (5 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.spikes").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.SPIKES.get())))))
						.getString();
				existingEnch = true;
			} else if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)) != 0 && i == 11) {
				if (5 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get())) {
					tempEnchLvlPrefix = "\u00A76";
				} else if (4 == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get())) {
					tempEnchLvlPrefix = "\u00A75";
				} else {
					tempEnchLvlPrefix = "\u00A79";
				}
				enchName = Component.translatable("enchantment.toamod.stickyfeet").getString();
				enchLvlRoman = Component.translatable(("number.roman."
						+ (new java.text.DecimalFormat("##").format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get())))))
						.getString();
				existingEnch = true;
			}
			if (existingEnch) {
				enchants = enchants + "" + tempEnchLvlPrefix + enchName + " " + enchLvlRoman + "\u00A77, ";
				enchAmounts = enchAmounts + 1;
				if (enchAmounts % 2 == 0 && enchAmounts > 0) {
					enchants = enchants + "" + "\u00A7r\"}','{\"text\":\"";
				}
			}
			existingEnch = false;
			i = i + 1;
		}
		if (!(enchants).equals("'{\"text\":\"")) {
			enchants = enchants + "end";
			enchants = enchants.replace("\u00A77, \u00A7r\"}','{\"text\":\"end", "");
			enchants = enchants.replace("\u00A77, end", "");
			enchants = enchants + "" + "\u00A7r\"}','{\"text\":\"\"}',";
		} else {
			enchants = "";
		}
		return enchants;
	}
}
