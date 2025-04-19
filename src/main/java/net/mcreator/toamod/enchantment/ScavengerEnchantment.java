
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class ScavengerEnchantment extends ToaEnchantment {
	public ScavengerEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, ToaItemType.SWORD, new int[]{10, 20, 30, 50}, 25, slots);
		prefixByLevel = 3;
	}

	//values for cor per kill per level of mob -> for balancing here combined
	public static final float[] values = {0.25f, 0.5f, 1, 1.5f};

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public String getDescription(int level) {
		return "§7On Kill: Gain §c" + ToaFormats.floatToString(values[level - 1]) + " §7additonal §6Cor \n§7per §fLevel§7 of the enemy.";
	}
}
