package net.mcreator.toamod;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.CommonComponents;

public abstract class ToaEnchantment extends Enchantment {
	protected ToaProperties stats;
	protected ToaItemType itemType;
	protected String description;
	protected int[] xpCost;
	protected int mdCost; //UNUSED FOR NOW;		The md cost to apply the final level of an enchant

	//Level by which the epic color prefix is aplied to to enchantment name;   max Level is always golden color
	//Superior-enchantments NOT affected
	protected int prefixByLevel;
	

	public ToaEnchantment(Enchantment.Rarity rarity, EnchantmentCategory category, ToaItemType type, int[] xpCost, int mdCost, EquipmentSlot... slots) {
		super(rarity, category, slots);
		this.itemType = type;
		this.xpCost = xpCost;
		this.mdCost = mdCost;
	}

	public int getRarePrefixLevel() {
		return prefixByLevel;
	}

	public ToaProperties getProperties() {
		return this.stats;
	}

	public int[] getXpCost() {
		return this.xpCost;
	}

	public int getMDCost(){
		return this.mdCost;
	}

	/**
	 * Should return the description and modify the specific positions (insert numbers).
	 * For that somthing like "<1>, <2>, etc..." should be used and then description.replace(...).
	 * 
	 * @return return the description of the enchantment for a specific level of that enchant.
	 */
	public abstract String getDescription(int level);

	public boolean equalEnchantTypes(Enchantment ench) {
		System.out.println("equalEnchantTypes:  "+this.getDescriptionId()+" == "+ench.getDescriptionId()+" ?  => result: "+(this.getDescriptionId().equals(ench.getDescriptionId())));
		return this.getDescriptionId().equals(ench.getDescriptionId());
	}

	public String getEnchantName() {
		return Component.translatable(this.getDescriptionId()).getString();
	}

	@Override
	public Component getFullname(int level) {
		String name = "";
		if (level == this.getMaxLevel())
			name += "§6";
		else if (level >= prefixByLevel)
			name += "§5";
		else
			name += "§9";
		name += Component.translatable(this.getDescriptionId()).getString();
		if (this.getMaxLevel() > 1)
			name += " " + ToaFormats.RomanNumbers[level];
		return Component.literal(name);
	}

	public ToaEnchantment[] getIncompatibleEnchants(){
		return null;
	}
}
