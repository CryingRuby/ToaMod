
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;
import net.mcreator.toamod.ISuperiorEnchantment;

public class ChimeraEnchantment extends ToaEnchantment implements ISuperiorEnchantment {
	public ChimeraEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, ToaItemType.SWORD, new int[]{25, 50, 75, 125, 200}, 100, slots);
	}

	public static final float[] values = {0.2f, 0.4f, 0.6f, 0.8f, 1};

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public String getDescription(int level) {
		return "§7Copies §c" + ToaFormats.floatToString(values[level - 1] * 100) + "% §7of your pet's stats.";
	}
}
