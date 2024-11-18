package net.mcreator.toamod;

public interface IToaReforgeable {
	//public ToaProperties toaProperties = new ToaProperties();
	public RuneSlot[] runeSlots = null;
	public ReforgeType reforge = null;
	public String stackableType = "";
	public int stackableEnhancement = 0; //Grindstones for weapons, Refinement for pickaxes, Hardened Scale for Armor, etc..
	public int stars = 0;
	//public int prestige;     --  prestige like kuudra armor (burning, fiery, infernal, etc..)
	//public Attribute[] attributes = new Attribute[2];    -- or something like this
}
