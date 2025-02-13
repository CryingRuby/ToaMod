
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.init.ToamodModEnchantments;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaEnchantment;

import java.util.List;

public class SharpnessEnchantment extends ToaEnchantment {
	public SharpnessEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
		stats = (new ToaProperties()).str(new float[]{4, 8, 13, 18, 24, 30, 37, 45, 55, 75});
		prefixByLevel = 7;
	}

	//values for the percentage physical dmg increase -> fpr balancing here combined
	public static final float[] values = {0.02f, 0.04f, 0.06f, 0.08f, 0.1f, 0.12f, 0.14f, 0.16f, 0.18f, 0.2f};

	@Override
	public int getMaxLevel() {
		return 10;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(ToamodModEnchantments.POWERFUL.get()).contains(ench);
	}
}
