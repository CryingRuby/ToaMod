
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaEnchantment;

public class ExecutingEnchantment extends ToaEnchantment {
	public ExecutingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
		prefixByLevel = 5;
	}
	public static final float[] values = {0.5f, 1, 1.5f, 2, 2.5f, 3};

	@Override
	public int getMaxLevel() {
		return 6;
	}
}
