
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class ExecutingEnchantment extends ToaEnchantment {
	public ExecutingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, ToaItemType.SWORD, new int[]{5, 10, 15, 20, 30, 50}, 45, slots);
		prefixByLevel = 5;
	}

	//dmg increase % per 1% missing health
	public static final float[] values = {0.005f, 0.01f, 0.015f, 0.02f, 0.025f, 0.03f};

	@Override
	public int getMaxLevel() {
		return 6;
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases damage dealt by §c" + ToaFormats.floatToString(values[level - 1] * 100) + "% \n§7for every §c1% §fHealth §7missing on the enemy.";
	}
}
