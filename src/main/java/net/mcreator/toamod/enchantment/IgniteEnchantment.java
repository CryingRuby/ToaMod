
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaEnchantment;

public class IgniteEnchantment extends ToaEnchantment {
	public IgniteEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
		prefixByLevel = 2;
	}
	//values for burning dmg -> for balancing here combined
	public static final float[] values = {0.5f, 1, 1.5f};
	@Override
	public int getMaxLevel() {
		return 3;
	}
}
