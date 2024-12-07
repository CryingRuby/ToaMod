package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;


//A Rune is used as Itemstack but the Item-class has RuneType throw ToaRune-abst.-class
public enum RuneType {
	STR("str", '\u2694', "\u00A7c", (new ToaProperties()).str(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	DEX("dex", '\u03DF', "\u00A7a", (new ToaProperties()).dex(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	CON("con", '\u2743', "\u00A72", (new ToaProperties()).con(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	INT("int", '\u0E51', "\u00A7b", (new ToaProperties())._int(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	WIS("wis", '\u262F', "\u00A73", (new ToaProperties()).wis(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	CR("cr", '\u27B9', "\u00A74", (new ToaProperties()).cr(new float[]{1, 2, 3, 5, 7, 9, 12})),
	CD("cd", '\u2620', "\u00A74", (new ToaProperties()).cd(new float[]{6, 10, 14, 18, 22, 27, 33})),
	HP("hp", '\u2764', "\u00A7c", (new ToaProperties()).hp(new float[]{6, 12, 18, 24, 30, 36, 42})),
	AR("ar", '\u2726', "\u00A7e", (new ToaProperties()).ar(new float[]{4, 8, 12, 16, 20, 25, 30})), 
	MR("mr", '\u2671', "\u00A79", (new ToaProperties()).mr(new float[]{4, 8, 12, 16, 20, 25, 30})),
	MF("mf", '\u2724', "\u00A72", (new ToaProperties()).mf(new float[]{0, 0, 0, 0.5f, 1, 2, 3.5f, 5})), 
	MINF("minf", '\u26CF', "\u00A76", (new ToaProperties()).minf(new float[]{3, 6, 9, 12, 16, 20, 25}));

	RuneType(String name, char symbol, String symbolColor, ToaProperties stats) {
		this.name = name;
		this.stats = stats;
		this.symbol = symbol;
		this.symbolColor = symbolColor;
	}

	public final String name;
	private ToaProperties stats;
	public final String symbolColor;
	public final char symbol;

	public static RuneType getByRuneItem(ItemStack item) {
		String type = item.getOrCreateTag().getString("runeType");
		return getByID(type);
	}

	public static RuneType getByID(String id){
		return switch(id){
			case "str" -> STR;
			case "dex" -> DEX;
			case "con" -> CON;
			case "int" -> INT;
			case "wis" -> WIS;
			case "cr" -> CR;
			case "cd" -> CD;
			case "hp" -> HP;
			case "ar" -> AR;
			case "mr" -> MR;
			case "mf" -> MF;
			case "minf" -> MINF;
			default -> null;
		};
	}

	public ToaProperties getProperties(){
		return stats;
	}
	
}
