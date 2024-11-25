
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaEnchantment;

public class ScavengerEnchantment extends ToaEnchantment {
	public ScavengerEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
		prefixByLevel = 3;
	}

	//values for cor per kill per level of mob -> for balancing here combined
	public static float[] values = {0.25f, 0.5f, 1, 1.5f};

	@Override
	public int getMaxLevel() {
		return 4;
	}
}
