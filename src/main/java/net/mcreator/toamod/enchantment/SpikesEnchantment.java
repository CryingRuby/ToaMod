
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class SpikesEnchantment extends ToaEnchantment {
	public SpikesEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, ToaItemType.ARMOR, new int[]{5, 10, 15, 20, 30, 50}, 30, slots);
		prefixByLevel = 5;
	}

	//values for dmg deflection -> For balancing here combined
	public static final float[] values = {0.005f, 0.01f, 0.015f, 0.02f, 0.025f, 0.03f};

	@Override
	public int getMaxLevel() {
		return 6;
	}

	@Override
	public String getDescription(int level) {
		return "§7Reflects §c" + ToaFormats.floatToString(values[level - 1] * 100) + "% §7 of §fPhysical Damage §7taken.";
	}
}
