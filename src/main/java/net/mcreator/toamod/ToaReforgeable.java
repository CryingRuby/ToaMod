package net.mcreator.toamod;

import net.minecraft.world.item.Item;

public abstract class ToaReforgeable extends Item {
	protected ToaProperties toaProperties;
	public RuneSlot[] runeSlots;
	public ReforgeType reforge;
	public String stackableType;
	public int stackableEnhancement; //Grindstones for weapons, Refinement for pickaxes, Hardened Scale for Armor, etc..
	public int stars;

	//public int prestige;     --  prestige like kuudra armor (burning, fiery, infernal, etc..)
	//public Attribute[] attributes = new Attribute[2];    -- or something like this
	public ToaReforgeable(Item.Properties props) {
		super(props);
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	public ToaProperties getProperties(){
		return this.toaProperties;
	}
}
