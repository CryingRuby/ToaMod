
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.init.ToamodModEnchantments;
import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

import java.util.List;

public class MagicProtectionEnchantment extends ToaEnchantment {
	public MagicProtectionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, ToaItemType.ARMOR, new int[]{5, 10, 20, 30, 50, 80}, 30, slots);
		stats = (new ToaProperties()).mr(new float[]{8, 18, 30, 44, 60, 85});
		prefixByLevel = 5;
	}

	@Override
	public int getMaxLevel() {
		return 6;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(ToamodModEnchantments.PROTECTION.get()).contains(ench);
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases §fMagic Resistance §7by §c" + ToaFormats.floatToString(stats.MR[level - 1]) + "§7.";
	}

	@Override
	public ToaEnchantment[] getIncompatibleEnchants() {
		return new ToaEnchantment[]{(ToaEnchantment) ToamodModEnchantments.PROTECTION.get()};
	}
}
