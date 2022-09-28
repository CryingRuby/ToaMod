
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.init.ToamodModEnchantments;

public class ProtectionEnchantment extends Enchantment {
	public ProtectionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return ench == ToamodModEnchantments.SPIKES.get() || ench == ToamodModEnchantments.STICKY_FEET.get();
	}
}
