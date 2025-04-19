
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class ShinyEnchantment extends ToaEnchantment {
	public ShinyEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, ToaItemType.PICKAXE, new int[]{10, 20, 45}, 25, slots);
		prefixByLevel = 2;
	}

	//chance increase to find pure materials -> for balancing here combined
	public static final float[] values = {0.025f, 0.05f, 0.1f};

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases chance of finding pure materials while mining by §c" + ToaFormats.floatToString(values[level - 1] * 100) + "%§7.";
	}
}
