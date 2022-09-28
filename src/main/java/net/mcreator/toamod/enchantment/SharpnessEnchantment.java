
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.init.ToamodModEnchantments;

public class SharpnessEnchantment extends Enchantment {
	public SharpnessEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 10;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench == ToamodModEnchantments.EXECUTING.get() || ench == ToamodModEnchantments.LIFE_STEEL.get();
	}
}
