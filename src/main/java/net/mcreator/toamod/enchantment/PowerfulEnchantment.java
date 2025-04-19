
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.init.ToamodModEnchantments;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

import java.util.List;

public class PowerfulEnchantment extends ToaEnchantment {
	public PowerfulEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, ToaItemType.SWORD, new int[]{5, 10, 15, 20, 30, 40, 55, 75, 100, 150}, 50, slots);
		stats = (new ToaProperties())._int(new float[]{4, 8, 13, 18, 24, 30, 37, 45, 55, 75});
		prefixByLevel = 7;
	}

	//values for the percentage elemental dmg increase -> fpr balancing here combined
	public static final float[] values = {0.02f, 0.04f, 0.06f, 0.08f, 0.1f, 0.12f, 0.14f, 0.16f, 0.18f, 0.2f};

	@Override
	public int getMaxLevel() {
		return 10;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(ToamodModEnchantments.SHARPNESS.get()).contains(ench);
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases §nIntelligence §7by §c" + ToaFormats.floatToString(stats.INT[level - 1]) + " \n§7and §fElemental Damage §7by §c" + ToaFormats.floatToString(values[level - 1] * 100) + "%§7.";
	}

	@Override
	public ToaEnchantment[] getIncompatibleEnchants() {
		return new ToaEnchantment[]{(ToaEnchantment) ToamodModEnchantments.SHARPNESS.get()};
	}
}
