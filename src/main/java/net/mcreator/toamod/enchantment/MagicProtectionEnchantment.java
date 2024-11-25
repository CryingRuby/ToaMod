
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.init.ToamodModEnchantments;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaEnchantment;

import java.util.List;

public class MagicProtectionEnchantment extends ToaEnchantment {
	public MagicProtectionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, slots);
		stats = (new ToaProperties()).mr(new float[]{8, 18, 30, 44, 60, 85});
		prefixByLevel = 5;
	}

	@Override
	public int getMaxLevel() {
		return 6;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(ToamodModEnchantments.PROTECTION.get()).contains(ench);
	}
}
