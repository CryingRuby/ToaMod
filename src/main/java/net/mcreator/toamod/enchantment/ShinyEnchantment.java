
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaEnchantment;

public class ShinyEnchantment extends ToaEnchantment {
	public ShinyEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
		prefixByLevel = 2;
	}

	//chance increase to find pure materials -> for balancing here combined
	public static float[] values = {2.5f, 5, 10};

	@Override
	public int getMaxLevel() {
		return 3;
	}
}
