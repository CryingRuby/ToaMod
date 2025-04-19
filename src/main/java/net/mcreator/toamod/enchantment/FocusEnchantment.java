
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class FocusEnchantment extends ToaEnchantment {
	public FocusEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, ToaItemType.SWORD, new int[]{10, 20, 30, 50}, 15, slots);
		prefixByLevel = 3;
	}

	//additional crit dmg for elemental damage
	public static final float[] values = {5, 10, 15, 25};

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public String getDescription(int level) {
		return "§fElemental Damage §7can critical strike with\n an additional §c" + ToaFormats.floatToString(values[level - 1]) + "% §fCritical Damage§7.";
	}
}
