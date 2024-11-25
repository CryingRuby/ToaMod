
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaEnchantment;

public class DivineGiftEnchantment extends ToaEnchantment {
	public DivineGiftEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
		stats = (new ToaProperties()).mf(new float[]{2, 4, 6, 10});
		prefixByLevel = 3;
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}
}
