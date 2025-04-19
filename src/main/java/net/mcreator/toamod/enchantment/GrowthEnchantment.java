
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class GrowthEnchantment extends ToaEnchantment {
	public GrowthEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, ToaItemType.ARMOR, new int[]{10, 20, 30, 45, 65, 90, 125}, 40, slots);
		stats = (new ToaProperties()).hp(new float[]{15, 30, 45, 60, 75, 95, 135});
		prefixByLevel = 6;
	}

	@Override
	public int getMaxLevel() {
		return 7;
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases §Health §7by §c" + ToaFormats.floatToString(stats.HP[level - 1]) + "§7.";
	}
}
