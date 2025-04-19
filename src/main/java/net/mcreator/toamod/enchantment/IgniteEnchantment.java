
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class IgniteEnchantment extends ToaEnchantment {
	public IgniteEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, ToaItemType.SWORD, new int[]{10, 20, 50}, 40, slots);
		prefixByLevel = 2;
	}

	//values for burning dmg -> for balancing here combined
	public static final float[] values = {0.005f, 0.01f, 0.015f};

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public String getDescription(int level) {
		return "§7On Hit: Burns the enemy for §c" + ToaFormats.floatToString(values[level - 1] * 100) + "% \n§7of the enemy's §fMax Health§7 per second.";
	}
}
