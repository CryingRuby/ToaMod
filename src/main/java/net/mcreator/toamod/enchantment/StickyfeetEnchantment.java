
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaEnchantment;

public class StickyfeetEnchantment extends ToaEnchantment {
	public StickyfeetEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
		prefixByLevel = 4;
	}

	//knockback resistance -> for balancing here combined
	public static final float[] values = {0.2f, 0.4f, 0.6f, 0.8f, 1};

	@Override
	public int getMaxLevel() {
		return 5;
	}
}
