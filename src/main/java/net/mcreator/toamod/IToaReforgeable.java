package net.mcreator.toamod;

public interface IToaReforgeable {
	public RuneSlot[] RuneSlots = null;
	public ReforgeType Reforge = null;
	public int stackableEnhancement = 0; //Grindstones for weapons, Refinement for pickaxes, Hardened Scale for Armor, etc..
	public int stars = 0;
	//public int prestige;     --  prestige like kuudra armor (burning, fiery, infernal, etc..)
	//public Attribute[] attributes = new Attribute[2];    -- or something like this
}
