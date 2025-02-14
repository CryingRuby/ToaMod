package net.mcreator.toamod;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public abstract class ToaEnchantment extends Enchantment {
	public ToaEnchantment(Enchantment.Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
		super(rarity, category, slots);
	}
	protected ToaProperties stats;

	//Level by which the epic color prefix is aplied to to enchantment name;   max Level is always golden color
	//Superior-enchantments NOT affected
	protected int prefixByLevel;

	public int getRarePrefixLevel(){
		return prefixByLevel;
	}

	public ToaProperties getProperties(){
		return this.stats;
	}
}
