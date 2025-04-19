
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class DivineGiftEnchantment extends ToaEnchantment {
	public DivineGiftEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, ToaItemType.SWORD, new int[]{15, 30, 60, 100}, 60, slots);
		stats = (new ToaProperties()).mf(new float[]{2, 4, 6, 10});
		prefixByLevel = 3;
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases §fMagic Find §7by §c" + ToaFormats.floatToString(stats.MF[level - 1]) + "§7.";
	}
}
