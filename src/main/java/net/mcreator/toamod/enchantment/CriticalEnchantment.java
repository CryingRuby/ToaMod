
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaEnchantment;

public class CriticalEnchantment extends ToaEnchantment {
	public CriticalEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
		stats = (new ToaProperties()).cd(new float[]{10, 20, 30, 40, 50, 70, 100});
		prefixByLevel = 6;
	}

	@Override
	public int getMaxLevel() {
		return 7;
	}
}
