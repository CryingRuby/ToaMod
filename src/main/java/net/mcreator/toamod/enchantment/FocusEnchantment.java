
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaEnchantment;

public class FocusEnchantment extends ToaEnchantment {
	public FocusEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
		prefixByLevel = 3;
	}

	//elemental dmg increase -> for balancing here combined
	public static final float[] values = {3, 6, 9, 15};

	@Override
	public int getMaxLevel() {
		return 4;
	}
}
