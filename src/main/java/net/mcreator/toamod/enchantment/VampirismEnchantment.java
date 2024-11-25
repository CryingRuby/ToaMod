
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaEnchantment;

public class VampirismEnchantment extends ToaEnchantment {
	public VampirismEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
		stats = (new ToaProperties()).lifesteal(new float[]{1.5f, 2.5f, 4, 6});
		prefixByLevel = 3;
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}
}
