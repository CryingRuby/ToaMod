package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;


//A Rune is used as Itemstack but the Item-class has RuneType throw ToaRune-abst.-class
public enum RuneType {
	STR("str", (new ToaProperties()).str(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	DEX("dex", (new ToaProperties()).dex(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	CON("con", (new ToaProperties()).con(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	INT("int", (new ToaProperties())._int(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	WIS("wis", (new ToaProperties()).wis(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	CR("cr", (new ToaProperties()).cr(new float[]{1, 2, 3, 5, 7, 9, 12})),
	CD("cd", (new ToaProperties()).cd(new float[]{6, 10, 14, 18, 22, 27, 33})),
	HP("hp", (new ToaProperties()).hp(new float[]{6, 12, 18, 24, 30, 36, 42})),
	AR("ar", (new ToaProperties()).ar(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	MR("mr", (new ToaProperties()).mr(new float[]{4, 8, 12, 16, 20, 25, 30})),
	MF("mf", (new ToaProperties()).mf(new float[]{0, 0, 0, 0.5f, 1, 2, 3.5f, 5})), 
	MINF("minf", (new ToaProperties()).minf(new float[]{3, 6, 9, 12, 16, 20, 25}));

	RuneType(String name, ToaProperties stats) {
		this.name = name;
		this.stats = stats;
	}

	public final String name;
	private ToaProperties stats;

	public static RuneType getByItem(ItemStack item) {
		String type = item.getOrCreateTag().getString("runeType");
		return switch(type){
			case "dex" -> DEX;
			case "con" -> CON;
			case "int" -> INT;
			case "wis" -> WIS;
			case "cr" -> CR;
			case "cd" -> CD;
			case "ar" -> AR;
			case "mr" -> MR;
			case "mf" -> MF;
			case "minf" -> MINF;
			default -> STR;
		};
	}

	public ToaProperties getProperties(){
		return stats;
	}
	
}
