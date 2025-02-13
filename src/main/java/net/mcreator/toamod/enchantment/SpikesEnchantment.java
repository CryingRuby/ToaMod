
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaEnchantment;

public class SpikesEnchantment extends ToaEnchantment {
	public SpikesEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, slots);
		prefixByLevel = 5;
	}

	//values for dmg deflection -> For balancing here combined
	public static final float[] values = {0.5f, 1, 1.5f, 2, 2.5f, 3};

	@Override
	public int getMaxLevel() {
		return 6;
	}
}
