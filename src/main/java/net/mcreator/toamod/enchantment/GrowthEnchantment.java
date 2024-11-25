
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaEnchantment;

public class GrowthEnchantment extends ToaEnchantment {
	public GrowthEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, slots);
		stats = (new ToaProperties()).hp(new float[]{15, 30, 45, 60, 75, 95, 135});
		prefixByLevel = 6;
	}

	@Override
	public int getMaxLevel() {
		return 7;
	}
}
