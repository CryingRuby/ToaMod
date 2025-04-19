
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class CriticalEnchantment extends ToaEnchantment {
	public CriticalEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, ToaItemType.SWORD, new int[]{10, 20, 30, 45, 65, 90, 125}, 50, slots);
		stats = (new ToaProperties()).cd(new float[]{10, 20, 30, 40, 50, 70, 100});
		prefixByLevel = 6;
	}

	@Override
	public int getMaxLevel() {
		return 7;
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases §cCritcal Damage §7by §c" + ToaFormats.floatToString(stats.CD[level - 1]) + "§7.";
	}
}
