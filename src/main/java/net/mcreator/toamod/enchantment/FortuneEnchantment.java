
package net.mcreator.toamod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.toamod.ToaProperties;
import net.mcreator.toamod.ToaItemType;
import net.mcreator.toamod.ToaFormats;
import net.mcreator.toamod.ToaEnchantment;

public class FortuneEnchantment extends ToaEnchantment {
	public FortuneEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, ToaItemType.PICKAXE, new int[]{10, 20, 35, 50, 80}, 35, slots);
		stats = (new ToaProperties()).minf(new float[]{10, 25, 40, 65, 100});
		prefixByLevel = 4;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public String getDescription(int level) {
		return "§7Increases §fMining Fortune §7by §c" + ToaFormats.floatToString(stats.MINF[level - 1]) + "§7.";
	}
}
