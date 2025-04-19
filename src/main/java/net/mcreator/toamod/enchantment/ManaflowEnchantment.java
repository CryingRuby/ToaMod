
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class ManaflowEnchantment extends ToaEnchantment {
	public ManaflowEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, ToaItemType.SWORD, new int[]{10, 20, 30, 50}, 25, slots);
		prefixByLevel = 3;
	}

	//bonus Mana
	public static final float[] values = {20, 40, 70, 100};

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases §fMana §7by §c" + ToaFormats.floatToString(values[level - 1]) + "§7.";
	}
}
